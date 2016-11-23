package com.cardpay.basic.base.baseInterface;

import com.cardpay.basic.base.model.ResultTo;

/**
 * Created by johnmyiqn on 2016/11/10.
 */
public interface BaseApiInterface<T> {
    //定义controller api接口必须实现定义
    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果集合
     */
    ResultTo select(T record);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果实体
     */
    ResultTo selectByPrimaryKey(T record);

    /**
     *查询所有信息                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         * 查询全部结果，select(null)方法能达到同样的效果
     * @return resultTo，包含查找结果集合
     */
    ResultTo selectAll();

    /**
     *根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果实体
     */
    ResultTo selectOne(T record);

    /**
     *根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果个数
     */
    ResultTo selectCount(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @return resultTo 包含插入后数据
     */
    ResultTo insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体对象
     * @return resultTo 包含插入后数据
     */
    ResultTo insertSelective(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @return resultTo 包含更新后数据
     */
    ResultTo updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     * @param record 实体对象
     * @return resultTo 包含更新后数据
     */
    ResultTo updateSelective(T record);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体对象
     * @return resultTo 包含删除后数据
     */
    ResultTo delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param record 实体对象
     * @return resultTo 包含更新后数据
     */
    ResultTo deleteByPrimaryKey(T record);

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record 实体对象
     * @param page   页数
     * @param size   个数
     * @return resultTo，包含分页数据集合
     */
    ResultTo pageList(T record, Integer page, Integer size);

    /**
     *根据实体属性和RowBounds进行分页查询，以开始行数start为参数
     * @param record 实体对象
     * @param start  开始行
     * @param size   个数
     * @return  resultTo，包含分页数据集合
     */
    ResultTo pageStartList(T record, Integer start, Integer size);
}
