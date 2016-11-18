package com.cardpay.controller.base;

import com.cardpay.basic.base.controller.BasicController;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础controller 通用接口
 * @author johnmyiqn
 */
public class BaseController<T> extends BasicController {
    /**
     * dozer mapper
     */
    @Autowired
    protected Mapper dozerMapper;

    //定义moddelAndView返回数据名称
    /*
        选择查询名称
     */
    String SELECT = "selectLists";
    String SELECT_BY_PRIMARY_KEY = "selectPk";
    String SELECT_ALL = "selectAll";
    String SELECT_ONE = "selectOne";
    /*
       查询满足条件名称
    */
    String SELECT_COUNT = "count";
    /*
        分页查询查询名称
     */
    String PAGE_LIST = "pageList";
    String PAGE_START_LIST = "PageStartList";

    @Autowired
    BaseService<T> baseService;

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */
    public ModelAndView select(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT,baseService.select(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果集合
     */
    public ResultTo select(T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.select(record));
        return result;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果实体
     */
    public ModelAndView selectByPrimaryKey(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_BY_PRIMARY_KEY,baseService.selectByPrimaryKey(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果实体
     */
    public ResultTo selectByPrimaryKey(T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectByPrimaryKey(record));
        return result;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */
    public ModelAndView selectAll(String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_ALL,baseService.selectAll());
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     * @return resultTo，包含查找结果集合
     */

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation("查询全部结果，select(null)方法能达到同样的效果")
    public ResultTo selectAll(){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectAll());
        return result;
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含查找结果实体
     */
    public ModelAndView selectOne(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_ONE,baseService.selectOne(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @return resultTo，包含查找结果实体
     */
    public ResultTo selectOne(T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectOne(record));
        return result;
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含查找结果个数
     */
    public ModelAndView selectCount(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_COUNT,baseService.selectCount(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     *根据实体中的属性查询总数，查询条件使用等号
     * @return resultTo，包含查找结果个数
     */
    public ResultTo selectCount(T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectCount(record));
        return result;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    public ModelAndView insert(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.insert(record);
        return modelAndView;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @return resultTo 包含插入后数据
     */
    public ResultTo insert(T record){
        ResultTo result = new ResultTo();
        baseService.insert(record);
        return result;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    public ModelAndView insertSelective(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.insertSelective(record);
        return modelAndView;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @return resultTo 包含插入后数据
     */
    public ResultTo insertSelective(T record){
        ResultTo result = new ResultTo();
        baseService.insertSelective(record);
        return result;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    public ModelAndView updateByPrimaryKey(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.updateByPrimaryKey(record);
        return modelAndView;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @return resultTo 包含更新后数据
     */
    public ResultTo updateByPrimaryKey(T record){
        ResultTo result = new ResultTo();
        baseService.updateByPrimaryKey(record);
        return result;
    }


    /**
     * 根据主键更新属性不为null的值
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    public ModelAndView updateSelective(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.updateSelectiveByPrimaryKey(record);
        return modelAndView;
    }

    /**
     * 根据主键更新属性不为null的值
     * @return resultTo 包含更新后数据
     */
    public ResultTo updateSelective(T record){
        ResultTo result = new ResultTo();
        baseService.updateSelectiveByPrimaryKey(record);
        return result;
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含删除后数据
     */
    public ModelAndView delete(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.delete(record);
        return modelAndView;
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @return resultTo 包含删除后数据
     */
    public ResultTo delete(T record){
        ResultTo result = new ResultTo();
        baseService.delete(record);
        return result;
    }


    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    public ModelAndView deleteByPrimaryKey(T record,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        baseService.deleteByPrimaryKey(record);
        return modelAndView;
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @return resultTo 包含更新后数据
     */
    public ResultTo deleteByPrimaryKey(T record){
        ResultTo result = new ResultTo();
        baseService.deleteByPrimaryKey(record);
        return result;
    }

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @param viewName  view名称
     * @return  modelview对象，包含分页数据集合
     */
    public ModelAndView pageList(T record,Integer page,Integer size, String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(PAGE_LIST,baseService.pageList(record,page,size));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @return resultTo，包含分页数据集合
     */
    public ResultTo pageList(T record,Integer page,Integer size){
        ResultTo result = new ResultTo();
        baseService.pageList(record,page,size);
        result.setData(record);
        return result;
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param record 实体
     * @param start  开始行
     * @param size   个数
     * @param viewName view名称
     * @return  modelview对象，包含分页数据集合
     */
    public ModelAndView pageStartList(T record,Integer start,Integer size,String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        baseService.pageStartList(record,start,size);
        map.put(PAGE_START_LIST,record);
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     *根据实体属性和RowBounds进行分页查询，以开始行数start为参数
     * @param record 实体对象
     * @param start  开始行
     * @param size   个数
     * @return  resultTo，包含分页数据集合
     */
    public ResultTo pageStartList(T record,Integer start,Integer size){
        ResultTo result = new ResultTo();
        result.setData(baseService.pageStartList(record,start,size));
        return result;
    }
}
