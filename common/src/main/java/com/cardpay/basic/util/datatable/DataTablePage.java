package com.cardpay.basic.util.datatable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ReflectUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author rankai
 * @create 2016-12-2016/12/21 11:06
 */
public class DataTablePage<T extends GenericEntity<PK>, PK> {


    private int draw; // 第几次请求
    private int start = 0;// 起止位置'0'
    private int length = 10; // 数据长度'10'

    private List<T> data;
    private int recordsTotal; // 数据总记录数
//    private int recordsFiltered; // 过滤数

    public DataTablePage(BaseService<T> baseService, WebRequest request) {
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String search = request.getParameter("search");
        LogTemplate.info(this.getClass(), "start", start);
        LogTemplate.info(this.getClass(), "length", length);
        LogTemplate.info(this.getClass(), "length", length);
        try {
            this.start = Integer.parseInt(start);
            this.length = Integer.parseInt(length);
        } catch (Exception e) {
            LogTemplate.error(this.getClass(), e, "message", "传入的参数有误");
        }
        T entity = null;
        if (StringUtils.isNoneBlank(search)) {
            Class clazz = null;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
                clazz = (Class<T>) parameterizedType[0];
            }
            entity = (T) JSON.parseObject(search, clazz);
        }
        data = baseService.pageStartList(entity, this.start, this.length);
        recordsTotal = baseService.selectCount(entity);
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
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

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
