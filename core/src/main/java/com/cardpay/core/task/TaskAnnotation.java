package com.cardpay.basic.task;

import com.cardpay.basic.common.log.LogTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务(注解方式实现)
 *
 * @author rankai .
 */
@Component
public class TaskAnnotation {

//    @Scheduled(fixedRate = 1000 * 10)
    public void test() {
        LogTemplate.debug(this.getClass(), "定时任务和Log测试", "成功");
    }
}
