package top.sy.cache;

public class RedisKeys {

    /**
     * 生成短信验证码的缓存键
     * @param phone 手机号
     * @return 格式化的缓存键
     */
    public static String getSmsKey(String phone) {
        return "sms:captcha:" + phone;
    }
}
