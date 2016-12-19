package com.cardpay.basic.httpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数生成工具类
 * @author rankai
 */
public class ParamsBuild {

    public static ParamsBuild getParams() {
        return new ParamsBuild();
    }

    private Map<String, String> map;

    private ParamsBuild() {
        map = new HashMap<>();
    }

    public ParamsBuild put(String key, String value) {
        map.put(key, value);
        return this;
    }

    public Map<String, String> build() {
        return map;
    }
}
