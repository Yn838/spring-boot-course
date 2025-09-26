package top.sy.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import top.sy.annotation.Phone;

@Data
public class User {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Max(value = 100, message = "年龄不能大于100")
    @Min(value = 1, message = "年龄不能小于1")
    private Integer age;

    @Phone
    private String phone;
}
