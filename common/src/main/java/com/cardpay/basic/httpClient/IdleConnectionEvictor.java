package com.cardpay.basic.httpClient;

import com.cardpay.basic.common.log.LogTemplate;
import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 单独进程清理失效的Http请求
 */
public class IdleConnectionEvictor extends Thread {

    private final HttpClientConnectionManager connMgr;
    private volatile boolean shutdown;

    /**
     * 构造函数
     * @param connMgr http请求连接管理对象
     */
    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
        // 启动当前线程
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(1000*60*10);
                    // 关闭失效的连接
                    connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException ex) {
            // 结束
            LogTemplate.error(IdleConnectionEvictor.class,ex,"清理http请求进程异常终止",null);
        }
    }

    /**
     * 关闭进程
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
