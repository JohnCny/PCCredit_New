package com.cardpay.mgt.menu.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.*;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.model.Authority;
import org.dozer.Mapper;
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
public class TMenuServiceImpl extends BaseServiceImpl<TMenu> implements TMenuService{

    @Autowired
    private TMenuMapper tMenuMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Autowired
    protected Mapper dozerMapper;

    @Override
    public synchronized List<TMenuVo> selectMenuListByLevel(int topId, int level, int userId) {
        tMenuMapper.createMenuView(topId,level,userId);
        List<TMenuVo> menuVoList = tMenuMapper.selectMenuListByLevel(topId);
        return menuVoList;
    }

    @Override
    public List<TMenuVo> selectMenuListByAll(int topId, int userId) {
        List<TMenuVo> menuVoList = tMenuMapper.selectMenuListByAll(topId, userId);
        return menuVoList;
    }

    @Override
    public List<TMenuAuthVo> selectMenuListAndAuth(int userId) {

        List<TMenuAuth> tMenuAuthList = tMenuMapper.selectMenuListAndAuthByUser(userId);
        //java8
//        Map<String, List<TMenuAuth>> menuAuthMap = tMenuAuthList.stream().collect(Collectors.groupingBy(TMenuAuth::getMenuName));
        //java7
        //菜单按名称分组
        Map<String, List<TMenuAuth>> menuAuthMap = new HashMap<>();
        for (TMenuAuth tMenuAuth : tMenuAuthList) {
            if(menuAuthMap.containsKey(tMenuAuth.getMenuName())){
                menuAuthMap.get(tMenuAuth.getMenuName()).add(tMenuAuth);
            } else {
                menuAuthMap.put(tMenuAuth.getMenuName(),new ArrayList<>());
            }
        }
        //添加权限信息
        List<TMenuAuthVo> tMenuAuthVoList = new ArrayList<>();
        for (String menuName : menuAuthMap.keySet()) {
            List<TMenuAuth> singleTMenuAuthList = menuAuthMap.get(menuName);
            TMenuAuthVo tMenuAuthVo = dozerMapper.map(singleTMenuAuthList.get(0), TMenuAuthVo.class);

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
        //遍历组装树
        TreeUtil<TMenuAuthVo,Integer> treeUtil = new TreeUtil();
        List<TMenuAuthVo> finalList = treeUtil.getChildNodesByParentId(tMenuAuthVoList, 0);
        return finalList;
    }

    @Override
    public ResultTo recursionDelete(Integer menuId,Integer userId) {
        List<Authority> authorities = authorityMapper.selectMenuAuthorityByUser(userId, menuId);
        //是否有权限
        //java8
//        boolean canDelete = authorities.stream().anyMatch(authority -> authority.getAuthorityName().split(":")[1].equals("Delete"));
        //java7
        boolean canDelete = false;
        for (Authority authority : authorities) {
            canDelete = authority.getAuthorityName().split(":")[1].equals("Delete");
            if (canDelete){break;}
        }
        ResultTo resultTo = new ResultTo();
        if (canDelete){
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
        //java8
//        boolean canDelete = authorities.stream().anyMatch(authority -> authority.getAuthorityName().split(":")[1].equals("Add"));
        //java7
        boolean canDelete = false;
        for (Authority authority : authorities) {
            canDelete = authority.getAuthorityName().split(":")[1].equals("Add");
            if (canDelete){break;}
        }
        ResultTo resultTo = new ResultTo();
        if (canDelete){
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
        //java8
//        boolean canDelete = authorities.stream().anyMatch(authority -> authority.getAuthorityName().split(":")[1].equals("Update"));
        //java7
        boolean canDelete = false;
        for (Authority authority : authorities) {
            canDelete = authority.getAuthorityName().split(":")[1].equals("Update");
            if (canDelete){break;}
        }
        ResultTo resultTo = new ResultTo();
        if (canDelete){
            tMenuMapper.updateByPrimaryKey(menu);
            return resultTo;
        } else {
            resultTo.setCode(ResultEnum.NO_PERMITTION.getValue());
            return resultTo;
        }
    }

}
