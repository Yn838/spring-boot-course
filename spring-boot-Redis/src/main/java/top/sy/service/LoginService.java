package top.sy.service;

import top.sy.entity.LoginRequest;
import top.sy.entity.LoginResponse;

public interface LoginService {
    /**
     * 验证码登录
     *
     * @param loginRequest 登录请求参数
     * @return 登录响应
     */
    LoginResponse login(LoginRequest loginRequest);
}