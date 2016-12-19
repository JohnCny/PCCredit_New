package com.cardpay.basic.redis.service;

import com.cardpay.basic.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.*;

import static com.cardpay.basic.redis.enums.RedisKeyPrefixEnum.USER;

/**
 * webSocket封装Redis 类
 * @author johnmyiqn
 */
@Component
public class WebSocketRedis {
    @Autowired
    private RedisClient redisClient;

    private Map<Integer, WebSocketSession> webSocketSessions = new HashMap<>();

    private static final String flag = "userAll";

    /**
     * 给redis中添加此用户的信息
     *
     * @param session WebSocketSession
     */
    public void add(WebSocketSession session) {
        //Integer userId = (Integer) session.getAttributes().get(Constant.WEBSOCKET_USERID);
       // User user = (User)SecurityUtils.getSubject().getPrincipal();
        webSocketSessions.put(1, session);
        redisClient.set(USER, "1", new ArrayList<>());
      //  redisClient.set(USER, flag, webSocketSessions);
    }

    /**
     * 根据用户id获取redis中用户信息
     *
     * @param userId 用户id
     * @return redis中存储的信息
     */
    public Object get(Integer userId) {
        if (redisClient.exists(USER, userId.toString())) {
            return redisClient.get(USER, userId.toString());
        }
        return new Object();
    }

    /**
     * 查询redis中所有存储的WebSocketSession信息
     *
     * @return WebSocketSession信息
     */
    public List<WebSocketSession> queryAll() {
        if (redisClient.exists(USER, flag)) {
            Map<Integer, WebSocketSession> map = (Map<Integer, WebSocketSession>) redisClient.get(USER, "userAll");
            Collection<String> redisKeys = null;
            /*map.keySet().forEach(id ->redisKeys.add(id.toString()));
            return redisClient.getObjects(redisKeys).stream()
                    .map(obj -> (WebSocketSession)obj).collect(Collectors.toList());*/
        }
        return new ArrayList<>();
    }

    /**
     * 删除redis次用户信息
     * @param session WebSocketSession
     */
    public void delete (WebSocketSession session){
       // Integer userId = (Integer) session.getAttributes().get(Constant.WEBSOCKET_USERID);
        redisClient.delete(USER, "1");
    }

}
