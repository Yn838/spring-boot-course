package top.sy.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String phone;
    private String code;
}