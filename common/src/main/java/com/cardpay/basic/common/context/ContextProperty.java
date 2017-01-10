package com.cardpay.basic.common.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 获取配置文件properties文件数据
 * @author rankai .
 */
public class ContextProperty extends PropertyPlaceholderConfigurer {

    private static Map<String, Object> ctxPropertiesMap = new HashMap<>();

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    /**
     * properties文件读取
     * @param name  名称
     * @return 名称对应值
     */
    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
}
