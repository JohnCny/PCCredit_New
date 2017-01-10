package com.cardpay.controller.system;

import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/10 16:34
 */
public class SysParameterControllerTest extends TestEnv {
    private User user = User.UserBuilder.get().withId(1).build();

    @Test
    @Ignore
    public void update() throws Exception {
        setUser(user);
        mockMvc.perform(put("/api/system")
                .param("id", "1").param("parameterName", "test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

}