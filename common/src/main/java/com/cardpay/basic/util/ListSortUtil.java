package com.cardpay.basic.util;/**
 * Created by johnmyiqn on 2016/11/3.
 */

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections4.ComparatorUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * List按照指定字段排序工具类
 *
 * @author johnmyiqn
 **/
public class ListSortUtil {
    /**
     * list按照对象指定字段排序
     *
     * @param targetList 目标排序List
     * @param key        排序字段(map中key值)
     * @param sortMode   排序方式（0 正序， 1 倒序）
     * @param <T>        范型
     */
    public static <T> void sortMap(List<T> targetList, final String key, final Integer sortMode) {
        Comparator comparator = ComparableComparator.getInstance();
        comparator = ComparatorUtils.nullLowComparator(comparator);  //允许null
        if (sortMode == 1) {
            comparator = ComparatorUtils.reversedComparator(comparator); //逆序
        }
        Collections.sort(targetList, new BeanComparator(key, comparator));
    }
}
