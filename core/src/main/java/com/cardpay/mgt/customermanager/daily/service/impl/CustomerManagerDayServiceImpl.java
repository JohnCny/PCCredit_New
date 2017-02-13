package com.cardpay.mgt.customermanager.daily.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.daily.dao.TCustomerManagerDayMapper;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDay;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDayAndUser;
import com.cardpay.mgt.customermanager.daily.model.vo.TCustomerManagerDayAndUserVo;
import com.cardpay.mgt.customermanager.daily.service.CustomerManagerDayService;
import com.cardpay.mgt.user.enums.UserStatus;
import com.cardpay.mgt.user.model.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 客户经理日报类
 * @author yanweichen
 */
@Service
public class CustomerManagerDayServiceImpl extends BaseServiceImpl<TCustomerManagerDay> implements CustomerManagerDayService {

    @Autowired
    private TCustomerManagerDayMapper customerManagerDayMapper;

    @Override
    @Scheduled(cron = "0 00 0 * * ?")
    public void initDaily() {
        customerManagerDayMapper.initDaily();
    }

    @Override
    public List<TCustomerManagerDayAndUserVo> selectDailyAndUserVo(Map<String, Object> map) {
        List<TCustomerManagerDayAndUser> customerManagerDayAndUserList = selectDailyAndUser(map);
        List<TCustomerManagerDayAndUserVo> customerManagerDayAndUserVoList = new ArrayList<>();
        for (TCustomerManagerDayAndUser customerManagerDayAndUser : customerManagerDayAndUserList) {
            TCustomerManagerDayAndUserVo customerManagerDayAndUserVo = new TCustomerManagerDayAndUserVo();
            customerManagerDayAndUserVo.setCustomerManagerId(customerManagerDayAndUser.getCustomerManagerDay().getCustomerManagerId());
            customerManagerDayAndUserVo.setDailyTime(customerManagerDayAndUser.getCustomerManagerDay().getDailyTime());
            customerManagerDayAndUserVo.setEmployeeNumber(customerManagerDayAndUser.getUser().getEmployeeNumber());
            customerManagerDayAndUserVo.setUserCname(customerManagerDayAndUser.getUser().getUserCname());
            customerManagerDayAndUserVoList.add(customerManagerDayAndUserVo);
        }
        return customerManagerDayAndUserVoList;
    }

    @Override
    public List<TCustomerManagerDayAndUser> selectDailyAndUser(Map<String, Object> map) {
        List<TCustomerManagerDayAndUser> customerManagerDayAndUserList = customerManagerDayMapper.selectDailyAndUser(map);
        return customerManagerDayAndUserList;
    }

    @Override
    public void expertExcel(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> map = new HashMap();
        //查看当前机构下的客户经理
        map.put("organizationId", ShiroKit.getOrgId());
        map.put("status", UserStatus.NORMAL.getStatus());
        DataTablePage dataTablePage = new DataTablePage("selectDailyAndUser",this,request,map);
        List<Object> objects = dataTablePage.getData();
        List<TCustomerManagerDayAndUser> customerManagerDayAndUserList = new ArrayList<>();
        for (Object object : objects) {
            customerManagerDayAndUserList.add((TCustomerManagerDayAndUser) object);
        }
        Date dailyTime = customerManagerDayAndUserList.get(0).getCustomerManagerDay().getDailyTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dailyTimeStr = sdf.format(dailyTime);
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet= wb.createSheet("客户经理日报("+dailyTimeStr+")");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("客户经理日报");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("员工号");
        row2.createCell(2).setCellValue("拜访/新增客户数");
        row2.createCell(3).setCellValue("客户维护数");
        row2.createCell(4).setCellValue("新申请贷款数");
        row2.createCell(5).setCellValue("贷前调查数量");
        row2.createCell(6).setCellValue("贷后监控数量");
        for (int i = 0; i < customerManagerDayAndUserList.size(); i++) {
            TCustomerManagerDayAndUser customerManagerDayAndUser = customerManagerDayAndUserList.get(i);
            HSSFRow row=sheet.createRow(i+2);
            User user = customerManagerDayAndUser.getUser();
            TCustomerManagerDay customerManagerDay = customerManagerDayAndUser.getCustomerManagerDay();
            row.createCell(0).setCellValue(user.getUserCname());
            row.createCell(1).setCellValue(user.getEmployeeNumber());
            row.createCell(2).setCellValue(customerManagerDay.getVisitNewNumber());
            row.createCell(3).setCellValue(customerManagerDay.getMaintenanceNumber());
            row.createCell(4).setCellValue(customerManagerDay.getLoanNewNumber());
            row.createCell(5).setCellValue(customerManagerDay.getPreLoanNumber());
            row.createCell(6).setCellValue(customerManagerDay.getPostLoanNumber());
//            row.createCell(2).setCellValue(customerManagerDayAndUser.getVisitNewNumber());
//            row.createCell(3).setCellValue(customerManagerDayAndUser.getMaintenanceNumber());
//            row.createCell(4).setCellValue(customerManagerDayAndUser.getLoanNewNumber());
//            row.createCell(5).setCellValue(customerManagerDayAndUser.getPreLoanNumber());
//            row.createCell(6).setCellValue(customerManagerDayAndUser.getPostLoanNumber());
        }

        //输出Excel文件
        try {
            OutputStream output=response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename="+ URLEncoder.encode("客户经理日报("+dailyTimeStr+")","UTF-8")+".xls");
            response.setContentType("application/msexcel");
            response.setCharacterEncoding("UTF-8");
            wb.write(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
