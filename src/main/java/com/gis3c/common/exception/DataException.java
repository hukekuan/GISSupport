package com.gis3c.common.exception;

/**
 * Created by hukekuan on 2018/1/29.
 */
public class DataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    public DataException(String message,Throwable cause){
        super(message,cause);
    }

    public DataException(String message){
        super(message);
    }

    public DataException(Throwable cause){
        super(cause);
    }
}
