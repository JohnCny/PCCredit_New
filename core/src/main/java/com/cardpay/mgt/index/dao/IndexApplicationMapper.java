package com.cardpay.mgt.index.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.normal.model.TTemplateGroup;
import com.cardpay.mgt.index.model.IndexApplicationInfo;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;
import com.cardpay.mgt.index.model.Org;
import com.cardpay.mgt.index.model.OrgAndChildrenOrg;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 首页进件信息Mapper
 * extends BasicMapper<TTemplateGroup> 继承此类只用于扫描，如果需要调用该表的方法应使用对应的Mapper
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 16:15
 */
public interface IndexApplicationMapper extends BasicMapper<TTemplateGroup> {

    /**
     * 查询指定机构下所有进件统计信息
     *
     * @param topOrgId 顶级机构id
     * @return 该机构下所有进件统计信息
     */
    List<IndexOrgApplicationInfo> selectOrgApplicationInfo(@Param("topOrgId") Integer topOrgId);

    /**
     * 查询该用户所有进件状态统计信息
     *
     * @param userId 用户id
     * @return 进件状态统计
     */
    List<IndexApplicationInfo> selectUserApplicationInfo(@Param("userId") Integer userId);

    /**
     * 查询该用户当月的进件数量
     *
     * @param userId 用户id
     * @return 进件数量
     */
    Integer selectUserApplicationInfoMonth(@Param("userId") Integer userId);

    /**
     * 查询该用户下所有进件审核额度总额
     *
     * @param userId 用户id
     * @return 进件数量
     */
    BigDecimal selectUserApplicationInfoApproveAmountSum(@Param("userId") Integer userId);

    /**
     * 查询多个机构下的进件统计信息
     *
     * @param list 机构id列表
     * @return 多个机构下的进件统计信息
     */
    List<IndexApplicationInfo> selectMoreOrgApplicationInfo(List<Org> list);

    /**
     * 查询所有顶级机构的子机构
     *
     * @return 所有顶级机构的子机构
     */
    List<OrgAndChildrenOrg> selectTopOrgAndChildrenOrg();
}
