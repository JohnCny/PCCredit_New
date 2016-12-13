package com.cardpay.mgt.menu.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.DozerUtil;
import com.cardpay.basic.util.treeutil.Tree;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.*;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.model.Authority;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单Service实现类
 * <p>
 * Created by yanwe on 2016/11/22.
 */
@Service
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements TMenuService {

    @Autowired
    private TMenuMapper tMenuMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    private static final String DELETE = "Delete";
    private static final String UPDATE = "Update";
    private static final String ADD = "Add";

    @Override
    @Transactional
    public synchronized List<TMenuVo> selectMenuListByLevel(int topId, int level, int userId) {
        List<TMenuVo> menuVoList = tMenuMapper.selectMenuListByLevel(topId, level, userId);
        return convertMenu2Tree(menuVoList);
    }

    @Override
    public List<TMenuVo> selectMenuListByAll(int topId, int userId) {
        List<TMenuVo> menuVoList = tMenuMapper.selectMenuListByAll(topId, userId);
        return convertMenu2Tree(menuVoList);
    }

    @Override
    public List<TMenuAuthVo> selectMenuListAndAuth(int userId) {
        List<TMenuAuth> tMenuAuthList = tMenuMapper.selectMenuListAndAuthByUser(userId);
        return convertMenu2Tree(assemblyAuth(getGroupByAuthName(tMenuAuthList)));
    }

    /**
     * 按层级顺序排序组装菜单
     *
     * @param sourceList 需要层级组装排序的列表
     * @return 层级排序后的菜单
     */
    private <T extends Tree> List<T> convertMenu2Tree(List<T> sourceList) {
        //遍历组装树
        TreeUtil<T, Integer> treeUtil = new TreeUtil("menuOrder", TreeUtil.ASC);
        return treeUtil.getChildNodesByParentId(sourceList, 0);
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
            List<MenuAuth> authList = new ArrayList<>();
            for (TMenuAuth tMenuAuth : singleTMenuAuthList) {
                MenuAuth menuAuth = new MenuAuth();
                menuAuth.setAuthId(tMenuAuth.getAuthId());
                menuAuth.setAuthType(tMenuAuth.getAuth().split(":")[1]);
                menuAuth.setHaveAuth(tMenuAuth.getIsHaveAuth() != null);
                authList.add(menuAuth);
            }
            tMenuAuthVo.setAuthList(authList);

            tMenuAuthVoList.add(tMenuAuthVo);
        }
        return tMenuAuthVoList;
    }

    /**
     * 根据菜单名称分组
     *
     * @param tMenuAuthList 全部菜单
     * @return 分组后的菜单
     */
    private Map<String, List<TMenuAuth>> getGroupByAuthName(List<TMenuAuth> tMenuAuthList) {
        //java8
//        Map<String, List<TMenuAuth>> menuAuthMap = tMenuAuthList.stream().collect(Collectors.groupingBy(TMenuAuth::getMenuName));
        //java7
        //菜单按名称分组
        Map<String, List<TMenuAuth>> menuAuthMap = new HashMap<>();
        for (TMenuAuth tMenuAuth : tMenuAuthList) {
            if (menuAuthMap.containsKey(tMenuAuth.getMenuName())) {
                menuAuthMap.get(tMenuAuth.getMenuName()).add(tMenuAuth);
            } else {
                menuAuthMap.put(tMenuAuth.getMenuName(), new ArrayList<>());
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
        List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menu.getMenuParentId());
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
    public ResultTo updateMenu(TMenu menu, Integer userId) {
        List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menu.getMenuParentId());
        boolean canDelete = isHaveAuth(authorities, UPDATE);
        ResultTo resultTo = new ResultTo();
        if (canDelete) {
            tMenuMapper.updateByPrimaryKey(menu);
            return resultTo;
        } else {
            resultTo.setCode(ResultEnum.NO_PERMITTION.getValue());
            return resultTo;
        }
    }

    /**
     * 是否有权限
     *
     * @param authorities 权限集合
     * @param auth        权限
     * @return 是否有权限
     */
    private boolean isHaveAuth(List<Authority> authorities, String auth) {
        //java8
//        boolean canDelete = authorities.stream().anyMatch(authority -> authority.getAuthorityName().split(":")[1].equals(auth));
        //java7
        boolean canDelete = false;
        for (Authority authority : authorities) {
            canDelete = authority.getAuthorityName().split(":")[1].equals(auth);
            if (canDelete) {
                break;
            }
        }
        return canDelete;
    }
}
