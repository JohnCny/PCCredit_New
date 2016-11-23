package com.cardpay.basic.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author rankai .
 * @date 2016/11/22 .
 */
@Component
public class TaskClass {

    @Scheduled(fixedRate = 1000 * 2)
    public void test() {
        System.out.println("测试定时任务");
    }
}
