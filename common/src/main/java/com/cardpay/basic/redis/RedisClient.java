package com.cardpay.basic.redis;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * redis接口,操作redis的方法
 *
 * @author rankai
 */
@Component()
public class RedisClient {

    @Autowired
    private LogTemplate logger;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 创建redisTemplate对象
     *
     * @return RedisTemplate对象
     */
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 向redis中存放一个Object的值(包含过期时间)
     *
     * @param keyPrefix   模块名称
     * @param key         键
     * @param value       值
     * @param validPeriod 过期时间(单位:秒)
     */
    public void set(RedisKeyPrefixEnum keyPrefix, String key, Object value, int validPeriod) {
        String redisKey = buildKey(keyPrefix, key);
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        opt.set(redisKey, value, validPeriod, TimeUnit.SECONDS);
    }

    /**
     * 向redis中存放一个Object的值（没有过期时间）
     *
     * @param keyPrefix 模块名称
     * @param key       键
     * @param value     值
     */
    public void set(RedisKeyPrefixEnum keyPrefix, String key, Object value) {
        String redisKey = buildKey(keyPrefix, key);
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        opt.set(redisKey, value);
    }

    /**
     * 根据键获取value值
     *
     * @param keyPrefix 模块名称
     * @param key       键
     * @return 值
     */
    public Object get(RedisKeyPrefixEnum keyPrefix, String key) {
        String redisKey = buildKey(keyPrefix, key);
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        try {
            return opt.get(redisKey);
        } catch (SerializationException se) {
            logger.warn(se, "Error happened when getting RedisKeyPrefixEnum:key from Redis!", null);
            return null;
        }
    }

    /**
     * 根据键key删除value值
     *
     * @param keyPrefix 模块名称
     * @param key       键
     */
    public void delete(RedisKeyPrefixEnum keyPrefix, String key) {
        String redisKey = buildKey(keyPrefix, key);
        redisTemplate.delete(redisKey);
    }

    /**
     * 根据键key判断值是否存在
     *
     * @param keyPrefix 模块名称
     * @param key       键
     * @return 是否存在
     */
    public boolean exists(RedisKeyPrefixEnum keyPrefix, String key) {
        return (this.get(keyPrefix, key) != null);
    }

    /**
     * 获取redis key值
     *
     * @param keyPrefix 模块名称
     * @param key       键
     * @return 值
     */
    public String buildKey(RedisKeyPrefixEnum keyPrefix, String key) {
        return keyPrefix.getKeyPrefix() + ":" + key;
    }

    /**
     * 根据key值,设置该key过期时间
     *
     * @param keyPrefix   模块名称
     * @param key         键
     * @param validPeriod expired time with second. 过期时间(秒)
     */
    public void setExpiredTime(RedisKeyPrefixEnum keyPrefix, String key, long validPeriod) {
        String redisKey = buildKey(keyPrefix, key);
        redisTemplate.expire(redisKey, validPeriod, TimeUnit.SECONDS);
    }

    /**
     * 根据keys值做批量查询
     *
     * @param redisKeys 要查询keys的集合
     * @return 值列表
     */
    public List<Object> getObjects(Collection<String> redisKeys) {

        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        try {
            return opt.multiGet(redisKeys);
        } catch (SerializationException se) {
            logger.warn(se, "Error happened when getting redisKeys from Redis!", null);
            return null;
        }
    }

    /**
     * 根据键直接删除(无需空间)
     *
     * @param key 键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 根据键获取值,不加前缀的key
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        try {
            return opt.get(key);
        } catch (SerializationException se) {
            logger.warn(se, "Error happened when getting key from Redis!", null);
            return null;
        }
    }

    /**
     * 向redis中增加值,不加前缀的key
     *
     * @param key         键
     * @param value       值
     * @param validPeriod 过期时间(秒)
     */
    public void set(String key, Object value, int validPeriod) {
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        opt.set(key, value, validPeriod, TimeUnit.SECONDS);
    }

    /**
     * 向redis中增加值,不加前缀的key,没有过期时间
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        ValueOperations<String, Object> opt = redisTemplate.opsForValue();
        opt.set(key, value);
    }

    /**
     * 获取键剩余过期时间
     *
     * @param key
     * @return
     */
    public Long getTime(String key) {
        return redisTemplate.getExpire(key);
    }
}
