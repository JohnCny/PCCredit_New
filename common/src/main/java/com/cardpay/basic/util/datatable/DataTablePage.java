package com.cardpay.basic.util.datatable;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.log.LogTemplate;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
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

    public DataTablePage(BaseService<T> baseService, HttpServletRequest request, Class<T> clazz) {
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        String search = request.getParameter("search");
        LogTemplate.info(this.getClass(), "start", start);
        LogTemplate.info(this.getClass(), "length", length);
        LogTemplate.info(this.getClass(), "search", search);
        try {
            this.start = Integer.parseInt(start);
            this.length = Integer.parseInt(length);
        } catch (Exception e) {
            LogTemplate.error(this.getClass(), e, "message", "传入的参数有误");
        }
        T entityClass = null;
        if (StringUtils.isNoneBlank(search)) {
            entityClass = (T) JSON.parseObject(search, clazz);
        }
        data = baseService.pageList(entityClass, this.start, this.length);
        PageInfo pageInfo = new PageInfo(data);
        recordsTotal = pageInfo.getTotal();
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
