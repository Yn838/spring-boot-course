package top.sy.model;

import lombok.Data;

@Data
public class Mail {
    private String content;
    private String to;
    private String subject;
}
