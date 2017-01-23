package com.cardpay.mgt.menu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.annotation.SystemServiceLog;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.basic.util.DozerUtil;
import com.cardpay.basic.util.treeutil.exception.TreeInitializeException;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.menu.dao.TAuthorityMenuMapper;
import com.cardpay.mgt.menu.dao.TMenuAuthorityTemplateMapper;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.TAuthorityMenu;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuAuth;
import com.cardpay.mgt.menu.model.TMenuAuthorityTemplate;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.RoleService;
import com.cardpay.mgt.user.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单Service实现类
 *
 * Created by yanwe on 2016/11/22.
 */
@Service
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements TMenuService {

    @Autowired
    private TMenuMapper tMenuMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    private TAuthorityMenuMapper authorityMenuMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TMenuAuthorityTemplateMapper menuAuthorityTemplateMapper;

    @Autowired
    private TOrganizationService organizationService;

    @Autowired
    private RedisClient redisClient;

    private static final String SELECT = "Select";
    private static final String DELETE = "Delete";
    private static final String UPDATE = "Update";
    private static final String ADD = "Add";
    private static final int TOP_ID = 0;

    @Override
    public void initMenu(Integer orgId) {
        TMenu criteria = new TMenu();
        criteria.setOrganizationId(orgId);
        List<TMenu> isHaveMenu = tMenuMapper.select(criteria);
        if(!isHaveMenu.isEmpty()){
            LogTemplate.warn(null,"菜单初始化错误","机构："+orgId+"已存在菜单");
            return;
        }

        tMenuMapper.initMenu(ShiroKit.getUserId(),orgId);
        List<TMenu> menus = tMenuMapper.select(criteria);
        List<TMenuAuthorityTemplate> tMenuAuthorityTemplates = menuAuthorityTemplateMapper.selectAll();
        List<TAuthorityMenu> tAuthorityMenus = new ArrayList<>();

        //根据菜单模版id分组
        Map<Integer, List<TMenuAuthorityTemplate>> menuAuthTemplateMap = new HashMap<>();
        for (TMenuAuthorityTemplate tMenuAuthorityTemplate : tMenuAuthorityTemplates) {
            if (menuAuthTemplateMap.containsKey(tMenuAuthorityTemplate.getMenuTemplateId())) {
                menuAuthTemplateMap.get(tMenuAuthorityTemplate.getMenuTemplateId()).add(tMenuAuthorityTemplate);
            } else {
                menuAuthTemplateMap.put(tMenuAuthorityTemplate.getMenuTemplateId(), new ArrayList<>());
                menuAuthTemplateMap.get(tMenuAuthorityTemplate.getMenuTemplateId()).add(tMenuAuthorityTemplate);
            }
        }

        //插入菜单权限信息
        for (TMenu menu : menus) {
            for (Map.Entry<Integer,List<TMenuAuthorityTemplate>> map : menuAuthTemplateMap.entrySet()) {
                if(menu.getMenuTemplateId().equals(map.getKey())){
                    List<TMenuAuthorityTemplate> authIds = map.getValue();
                    for (TMenuAuthorityTemplate authId : authIds) {
                        TAuthorityMenu tAuthorityMenu = new TAuthorityMenu();
                        tAuthorityMenu.setMenuId(menu.getId());
                        tAuthorityMenu.setAuthorityId(authId.getAuthorityId());
                        tAuthorityMenus.add(tAuthorityMenu);
                    }
                }
            }
        }
        authorityMenuMapper.batchInsert(tAuthorityMenus);
    }

    @Override
    @SystemServiceLog(description = "查询全部菜单数据")
    public JSONArray selectMenuListByAll(int userId) {
        UserRole criteria = new UserRole();
        criteria.setUserId(userId);
        UserRole userRole = userRoleService.selectOne(criteria);
        Object menuJson = redisClient.get(RedisKeyPrefixEnum.ROLE_MENU, userRole.getRoleId().toString());
        return JSON.parseArray(menuJson.toString());
    }

    @Override
    public List<TMenuAuthVo> selectMenuListAndAuth(int roleId) {
        List<TMenuAuth> tMenuAuthList = tMenuMapper.selectMenuListAndAuthByRole(roleId);
        return convertMenu2Tree(assemblyAuth(getGroupByAuthName(tMenuAuthList)));
    }

    /**
     * 按层级顺序排序组装菜单
     *
     * @param sourceList 需要层级组装排序的列表
     * @return 层级排序后的菜单
     */
    private <T> List<T> convertMenu2Tree(List<T> sourceList) {
        //遍历组装树
        TreeUtil<T> treeUtil = new TreeUtil("menuOrder", TreeUtil.ASC);
        long start = System.currentTimeMillis();
        List<T> childNodesByParentId = null;
        try {
            childNodesByParentId = treeUtil.getChildNodesByParentId(sourceList, TOP_ID);
        } catch (TreeInitializeException e) {
            LogTemplate.error(e,"菜单数据组装层级错误",e.getMessage());
            e.printStackTrace();
            return null;
        }
        long end = System.currentTimeMillis();
        LogTemplate.debug("TreeUtil耗时",""+(end-start));
        return childNodesByParentId;
    }

    /**
     * 组装权限信息
     *
     * @param menuAuthMap 带权限信息的菜单列表
     * @return 组装好权限的菜单列表
     */
    private List<TMenuAuthVo> assemblyAuth(Map<String, List<TMenuAuth>> menuAuthMap) {
        //添加权限信息
        List<TMenuAuthVo> tMenuAuthVoList = new ArrayList<>();
        for (Map.Entry<String, List<TMenuAuth>> entry : menuAuthMap.entrySet()) {
            List<TMenuAuth> singleTMenuAuthList = entry.getValue();

            TMenuAuthVo tMenuAuthVo = DozerUtil.map(singleTMenuAuthList.get(0), TMenuAuthVo.class);
//            List<MenuAuth> authList = new ArrayList<>();
            for (TMenuAuth tMenuAuth : singleTMenuAuthList) {
//                MenuAuth menuAuth = new MenuAuth();
//                menuAuth.setAuthId(tMenuAuth.getAuthId());
//                menuAuth.setMenuNameZh(tMenuAuth.getAuthZh());
//                menuAuth.setHaveAuth(tMenuAuth.getIsHaveAuth() != null);
//                authList.add(menuAuth);
                if (SELECT.equals(tMenuAuth.getAuth().split(":")[1])){
                    tMenuAuthVo.setSeeAuth(tMenuAuth.getIsHaveAuth() != null);
                    tMenuAuthVo.setSeeAuthId(tMenuAuth.getAuthId());
                }
            }
            tMenuAuthVoList.add(tMenuAuthVo);
//            tMenuAuthVo.setAuthList(authList);

        }
        return tMenuAuthVoList;
    }

    /**
     * 根据菜单权限名称分组
     *
     * @param tMenuAuthList 全部菜单
     * @return 分组后的菜单
     */
    private Map<String, List<TMenuAuth>> getGroupByAuthName(List<TMenuAuth> tMenuAuthList) {
        //菜单按名称分组
        Map<String, List<TMenuAuth>> menuAuthMap = new HashMap<>();
        for (TMenuAuth tMenuAuth : tMenuAuthList) {
            if (menuAuthMap.containsKey(tMenuAuth.getMenuName())) {
                menuAuthMap.get(tMenuAuth.getMenuName()).add(tMenuAuth);
            } else {
                menuAuthMap.put(tMenuAuth.getMenuName(), new ArrayList<>());
                menuAuthMap.get(tMenuAuth.getMenuName()).add(tMenuAuth);
            }
        }
        return menuAuthMap;
    }

    @Override
    public ResultTo recursionDelete(Integer menuId, Integer userId) {
        List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menuId);
        //是否有权限
        boolean canDelete = isHaveAuth(authorities, DELETE);
        ResultTo resultTo = new ResultTo();
        if (canDelete) {
            tMenuMapper.recursionDelete(menuId);
            return resultTo;
        } else {
            resultTo.setCode(ResultEnum.NO_PERMITTION.getValue());
            return resultTo;
        }
    }

    @Override
    public ResultTo addMenu(TMenu menu, Integer userId) {
        List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menu.getId());
        boolean canDelete = isHaveAuth(authorities, ADD);
        ResultTo resultTo = new ResultTo();
        if (canDelete) {
            tMenuMapper.insert(menu);
            return resultTo;
        } else {
            resultTo.setCode(ResultEnum.NO_PERMITTION.getValue());
            return resultTo;
        }
    }

    @Override
    public boolean updateMenu(List<TMenu> menus, Integer userId) {
        boolean result = false;
        for (TMenu menu : menus) {
            List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menu.getId());
            boolean canDelete = isHaveAuth(authorities, UPDATE);
            if (canDelete) {
                int updateResult = tMenuMapper.updateByPrimaryKeySelective(menu);
                result = updateResult==1;
            } else {
                return false;
            }
        }
        return result;
    }

    /**
     * 是否有权限
     *
     * @param authorities 权限集合
     * @param auth        权限
     * @return 是否有权限
     */
    private boolean isHaveAuth(List<Authority> authorities, String auth) {
        boolean canDelete = false;
        for (Authority authority : authorities) {
            canDelete = authority.getAuthorityName().split(":")[1].equals(auth);
            if (canDelete) {
                break;
            }
        }
        return canDelete;
    }

    /**
     * 刷新全部菜单缓存（初始化菜单）
     */
    @Override
    public void updateMenuCache() {
        List<Role> roles = roleService.selectAll();
        updateMenuCache(roles);
    }

    /**
     * 刷新机构菜单缓存
     */
    @Override
    public void updateMenuCache(Integer orgId) {
        Integer topOrgId = null;
        if(organizationService.selectByPrimaryKey(orgId).getOrgParentId() != TOP_ID){
            topOrgId = organizationService.getTopOrgId(orgId);
        }
        Role criteria = new Role();
        criteria.setOrganizationId(topOrgId);
        List<Role> roles = roleService.select(criteria);
        updateMenuCache(roles);
    }

    /**
     * 更新角色菜单缓存
     *
     * @param roles 角色id
     */
    private void updateMenuCache(List<Role> roles) {
        for (Role role : roles) {
            List<TMenuVo> tMenuVos = tMenuMapper.selectMenuListByRoleAll(role.getId());
            if(tMenuVos == null){
                LogTemplate.warn(null,"菜单初始化异常","菜单角色:"+role.getRoleName()+"没有任何菜单权限！");
                tMenuVos = new ArrayList<>();
            }
            String menuString = JSON.toJSONString(convertMenu2Tree(tMenuVos));
            LogTemplate.info("菜单初始化,"+"菜单角色:"+role.getRoleName(),menuString);
            redisClient.set(RedisKeyPrefixEnum.ROLE_MENU,role.getId().toString()
                    ,menuString);
        }
        LogTemplate.info("菜单初始化完毕",null);
    }

}
