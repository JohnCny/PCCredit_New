package com.cardpay.mgt.organization.service;

import com.cardpay.mgt.organization.model.TOrganizationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 机构service层
 * Created by chenkai on 2016/11/24.
 */
public interface TOrganizationService {
    /**
     *  递归查询机构层级信息
     * @param id 父级id
     * @param levels 查询的层级数量
     * @return 机构层级信息
     */
    List<TOrganizationVo> queryOrganization(int id, int levels);

    /**
     * 更新此机构所属层级信息
     * @param id 机构id
     * @param parentId 父机构id
     * @return 1成功, 0失败
     */
    int updateOrganization(int id, int parentId);

    /**
     *  递归删除机构信息
     * @param id 机构id
     * @return 1成功, 0失败
     */
    int deleteOrganization(@Param("id") int id);
}
