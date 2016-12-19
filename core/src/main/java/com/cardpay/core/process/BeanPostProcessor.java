package com.cardpay.core.process;

import com.cardpay.JRService.JRServiceServer;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.mgt.menu.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

/**
 * 容器启动之后执行初始化程序(例如刷新缓存等需要初始化功能）
 * @author johnmyiqn
 */
public class BeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TMenuService tMenuService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。*/
        try {
            //初始化菜单缓存
            tMenuService.updateMenuCache();
            //启动grpc服务监听
            new Thread(){
                @Override
                public void run() {
                    final JRServiceServer server = new JRServiceServer();
                    try {
                        server.start();
                        server.blockUntilShutdown();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        } catch (Exception e) {
            LogTemplate.error(BeanPostProcessor.class,e,"容器启动后指定代码异常",e.toString());
            e.printStackTrace();
        }
    }
}
