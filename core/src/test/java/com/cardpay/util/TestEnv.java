package com.cardpay.util;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * 用于统一简化测试类的注解标记
 *
 * @author licho on 2016/7/2.
 * 修改 johnmyqin 添加powerMock和spring test整合
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@PowerMockIgnore("javax.management.*")
@ContextConfiguration(locations={ "classpath:config/spring-core-config-test.xml","classpath:loan-servlet-test.xml"})
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
@Transactional   //标明此方法需使用事务
@Rollback(true)  //标明使用完此方法后事务不回滚,true时为回滚
public abstract class TestEnv{
    private static SubjectThreadState threadState;
    protected static Subject mockSubject;

    @Before
    public void setUp() throws Exception {
        mockSubject = Mockito.mock(Subject.class);
        threadState = new SubjectThreadState(mockSubject);
        threadState.bind();
    }
}
