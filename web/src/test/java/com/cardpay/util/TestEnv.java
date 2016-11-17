package com.cardpay.util;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.Before;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author rankai .
 * @date 2016/10/25 .
 */
@Rollback
@Transactional
@WebAppConfiguration
@ContextConfiguration(name = "child", locations = {"classpath:loan-servlet-test.xml"})
public abstract class TestEnv extends BaseTest {

    protected MockMvc mockMvc;

    protected Subject subject;

//    protected static User baseUser;
//
//    static {
//        baseUser = User.UserBuilder.get().withId(1).withName("manager").withEmail("rankawin@163.com")
//                .withPassword("7d9ca79d6ead7127c3a17fd00c1e6090").build();
//    }

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        SecurityManager securityManger = PowerMockito.mock(SecurityManager.class, Mockito.RETURNS_DEEP_STUBS);
        ThreadContext.bind(securityManger);
        subject = new Subject.Builder(getSecurityManager()).buildSubject();
        setSubject(subject);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        setUser(baseUser);
    }

//    protected void setUser(User user, String role) {
//        PowerMockito.when(subject.getPrincipal()).thenReturn(user);
//        if (StringUtils.isNotEmpty(role)) {
//            PowerMockito.when(subject.hasRole(role)).thenReturn(true);
//        } else {
//            role = user.getName();
//            switch (role) {
//                case Constant.ROLE_ADMIN:
//                    PowerMockito.when(subject.hasRole(Constant.ROLE_ADMIN)).thenReturn(true);
//                    break;
//                case Constant.ROLE_MANAGER:
//                    PowerMockito.when(subject.hasRole(Constant.ROLE_MANAGER)).thenReturn(true);
//                    break;
//                case Constant.ROLE_LEADER:
//                    PowerMockito.when(subject.hasRole(Constant.ROLE_LEADER)).thenReturn(true);
//                    break;
//                case Constant.ROLE_EXPERT:
//                    PowerMockito.when(subject.hasRole(Constant.ROLE_EXPERT)).thenReturn(true);
//                    break;
//                default:
//                    PowerMockito.when(subject.hasRole(role)).thenReturn(false);
//            }
//        }
//    }
//
//    protected void setUser(User user) {
//        setUser(user, null);
//    }
}
