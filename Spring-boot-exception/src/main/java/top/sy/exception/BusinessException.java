package top.sy.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.sy.enums.ErrorCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{
    private int code;
    private String msg;

    public BusinessException(String msg) {
        this.msg=msg;
        this.code= ErrorCode.SERVER_ERROR.getCode();
    }
    public BusinessException(ErrorCode errorCode) {
        this.code=errorCode.getCode();
        this.msg=errorCode.getMsg();
    }

    public BusinessException(String msg, Throwable e) {
        this.code=ErrorCode.SERVER_ERROR.getCode();
        this.msg=msg;
    }
}
