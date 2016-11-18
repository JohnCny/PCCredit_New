package com.cardpay.basic.common.radis.service;

import com.cardpay.basic.common.radis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * webSocketRedis 操作
 * Created by chenkai on 2016/11/18.
 */
public class WebSocketRedis {
    @Autowired
    private RedisClient redisClient;

    private List<WebSocketSession> users = new ArrayList<>();

    private Map<Integer, WebSocketSession> webSocketSessions = new HashMap<>();

    public void insert(WebSocketSession session){
        // userId = ShiroKit.getUser().getId();
       // redisClient.set(USER,);
    }
}
