package top.sy.service;

import org.springframework.stereotype.Service;
import top.sy.exception.BusinessException;


@Service
public class ExceptionService {
    public void unAuthorizeError(){
        throw new BusinessException("权限不足");
    }
    public void systemError(){
        throw new BusinessException("系统错误");
    }
    public void Zero(){
        throw new BusinessException("1/0错误");
    }
}
