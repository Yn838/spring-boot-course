package top.sy.service;
import org.springframework.stereotype.Service;

@Service
public interface SmsService {
    boolean sendSms(String phone);
}