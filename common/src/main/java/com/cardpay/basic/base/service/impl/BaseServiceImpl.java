package com.cardpay.basic.base.service.impl;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 通用service功能
 * @author johnmyqin
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * mapper定义
     */
    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record  实体
     * @return 实体列表
     */
    @Override
    public List<T> select(T record){
        return mapper.select(record);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param key 主键
     * @return  实体
     */
    @Override
    public T selectByPrimaryKey(Object key){
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return  实体列表
     */
    @Override
    public List<T> selectAll(){
        return mapper.selectAll();
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record 实体
     * @return 满足条件实体
     */
    @Override
    public T selectOne(T record){
        return mapper.selectOne(record);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体
     * @return 满足条件个数
     */
    @Override
    public Integer selectCount(T record){
        return mapper.selectCount(record);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer insert(T record){
        return mapper.insert(record);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer insertSelective(T record){
        return mapper.insertSelective(record);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer updateByPrimaryKey(T record){
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 根据主键更新属性不为null的值
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer updateSelectiveByPrimaryKey(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer delete(T record){
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param key 主键
     * @return 影响数据库行数
     */
    @Override
    public Integer deleteByPrimaryKey(Object key){
        return mapper.deleteByPrimaryKey(key);
    }

    /**
     * 根据实体属性和RowBounds进行分页查询,以page作为开始参数
     * @param record 实体
     * @param page 页数
     * @param size 个数
     * @return 分页实体个数
     */
    @Override
    public List<T> pageList(T record, Integer page,Integer size){
        RowBounds bounds = new RowBounds((page-1)*size,size);
        return mapper.selectByRowBounds(record,bounds);
    }

    /**
     * 根据实体属性和RowBounds进行分页查询，以开始行数start为参数
     * @param record 实体
     * @param start 起始行数
     * @param size 个数
     * @return 分页实体个数
     */
    @Override
    public List<T> pageStartList(T record, Integer start,Integer size){
        RowBounds bounds = new RowBounds(start,size);
        return mapper.selectByRowBounds(record,bounds);
    }
}
