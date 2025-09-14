package top.sy.service;

import org.springframework.web.multipart.MultipartFile;
import top.sy.enums.ResultStatus;
import top.sy.model.Mail;


public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);
    ResultStatus sendHtmlMail(Mail mail);

    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);
}
