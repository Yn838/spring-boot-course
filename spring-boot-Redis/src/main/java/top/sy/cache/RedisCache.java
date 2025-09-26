package top.sy.cache;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {
    /**
     * 默认过期时长为24小时，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24L;
    /**
     * 过期时长为1小时，单位：秒
     */
    public final static long HOUR_ONE_EXPIRE = 60 * 60 * 1L;
    /**
     * 过期时长为6小时，单位：秒
     */
    public final static long HOUR_SIX_EXPIRE = 60 * 60 * 6L;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1L;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置缓存，指定过期时间
     *
     * @param key    缓存键
     * @param value  缓存值
     * @param expire 过期时间(秒)，NOT_EXPIRE表示永不过期
     */
    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value);
        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    /**
     * 设置缓存，使用默认过期时间(24小时)
     *
     * @param key   缓存键
     * @param value 缓存值
     */
    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 获取缓存，指定过期时间续期
     *
     * @param key    缓存键
     * @param expire 过期时间(秒)，NOT_EXPIRE表示不续期
     * @return 缓存值
     */
    public Object get(String key, long expire) {
        Object value = redisTemplate.opsForValue().get(key);
        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
        return value;
    }

    /**
     * 获取缓存，不续期
     *
     * @param key 缓存键
     * @return 缓存值
     */
    public Object get(String key) {
        return get(key, NOT_EXPIRE);
    }

    /**
     * 自增操作
     *
     * @param key 缓存键
     * @return 自增后的值
     */
    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     * 判断键是否存在
     *
     * @param key 缓存键
     * @return 存在返回true，否则返回false
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除单个缓存
     *
     * @param key 缓存键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param keys 缓存键集合
     */
    public void delete(Collection<String> keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 获取Hash类型中的单个字段值
     *
     * @param key   缓存键
     * @param field 字段名
     * @return 字段值
     */
    public Object hGet(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取Hash类型中的所有字段和值
     *
     * @param key 缓存键
     * @return 字段-值映射
     */
    public Map<String, Object> hGetAll(String key) {
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(key);
    }

    /**
     * 批量设置Hash类型的字段和值，使用默认过期时间
     *
     * @param key 缓存键
     * @param map 字段-值映射
     */
    public void hMSet(String key, Map<String, Object> map) {
        hMSet(key, map, DEFAULT_EXPIRE);
    }

    /**
     * 批量设置Hash类型的字段和值，指定过期时间
     *
     * @param key    缓存键
     * @param map    字段-值映射
     * @param expire 过期时间(秒)
     */
    public void hMSet(String key, Map<String, Object> map, long expire) {
        redisTemplate.opsForHash().putAll(key, map);

        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    /**
     * 设置Hash类型的单个字段值，使用默认过期时间
     *
     * @param key   缓存键
     * @param field 字段名
     * @param value 字段值
     */
    public void hSet(String key, String field, Object value) {
        hSet(key, field, value, DEFAULT_EXPIRE);
    }

    /**
     * 设置Hash类型的单个字段值，指定过期时间
     *
     * @param key    缓存键
     * @param field  字段名
     * @param value  字段值
     * @param expire 过期时间(秒)
     */
    public void hSet(String key, String field, Object value, long expire) {
        redisTemplate.opsForHash().put(key, field, value);

        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    /**
     * 设置键的过期时间
     *
     * @param key    缓存键
     * @param expire 过期时间(秒)
     */
    public void expire(String key, long expire) {
        redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 删除Hash类型中的多个字段
     *
     * @param key    缓存键
     * @param fields 字段名数组
     */
    public void hDel(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 向List类型的左侧添加元素，使用默认过期时间
     *
     * @param key   缓存键
     * @param value 元素值
     */
    public void leftPush(String key, Object value) {
        leftPush(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 向List类型的左侧添加元素，指定过期时间
     *
     * @param key    缓存键
     * @param value  元素值
     * @param expire 过期时间(秒)
     */
    public void leftPush(String key, Object value, long expire) {
        redisTemplate.opsForList().leftPush(key, value);

        if (expire != NOT_EXPIRE) {
            expire(key, expire);
        }
    }

    /**
     * 从List类型的右侧弹出元素
     *
     * @param key 缓存键
     * @return 弹出的元素值
     */
    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }
}
