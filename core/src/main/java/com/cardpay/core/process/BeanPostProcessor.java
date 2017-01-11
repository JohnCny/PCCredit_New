package com.cardpay.core.process;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.grpc.GRPCServer;
import com.cardpay.mgt.menu.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

/**
 * 容器启动之后执行初始化程序(例如刷新缓存等需要初始化功能）
 *
 * @author johnmyiqn
 */
public class BeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TMenuService tMenuService;

    @Autowired
    private GRPCServer gRPCServer;

    @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
        /*需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。*/
        try {
            if (event.getApplicationContext().getParent() == null) {//root application context 没有parent，他就是老大.
                //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
//                //初始化菜单缓存
//                tMenuService.updateMenuCache();
                //启动gRPC服务监听
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            gRPCServer.start();
                            gRPCServer.blockUntilShutdown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            LogTemplate.error(BeanPostProcessor.class, e, "容器启动后指定代码异常", e.toString());
            e.printStackTrace();
        }
    }
}
