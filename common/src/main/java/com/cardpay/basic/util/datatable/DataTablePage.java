package com.cardpay.basic.util.datatable;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * DataTable工具类
 *
 * @author rankai
 * @create 2016-12-2016/12/21 11:06
 */
public class DataTablePage<T> {

    private int start = 0;// 起止位置'0'
    private int length = 10; // 数据长度'10'

    private long recordsTotal; // 数据总记录数
    private List<T> data;

    public DataTablePage(String methodName, BaseService<T> baseService, HttpServletRequest request, Class<T> clazz) {
        try {
            DataTablePage(methodName, baseService, request, clazz);
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

    public DataTablePage(BaseService<T> baseService, HttpServletRequest request, Class<T> clazz) {
        try {
            DataTablePage(null, baseService, request, clazz);
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

    private void DataTablePage(String methodName, BaseService<T> baseService, HttpServletRequest request, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String search = request.getParameter("search");
        String order = request.getParameter("order");
        LogTemplate.info(this.getClass(), "message(BasePage)", "[start:" + start + "][length" + length + "][search" + search + "][order" + order + "]");
        try {
            this.start = Integer.parseInt(start);
            this.length = Integer.parseInt(length);
        } catch (Exception e) {
            LogTemplate.error(this.getClass(), e, "message", "传入的参数有误");
        }
        T finalClass = null;
        if (StringUtils.isNotBlank(search)) {
            finalClass = JSON.parseObject(search, clazz);
        }
        if (finalClass == null) {
            finalClass = clazz.newInstance();
        }
        String finalOrder = "";
        if (StringUtils.isNotBlank(order)) {
            finalOrder = order.replaceAll("[{}\"]", "").replace(":", " ");
        }
        if (StringUtils.isNotBlank(methodName)) {
            PageHelper.startPage(this.start, this.length);
            if (!finalOrder.isEmpty()) {
                PageHelper.orderBy(finalOrder);
            }
            Method method;
            method = baseService.getClass().getDeclaredMethod(methodName, finalClass.getClass());
            data = (List<T>) method.invoke(baseService, clazz);
        } else {
            data = baseService.pageList(finalClass, this.start, this.length, finalOrder);
        }
        PageInfo pageInfo = new PageInfo(this.data);
        setRecordsTotal(pageInfo.getTotal());
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }
}
