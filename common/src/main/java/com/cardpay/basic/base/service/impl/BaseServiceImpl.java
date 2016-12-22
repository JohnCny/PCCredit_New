package com.cardpay.basic.base.service.impl;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.basic.base.service.BaseService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 用户控制层
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
    /**
     * mapper定义
     */
    @Autowired
    private BasicMapper<T> mapper;

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param record 实体
     * @return 实体列表
     */
    @Override
    public List<T> select(T record) {
        return mapper.select(record);
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 实体
     */
    @Override
    public T selectByPrimaryKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     * 返回克隆对象,在需要二次查询时使用
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     * @param key 主键
     * @return 实体
     */
    @Override
    public T selectByPrimaryKeyClone(Object key) {
        try {
            return (T) BeanUtils.cloneBean(mapper.selectByPrimaryKey(key));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     *
     * @return 实体列表
     */
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param record 实体
     * @return 满足条件实体
     */
    @Override
    public T selectOne(T record) {
        return mapper.selectOne(record);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param record 实体
     * @return 满足条件个数
     */
    @Override
    public Integer selectCount(T record) {
        return mapper.selectCount(record);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer insert(T record) {
        return mapper.insert(record);
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer updateSelectiveByPrimaryKey(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record 实体
     * @return 影响数据库行数
     */
    @Override
    public Integer delete(T record) {
        return mapper.delete(record);
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key 主键
     * @return 影响数据库行数
     */
    @Override
    public Integer deleteByPrimaryKey(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    /**
     * 根据实体属性和RowBounds进行分页查询,以page作为开始参数
     *
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @return 分页数据
     */
    public List<T> pageList(T record, Integer page, Integer size) {
        return pageList(record, page, size, null);
    }

    /**
     * 根据实体属性和RowBounds进行分页查询,以page作为开始参数
     *
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @return 分页数据
     */
    @Override
    public List<T> pageList(T record, Integer page, Integer size, String order) {
        PageHelper.startPage(page, size);
        if (StringUtils.isNotBlank(order)) {
            PageHelper.orderBy(order);
        }
        return mapper.select(record);
    }
}
