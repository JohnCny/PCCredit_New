package com.cardpay.basic.base.baseInterface;

import org.springframework.web.servlet.ModelAndView;

/**
 *  controller jsp或者模板渲染实现通用接口
 * @author johnmyiqn
 */
public interface BaseInterface<T> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */

    ModelAndView select(T record, String viewName);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果实体
     */
    ModelAndView selectByPrimaryKey(T record,String viewName);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */
    ModelAndView selectAll(String viewName);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果实体
     */
    ModelAndView selectOne(T record,String viewName);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果个数
     */
    ModelAndView selectCount(T record,String viewName);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    ModelAndView insert(T record,String viewName);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    ModelAndView insertSelective(T record,String viewName);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    ModelAndView updateByPrimaryKey(T record,String viewName);

    /**
     * 根据主键更新属性不为null的值
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    ModelAndView updateSelective(T record,String viewName);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含删除后数据
     */
    ModelAndView delete(T record,String viewName);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    ModelAndView deleteByPrimaryKey(T record,String viewName);

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @param viewName  view名称
     * @return  modelview对象，包含分页数据集合
     */
    ModelAndView pageList(T record,Integer page,Integer size, String viewName);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param record 实体
     * @param start  开始行
     * @param size   个数
     * @param viewName view名称
     * @return  modelview对象，包含分页数据集合
     */
    ModelAndView pageStartList(T record,Integer start,Integer size,String viewName);
}
