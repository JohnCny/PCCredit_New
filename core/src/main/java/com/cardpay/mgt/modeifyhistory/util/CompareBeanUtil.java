package com.cardpay.mgt.modeifyhistory.util;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.BeanFactoryUtil;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;
import com.cardpay.mgt.modeifyhistory.service.impl.TModifyHistoryServiceImpl;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.DateConverter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对象属性对比
 * @author yanwe on 2016/12/1.
 */
public class CompareBeanUtil {

    /**
     * 对比实体修改并记录
     *
     * @param bean 需要记录的bean
     * @param baseService 对应的Service
     * @param moduleName 模块英文名
     * @param moduleNameZh 模块中文名
     * @param <T> 类型
     */
    public static <T extends GenericEntity<?>> void compareBean(T bean, BaseService<T> baseService, String moduleName,
                                                                String moduleNameZh,User user) {
        T oldBean = baseService.selectByPrimaryKey(bean.getPK());
        TModifyHistoryServiceImpl tModifyHistoryService = BeanFactoryUtil.getBean(TModifyHistoryServiceImpl.class);
        tModifyHistoryService.batchInsert(getCompareResult(oldBean, bean , moduleName, moduleNameZh,user));
    }

    /**
     * 获取对比结果
     *
     * @param oldBean 修改前的bean
     * @param newBean 修改后的bean
     * @param moduleName 模块英文名
     * @param moduleNameZh 模块中文
     * @param <T> 类型
     * @return 该Bean的对比结果列表
     */
    public static <T extends GenericEntity<?>> List<TModifyHistory> getCompareResult(T oldBean,T newBean,
                                                                            String moduleName, String moduleNameZh,User user) {
        Field[] newBeanFields = newBean.getClass().getDeclaredFields();
        Field[] oldBeanFields = oldBean.getClass().getDeclaredFields();
        List<TModifyHistory> tModifyHistoryList = new ArrayList<>();
        BeanUtilsBean.setInstance(new BeanUtilsBean2());//必须设置，否则注册会失效
        DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd HH:mm:ss");
        ConvertUtils.register(converter, Date.class);
        for (int i = 0; i < newBeanFields.length; i++) {
            Field newBeanField = newBeanFields[i];
            Field oldBeanField = oldBeanFields[i];
            if(newBeanField.getName().equals(oldBeanField.getName())){
                try {
                    String newBeanProperty = BeanUtils.getProperty(newBean, newBeanField.getName());
                    String oldBeanProperty = BeanUtils.getProperty(oldBean, newBeanField.getName());
                    ApiModelProperty newBeanFieldAnnotation = newBeanField.getAnnotation(ApiModelProperty.class);
                    TModifyHistory tModifyHistory = new TModifyHistory();
                    tModifyHistory.setId(1);
                    tModifyHistory.setModifyBy(user.getId());
                    tModifyHistory.setModifyAt(new Date());
                    tModifyHistory.setBeforeValue(oldBeanProperty);
                    tModifyHistory.setAfterValue(newBeanProperty);
                    tModifyHistory.setModuleName(moduleName);
                    tModifyHistory.setModuleNameZh(moduleNameZh);
                    tModifyHistory.setPropertyName(newBeanField.getName());
                    tModifyHistory.setPropertyNameZh(newBeanFieldAnnotation.value());
                    tModifyHistoryList.add(tModifyHistory);
                    LogTemplate.debug("实体修改记录","compare:["+newBean.getClass().getName()+"]," +
                            "field:["+newBeanField.getName()+"],fieldZh:["+newBeanFieldAnnotation.value()+
                            "],newBeanProperty:["+newBeanProperty+"],oldBeanProperty:["
                            +oldBeanProperty+"]");
                } catch (Exception e) {
                    LogTemplate.error(e,"记录实体修改历史错误！",e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return tModifyHistoryList;
    }

}
