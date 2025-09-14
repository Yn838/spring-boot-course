package top.sy.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Mail {
    @NotBlank
    private String content;

    @NotBlank
    @Email
    private String to;

    @NotBlank
    private String subject;
}
