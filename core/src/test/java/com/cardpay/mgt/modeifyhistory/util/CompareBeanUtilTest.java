package com.cardpay.mgt.modeifyhistory.util;

import com.cardpay.basic.util.DateTimeUtil;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;
import com.cardpay.util.TestEnv;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.Date;
import java.util.List;

/**
 * Bean对比工具测试
 *
 * Created by yanwe on 2016/12/5.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({CompareBeanUtil.class})
public class CompareBeanUtilTest extends TestEnv{

    @Test
    public void getCompareResultTest() throws Exception {
        TestBean testBean = new TestBean();
        testBean.setTestDate(DateTimeUtil.format("2016-12-05 14:25:15",DateTimeUtil.NORM_DATETIME_PATTERN));
        testBean.setTestNum(1);
        testBean.setTestStr("Test");
        TestBean newTestBean = new TestBean();
        newTestBean.setTestStr("ModifyTest");
        newTestBean.setTestDate(DateTimeUtil.format("2016-12-05 16:25:15",DateTimeUtil.NORM_DATETIME_PATTERN));
        newTestBean.setTestNum(2);
        List<TModifyHistory> compareResult =
                CompareBeanUtil.getCompareResult(testBean, newTestBean, "TestModule", "测试模块");
        boolean result = compareResult.stream()
                .anyMatch(bean -> bean.getBeforeValue().equals("2016-12-05 14:25:15") &&
                                  bean.getAfterValue().equals("2016-12-05 16:25:15"));
        Assert.assertTrue(result);
    }
}