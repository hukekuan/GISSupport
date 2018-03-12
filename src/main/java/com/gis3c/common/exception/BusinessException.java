package com.gis3c.common.exception;

/**
 * Created by hukekuan on 2018/1/29.
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Integer exceptionCode;

    public BusinessException(){
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Integer exceptionCode){
        super();
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(String message,Integer exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(Throwable cause,Integer exceptionCode) {
        super(cause);
        this.exceptionCode = exceptionCode;
    }

    public BusinessException(String message, Throwable cause,Integer exceptionCode) {
        super(message, cause);
        this.exceptionCode = exceptionCode;
    }
}
