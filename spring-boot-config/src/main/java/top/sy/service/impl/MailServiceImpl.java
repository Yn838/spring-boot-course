package top.sy.service.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import top.sy.enums.ResultStatus;
import top.sy.model.Mail;
import top.sy.service.MailService;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Resource
    private JavaMailSender javaMailSender;

@Override
public ResultStatus sendSimpleMail(Mail mail){
       SimpleMailMessage message = new SimpleMailMessage();
       message.setFrom(from);
       message.setTo(mail.getTo());
       message.setSubject(mail.getSubject());
       message.setText(mail.getContent());
       try {
           javaMailSender.send(message);
           return ResultStatus.SUCCESS;
       } catch (Exception e) {
           return ResultStatus.FAIL;
       }
   }

}
