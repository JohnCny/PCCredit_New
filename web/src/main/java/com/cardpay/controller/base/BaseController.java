package com.cardpay.controller.base;

import com.cardpay.basic.base.controller.BasicController;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础controller 通用接口
 * @author johnmyiqn
 */
public class BaseController<T,PK> extends BasicController {
    /**
     * dozer mapper
     */
    @Autowired
    protected Mapper dozerMapper;

    //定义modelAndView返回数据名称
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
    BaseServiceImpl<T> baseService;

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性值进行查询，查询条件使用等号", httpMethod = "GET")
    public ModelAndView select(@ApiParam(value = "实体对象") T record
            ,@ApiParam(value = "view名称") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
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
    @ResponseBody
    @RequestMapping(value = "/api/select",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性值进行查询，查询条件使用等号", httpMethod = "GET")
    public ResultTo select(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.select(record));
        return result;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param pk 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果实体
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    @ApiOperation(value = "根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号", httpMethod = "GET")
    public ModelAndView selectByPrimaryKey(@ApiParam(value = "主键") @RequestParam("pk") PK pk
            ,@ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName( viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_BY_PRIMARY_KEY,baseService.selectByPrimaryKey(pk));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param pk 实体对象
     * @return resultTo，包含查找结果实体
     */
    @ResponseBody
    @ApiOperation(value = "根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号", httpMethod = "GET")
    @RequestMapping(value = "/api",method = RequestMethod.GET)
    public ResultTo selectByPrimaryKey(@ApiParam(value = "主键") @RequestParam("pk") PK pk){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectByPrimaryKey(pk));
        return result;
    }

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param viewName view名称
     * @return modelview对象，包含查找结果集合
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation(value = "根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号", httpMethod = "GET")
    public ModelAndView selectAll(@ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
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
    @ResponseBody
    @RequestMapping(value = "/api/list",method = RequestMethod.GET)
    @ApiOperation(value = "查询全部结果，select(null)方法能达到同样的效果", httpMethod = "GET")
    public ResultTo selectAll(){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectAll());
        return result;
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param viewName view名称
     * @param record 实体对象
     * @return modelview对象，包含查找结果实体
     */
    @RequestMapping(value = "/selectOne",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号", httpMethod = "GET")
    public ModelAndView selectOne(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_ONE,baseService.selectOne(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果实体
     */
    @ResponseBody
    @RequestMapping(value = "/api/selectOne",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号", httpMethod = "GET")
    public ResultTo selectOne(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectOne(record));
        return result;
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含查找结果个数
     */
    @RequestMapping(value = "/selectCount",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性查询总数，查询条件使用等号", httpMethod = "GET")
    public ModelAndView selectCount(@ApiParam(value = "实体对象") T record,
                                    @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        Map<String,Object> map = new HashMap<>();
        map.put(SELECT_COUNT,baseService.selectCount(record));
        modelAndView.addObject(map);
        return modelAndView;
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record 实体对象
     * @return resultTo，包含查找结果个数
     */
    @ResponseBody
    @RequestMapping(value = "/api/selectCount",method = RequestMethod.GET)
    @ApiOperation(value = "根据实体中的属性查询总数，查询条件使用等号", httpMethod = "GET")
    public ResultTo selectCount(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        result.setData(baseService.selectCount(record));
        return result;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ApiOperation(value = "根据主键更新实体全部字段，null值会被更新", httpMethod = "POST")
    public ModelAndView insert(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.insert(record);
        return modelAndView;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @return resultTo 包含插入后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api",method = RequestMethod.POST)
    @ApiOperation(value = "根据主键更新实体全部字段，null值会被更新", httpMethod = "POST")
    public ResultTo insert(@ApiParam(value = "实体对象") T record){
        System.out.println("测试数据:"+record.toString());
        ResultTo result = new ResultTo();
        baseService.insert(record);
        return result;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含插入后数据
     */
    @RequestMapping(value = "/insertSelective",method = RequestMethod.POST)
    @ApiOperation(value = "保存一个实体，null的属性不会保存，会使用数据库默认值", httpMethod = "POST")
    public ModelAndView insertSelective(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.insertSelective(record);
        return modelAndView;
    }

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record 实体对象
     * @return resultTo 包含插入后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api/insertSelective",method = RequestMethod.POST)
    @ApiOperation(value = "保存一个实体，null的属性不会保存，会使用数据库默认值", httpMethod = "POST")
    public ResultTo insertSelective(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        baseService.insertSelective(record);
        return result;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "根据主键更新实体全部字段，null值会被更新", httpMethod = "PUT")
    public ModelAndView updateByPrimaryKey(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.updateByPrimaryKey(record);
        return modelAndView;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record 实体对象
     * @return resultTo 包含更新后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api",method = RequestMethod.PUT)
    @ApiOperation(value = "根据主键更新实体全部字段，null值会被更新", httpMethod = "PUT")
    public ResultTo updateByPrimaryKey(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        baseService.updateByPrimaryKey(record);
        return result;
    }


    /**
     * 根据主键更新属性不为null的值
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    @RequestMapping(value = "/updateSelective",method = RequestMethod.PUT)
    @ApiOperation(value = "根据主键更新属性不为null的值", httpMethod = "PUT")
    public ModelAndView updateSelective(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.updateSelectiveByPrimaryKey(record);
        return modelAndView;
    }

    /**
     * 根据主键更新属性不为null的值
     * @param record 实体对象
     * @return resultTo 包含更新后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api/updateSelective",method = RequestMethod.PUT)
    @ApiOperation(value = "根据主键更新属性不为null的值", httpMethod = "PUT")
    public ResultTo updateSelective(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        baseService.updateSelectiveByPrimaryKey(record);
        return result;
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体对象
     * @param viewName view名称
     * @return modelview对象，包含删除后数据
     */
    @RequestMapping(value = "/deleteSelective",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据实体属性作为条件进行删除，查询条件使用等号", httpMethod = "DELETE")
    public ModelAndView delete(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.delete(record);
        return modelAndView;
    }

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record 实体对象
     * @return resultTo 包含删除后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api/deleteSelective",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据实体属性作为条件进行删除，查询条件使用等号", httpMethod = "DELETE")
    public ResultTo delete(@ApiParam(value = "实体对象") T record){
        ResultTo result = new ResultTo();
        baseService.delete(record);
        return result;
    }


    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param pk 主键
     * @param viewName view名称
     * @return modelview对象，包含更新后数据
     */
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键字段进行删除，方法参数必须包含完整的主键属性", httpMethod = "DELETE")
    public ModelAndView deleteByPrimaryKey(@ApiParam(value = "主键") @RequestParam("pk") PK pk
            ,@ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        baseService.deleteByPrimaryKey(pk);
        return modelAndView;
    }

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param pk 实体对象
     * @return resultTo 包含更新后数据
     */
    @ResponseBody
    @RequestMapping(value = "/api",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据主键字段进行删除，方法参数必须包含完整的主键属性", httpMethod = "DELETE")
    public ResultTo deleteByPrimaryKey(@ApiParam(value = "主键") @RequestParam("pk") PK pk){
        ResultTo result = new ResultTo();
        baseService.deleteByPrimaryKey(pk);
        return result;
    }

    /**
     * 根据实体属性和RowBounds进行分页查询
     * @param record 实体
     * @param page   页数
     * @param size   个数
     * @param viewName  view名称
     * @return modelview对象，包含分页数据集合
     */
    @RequestMapping(value = "/pageList",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据实体属性和RowBounds进行分页查询", httpMethod = "DELETE")
    public ModelAndView pageList(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "页数") @RequestParam("page") Integer page
            , @ApiParam(value = "个数") @RequestParam("size") Integer size
            , @ApiParam(value = "view名称") @RequestParam("viewName") String viewName){
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
    @ResponseBody
    @RequestMapping(value = "/api/pageList",method = RequestMethod.DELETE)
    @ApiOperation(value = "根据实体属性和RowBounds进行分页查询", httpMethod = "DELETE")
    public ResultTo pageList(@ApiParam(value = "实体对象") T record
            , @ApiParam(value = "页数") @RequestParam("page") Integer page
            , @ApiParam(value = "个数") @RequestParam("size") Integer size){
        ResultTo result = new ResultTo();
        baseService.pageList(record,page,size);
        result.setData(record);
        return result;
    }
//-----------------根据实际情况选择需要的接口------------------------
//    /**
//     * 根据实体属性和RowBounds进行分页查询，以开始行数start为参数
//     * @param record 实体
//     * @param start  开始行
//     * @param size   个数
//     * @param viewName view名称
//     * @return modelview对象，包含分页数据集合
//     */
//    @RequestMapping(value = "/pageList",method = RequestMethod.DELETE)
//    @ApiOperation(value = "根据实体属性和RowBounds进行分页查询，以开始行数start为参数", httpMethod = "DELETE")
//    public ModelAndView pageStartList(T record,@RequestParam("start") Integer start,@RequestParam("size") Integer size
//            ,@RequestParam("viewName") String viewName){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName( viewName);
//        Map<String,Object> map = new HashMap<>();
//        baseService.pageStartList(record,start,size);
//        map.put(PAGE_START_LIST,record);
//        modelAndView.addObject(map);
//        return modelAndView;
//    }
//
//    /**
//     *根据实体属性和RowBounds进行分页查询，以开始行数start为参数
//     * @param record 实体对象
//     * @param start  开始行
//     * @param size   个数
//     * @return  resultTo，包含分页数据集合
//     */
//    @RequestMapping(value = "/api/pageList",method = RequestMethod.DELETE)
//    @ApiOperation(value = "根据实体属性和RowBounds进行分页查询，以开始行数start为参数", httpMethod = "DELETE")
//    public ResultTo pageStartList(T record,@RequestParam("start") Integer start,@RequestParam("size") Integer size){
//        ResultTo result = new ResultTo();
//        result.setData(baseService.pageStartList(record,start,size));
//        return result;
//    }
}
