package com.cardpay.core.fastdfs.pool;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 * createTime 2017-01-2017/1/13 10:13
 */

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * fastdfs连接池定时器
 *
 * @author chenkai
 *         createTime 2017-1-2017/1/13 10:01
 */
public class HeartBeat {
    /** fastdfs连接池 */
    @Autowired
    private ConnectionPool pool;
    /** 小时毫秒数 */
    public static int ahour = 1000 * 60 * 60 * 1;
    /** 等待时间 */
    public static int waitTimes = 200;

    public HeartBeat(ConnectionPool pool) {
        this.pool = pool;
    }

    /**
     *
     * @Description: 定时执行任务，检测当前的空闲连接是否可用，如果不可用将从连接池中移除
     *
     */
    public void beat() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                LinkedBlockingQueue<TrackerServer> idleConnectionPool = pool
                        .getIdleConnectionPool();
                TrackerServer ts = null;
                for (int i = 0; i < idleConnectionPool.size(); i++) {
                    try {
                        ts = idleConnectionPool.poll(waitTimes,
                                TimeUnit.SECONDS);
                        if (ts != null) {
                            org.csource.fastdfs.ProtoCommon.activeTest(ts
                                    .getSocket());
                            idleConnectionPool.add(ts);
                        } else {
                            /** 代表已经没有空闲长连接 */
                            break;
                        }
                    } catch (Exception e) {
                        e.getMessage();
                        pool.drop(ts);
                    }
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, ahour, ahour);
    }

}