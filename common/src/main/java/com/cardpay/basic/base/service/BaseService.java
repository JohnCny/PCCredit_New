package com.cardpay.basic.base.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Pzwxy on 2016/11/24.
 */
public interface BaseService<T>{
    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record  实体
     * @return 实体列表
     */
    List<T> select(T record);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param key 主键
     * @return  实体
     */
    T selectByPrimaryKey(Object key);

    /**
     * 返回克隆对象,在需要二次查询时使用
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param key 主键
     * @return  实体
     */
    T selectByPrimaryKeyClone(Object key);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return  实体列表
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record 实体
     * @return 满足条件实体
     */
    T selectOne(T record);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体
     * @return 满足条件个数
     */
    Integer selectCount(T record);

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record 实体
     * @return 影响数据库行数
     */
    Integer insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体
     * @return 影响数据库行数
     */
    Integer insertSelective(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体
     * @return 影响数据库行数
     */
    Integer updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     * @param record 实体
     * @return 影响数据库行数
     */
    Integer updateSelectiveByPrimaryKey(T record);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体
     * @return 影响数据库行数
     */
    Integer delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param key 主键
     * @return 影响数据库行数
     */
    Integer deleteByPrimaryKey(Object key);

    /**
     * 根据实体属性和RowBounds进行分页查询,以page作为开始参数
     * @param record 实体
     * @param page 页数
     * @param size 个数
     * @return 分页实体个数
     */
    List<T> pageList(T record, Integer page,Integer size);

    /**
     * 根据实体属性和RowBounds进行分页查询，以开始行数start为参数
     * @param record 实体
     * @param start 起始行数
     * @param size 个数
     * @return 分页实体个数
     */
    List<T> pageStartList(T record, Integer start,Integer size);
}
