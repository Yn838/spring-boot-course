package top.sy.service;

import top.sy.enums.ResultStatus;
import top.sy.model.Mail;


public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);

}
