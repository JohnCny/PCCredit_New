package com.cardpay.core.fastdfs.pool;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 10:12
 */
import java.io.File;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.cardpay.core.fastdfs.FileManager;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import static com.cardpay.core.fastdfs.FileManagerConfig.CLIENT_CONFIG_FILE;

/**
 * fastdfs连接池
 *
 * @author chenkai
 *         createTime 2017-1-2017/1/13 10:01
 */
@Component
public class ConnectionPool {
    /** 空闲的连接池 */
    private LinkedBlockingQueue<TrackerServer> idleConnectionPool = null;
    /** 连接池默认最小连接数 */
    private long minPoolSize = 10;
    /** 连接池默认最大连接数 */
    private long maxPoolSize = 50;
    /** 当前创建的连接数 */
    private volatile long nowPoolSize = 0;
    /** 默认等待时间（单位：秒） */
    private long waitTimes = 200;
    /** fastdfs客户端创建连接默认1次 */
    private static final int COUNT = 1;
    private HeartBeat beat;

    public ConnectionPool(){
        /** 初始化连接池 */
        beat = new HeartBeat(this);
        poolInit();
        /** 注册定时器*/
        beat.beat();
    }

    /**
     *
     * @Description: 连接池初始化 (在加载当前ConnectionPool时执行) 1).加载配置文件 2).空闲连接池初始化；
     *               3).创建最小连接数的连接，并放入到空闲连接池；
     *
     */
    private void poolInit() {
        try {
            /** 加载配置文件 */
            initClientGlobal();
            /** 初始化空闲连接池 */
            idleConnectionPool = new LinkedBlockingQueue<>();
            /** 往线程池中添加默认大小的线程 */
            for (int i = 0; i < minPoolSize; i++) {
                createTrackerServer(COUNT);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     *
     * @Description: 创建TrackerServer,并放入空闲连接池
     *
     */
    public void createTrackerServer(int flag) {

        TrackerServer trackerServer = null;

        try {

            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            while (trackerServer == null && flag < 5) {
                flag++;
                initClientGlobal();
                trackerServer = trackerClient.getConnection();
            }
            org.csource.fastdfs.ProtoCommon.activeTest(trackerServer
                    .getSocket());
            idleConnectionPool.add(trackerServer);
            /** 同一时间只允许一个线程对nowPoolSize操作 **/
            synchronized (this) {
                nowPoolSize++;
            }

        } catch (Exception e) {
            e.getMessage();

        } finally {

            if (trackerServer != null) {
                try {
                    trackerServer.close();
                } catch (Exception e) {
                    e.getMessage();
                }
            }

        }
    }

    /**
     *
     * @Description: 获取空闲连接 1).在空闲池（idleConnectionPool)中弹出一个连接；
     *               2).把该连接放入忙碌池（busyConnectionPool）中; 3).返回 connection
     *               4).如果没有idle connection, 等待 wait_time秒, and check again
     *
     * @throws Exception
     *
     */
    public TrackerServer checkout() throws Exception {

        TrackerServer trackerServer = idleConnectionPool.poll();

        if (trackerServer == null) {

            if (nowPoolSize < maxPoolSize) {
                createTrackerServer( COUNT);
                try {
                    trackerServer = idleConnectionPool.poll(waitTimes,
                            TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        return trackerServer;

    }

    /**
     *
     * @Description: 释放繁忙连接 1.如果空闲池的连接小于最小连接值，就把当前连接放入idleConnectionPool；
     *               2.如果空闲池的连接等于或大于最小连接值，就把当前释放连接丢弃；
     *
     *            需释放的连接对象
     *
     */

    public void checkin(TrackerServer trackerServer) {

        if (trackerServer != null) {
            if (idleConnectionPool.size() < minPoolSize) {
                idleConnectionPool.add(trackerServer);
            } else {
                synchronized (this) {
                    if (nowPoolSize != 0) {
                        nowPoolSize--;
                    }
                }
            }
        }

    }

    /**
     *
     * @Description: 删除不可用的连接，并把当前连接数减一（调用过程中trackerServer报异常，调用一般在finally中）
     * @param trackerServer
     *
     */
    public void drop(TrackerServer trackerServer) {
        if (trackerServer != null) {
            try {
                synchronized (this) {
                    if (nowPoolSize != 0) {
                        nowPoolSize--;
                    }
                }
                trackerServer.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    private void initClientGlobal() throws Exception {
       // String classPath = new File(FileManager.class.getResource(File.separator).getFile()).getCanonicalPath();
        //String fastDfsClientConfigFilePath = classPath + "../../../\\resources\\main" + File.separator + CLIENT_CONFIG_FILE;
       // String fastDfsClientConfigFilePath = classPath + File.separator + CLIENT_CONFIG_FILE;
        ClassPathResource classPath = new ClassPathResource(CLIENT_CONFIG_FILE);
        String fastDfsClientConfigFilePath = classPath.getClassLoader().getResource(CLIENT_CONFIG_FILE).getPath();
        ClientGlobal.init(fastDfsClientConfigFilePath);
    }

    public LinkedBlockingQueue<TrackerServer> getIdleConnectionPool() {
        return idleConnectionPool;
    }

    public long getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(long minPoolSize) {
        if (minPoolSize != 0) {
            this.minPoolSize = minPoolSize;
        }
    }

    public long getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(long maxPoolSize) {
        if (maxPoolSize != 0) {
            this.maxPoolSize = maxPoolSize;
        }
    }

    public long getWaitTimes() {
        return waitTimes;
    }

    public void setWaitTimes(int waitTimes) {
        if (waitTimes != 0) {
            this.waitTimes = waitTimes;
        }
    }
}


