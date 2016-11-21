package com.cardpay.basic.util;/**
 * Created by johnmyiqn on 2016/11/3.
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * List按照指定字段排序工具类
 * @author johnmyiqn
 **/
public class ListSortUtil<T> {
    /**
     * list按照对象指定字段排序
     * @param targetList 目标排序List
     * @param key 排序字段(map中key值)
     * @param sortMode 排序方式（0 正序， 1 倒序）
     */
    public void sortMap(List<T> targetList, final String key, final Integer sortMode) {
        Collections.sort(targetList, (obj1, obj2) -> {
            int retVal = 0;
            try {
                //获取map对象
                Map<String,Object> map1 = (Map<String,Object>)obj1;
                Map<String,Object> map2 = (Map<String,Object>)obj2;

                Integer str1 = (Integer)map1.get(key);
                Integer str2 = (Integer)map2.get(key);

                if (sortMode != null && sortMode == 1) {
                    retVal = str2.compareTo(str1); // 倒序
                } else {
                    retVal = str1.compareTo(str2); // 正序
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
            return retVal;
        });
    }
}
