package com.cardpay.mgt.menu.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuAuth;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.mgt.user.dao.AuthorityMapper;
import com.cardpay.mgt.user.model.Authority;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by yanwe on 2016/11/29.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TMenuServiceImpl.class})
public class TMenuServiceImplTest {

    @Mock
    private TMenuMapper tMenuMapper;

    @Mock
    private AuthorityMapper authorityMapper;

    @InjectMocks
    private TMenuServiceImpl tMenuService;

    private List<Authority> authorities;

    private List<TMenuVo> tMenuVos;

    @Before
    public void setUp(){
        //权限数据
        authorities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Authority authority = new Authority();
            switch (i){
                case 0:
                    authority.setAuthorityName("testMenu"+i+":Add");
                    break;
                case 1:
                    authority.setAuthorityName("testMenu"+i+":Delete");
                    break;
                case 2:
                    authority.setAuthorityName("testMenu"+i+":Update");
                    break;
            }
            authorities.add(authority);
        }
        //菜单数据
        //构造基本数据
        tMenuVos = new ArrayList<>(3);
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                TMenuVo tMenuVo = new TMenuVo();
                tMenuVo.setId(i);
                tMenuVo.setMenuName("testMenu"+i);
                tMenuVo.setMenuNameZh("测试菜单"+i);
                tMenuVos.add(tMenuVo);
            }
        }
        //构造菜单层级关系
        for (TMenuVo menuVo : tMenuVos) {
            if(menuVo.getId() == 1 || menuVo.getId() == 2 || menuVo.getId() == 3){
                menuVo.setMenuParentId(0);
            }
            if(menuVo.getId() == 4 || menuVo.getId() == 5){
                menuVo.setMenuParentId(1);
            }
            if(menuVo.getId() == 6){
                menuVo.setMenuParentId(2);
            }
            if(menuVo.getId() == 7){
                menuVo.setMenuParentId(6);
            }
            if(menuVo.getId() == 8){
                menuVo.setMenuParentId(1);
            }
            if(menuVo.getId() == 9){
                menuVo.setMenuParentId(5);
            }
            if(menuVo.getId() == 10){
                menuVo.setMenuParentId(3);
            }
        }
    }

    @Test
    public void selectMenuListByLevel() throws Exception {
        when(tMenuMapper.selectMenuListByLevel(0,3,2)).thenReturn(tMenuVos);
        List<TMenuVo> tMenuVoList = tMenuService.selectMenuListByLevel(0, 3,2);
        assertTrue(tMenuVoList.size() > 0);
        verify(tMenuMapper).selectMenuListByLevel(0,3,2);
    }

    @Test
    public void selectMenuListByAll() throws Exception {
        when(tMenuMapper.selectMenuListByAll(0,2)).thenReturn(tMenuVos);
        List<TMenuVo> tMenuVoList = tMenuService.selectMenuListByAll(0, 2);
        assertTrue(tMenuVoList.size() > 0);
        verify(tMenuMapper).selectMenuListByAll(0,2);
    }

    @Test
    public void selectMenuListAndAuth() throws Exception {
        List<TMenuAuth> tMenuAuthList = new ArrayList<>();
        //构造基本数据
        int authId = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 4; j++) {
                TMenuAuth tMenuAuth = new TMenuAuth();
                tMenuAuth.setId(i);
                tMenuAuth.setMenuName("testMenu"+i);
                tMenuAuth.setMenuNameZh("测试菜单"+i);
                switch (j){
                    case 0:
                        tMenuAuth.setAuth("testMenu"+i+":Add");
                        break;
                    case 1:
                        tMenuAuth.setAuth("testMenu"+i+":Delete");
                        break;
                    case 2:
                        tMenuAuth.setAuth("testMenu"+i+":Update");
                        break;
                    case 3:
                        tMenuAuth.setAuth("testMenu"+i+":Select");
                        break;
                }
                tMenuAuth.setAuthId(authId);
                tMenuAuth.setIsHaveAuth(authId++);
                tMenuAuthList.add(tMenuAuth);
            }
        }
        //构造菜单层级关系
        for (TMenuAuth menuAuth : tMenuAuthList) {
            if(menuAuth.getId() == 1 || menuAuth.getId() == 2 || menuAuth.getId() == 3){
                menuAuth.setMenuParentId(0);
            }
            if(menuAuth.getId() == 4 || menuAuth.getId() == 5){
                menuAuth.setMenuParentId(1);
            }
            if(menuAuth.getId() == 6){
                menuAuth.setMenuParentId(2);
            }
            if(menuAuth.getId() == 7){
                menuAuth.setMenuParentId(6);
            }
            if(menuAuth.getId() == 8){
                menuAuth.setMenuParentId(1);
            }
            if(menuAuth.getId() == 9){
                menuAuth.setMenuParentId(5);
            }
            if(menuAuth.getId() == 10){
                menuAuth.setMenuParentId(3);
            }
        }
        when(tMenuMapper.selectMenuListAndAuthByUser(1)).thenReturn(tMenuAuthList);
        List<TMenuAuthVo> tMenuAuthVos = tMenuService.selectMenuListAndAuth(1);
        verify(tMenuMapper).selectMenuListAndAuthByUser(1);
        assertTrue(tMenuAuthVos.size() == 3);
    }

    @Test
    public void recursionDelete() throws Exception {
        when(authorityMapper.selectMenuAuthorityByUser(1,1)).thenReturn(authorities);
        ResultTo resultTo = tMenuService.recursionDelete(1, 1);
        verify(tMenuMapper).recursionDelete(1);
        assertTrue(resultTo.getCode()==200);
    }

    @Test
    public void addMenu() throws Exception {
        when(authorityMapper.selectMenuAuthorityByUser(1,1)).thenReturn(authorities);
        TMenu tMenu = new TMenu();
        tMenu.setMenuParentId(1);
        ResultTo resultTo = tMenuService.addMenu(tMenu, 1);
        verify(tMenuMapper).insert(tMenu);
        assertTrue(resultTo.getCode()==200);
    }

    @Test
    public void updateMenu() throws Exception {
        when(authorityMapper.selectMenuAuthorityByUser(1,1)).thenReturn(authorities);
        TMenu tMenu = new TMenu();
        tMenu.setMenuParentId(1);
        ResultTo resultTo = tMenuService.updateMenu(tMenu, 1);
        verify(tMenuMapper).updateByPrimaryKey(tMenu);
        assertTrue(resultTo.getCode()==200);
    }

}