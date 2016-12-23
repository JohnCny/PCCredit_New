package com.cardpay.basic.util.datatable;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DataTable工具类
 *
 * @author rankai
 *         Timecreate 2016-12-2016/12/21 11:06
 */
public class DataTablePage {

    private int start = 0;// 起止位置'0'
    private int length = 10; // 数据长度'10'

    private long recordsTotal; // 数据总记录数
    private List<Object> data;

    public DataTablePage(String methodName, BaseService baseService, HttpServletRequest request, Map<String, Object> map) {
        try {
            DataTablePage(methodName, baseService, request, null, null, map);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public DataTablePage(String methodName, BaseService baseService, HttpServletRequest request) {
        try {
            DataTablePage(methodName, baseService, request, null, null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public DataTablePage(BaseService baseService, HttpServletRequest request, Class clazz, Example example) {
        try {
            DataTablePage(null, baseService, request, clazz, example, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    private void DataTablePage(String methodName, BaseService baseService, HttpServletRequest request, Class clazz, Example example, Map<String, Object> parameterMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String search = request.getParameter("search");
        String order = request.getParameter("order");
        LogTemplate.info(this.getClass(), "message(BasePage)", "[start:" + start + "][length" + length + "][search" + search + "][order" + order + "]");
        this.start = start != null ? Integer.parseInt(start) : this.start;
        this.length = length != null ? Integer.parseInt(length) : this.length;
        String finalOrder = "";
        if (StringUtils.isNotBlank(order)) {
            Map<String, String> map = JSON.parseObject(order, Map.class);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    finalOrder = entry.getKey() + " " + entry.getValue();
                    break;
                }
            }
        }
        Map<String, Object> map = JSON.parseObject(search, Map.class);


        if (StringUtils.isNotBlank(methodName)) {
            if (parameterMap != null) {
                if (map != null) {
                    map.putAll(parameterMap);
                } else {
                    map = parameterMap;
                }
            }
            map = removeNull(map);
            Method method;
            method = baseService.getClass().getDeclaredMethod(methodName, Map.class);
            PageHelper.startPage(this.start, this.length);
            PageHelper.orderBy(finalOrder);
            data = (List<Object>) method.invoke(baseService, map);
        } else {
            if (example == null) {
                map = removeNull(map);
                example = new Example(clazz);
                example.orderBy(finalOrder);
                if (map != null) {
                    Example.Criteria criteria = example.createCriteria();
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        criteria.andEqualTo(entry.getKey(), entry.getValue());
                    }
                }
            }
            data = (List<Object>) baseService.pageList(example, this.start, this.length);
        }
        PageInfo pageInfo = new PageInfo(this.data);
        setRecordsTotal(pageInfo.getTotal());
    }

    private Map<String, Object> removeNull(Map<String, Object> map) {
        Map<String, Object> newMap = new HashMap();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (StringUtils.isBlank(entry.getKey()) || StringUtils.isBlank((String) entry.getValue())) {
                    continue;
                }
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
