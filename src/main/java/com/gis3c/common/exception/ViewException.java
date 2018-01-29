package com.gis3c.common.exception;

/**
 * Created by hukekuan on 2018/1/29.
 */
public class ViewException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ViewException(String message, Throwable cause,
                         boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    public ViewException(String message,Throwable cause){
        super(message,cause);
    }

    public ViewException(String message){
        super(message);
    }

    public ViewException(Throwable cause){
        super(cause);
    }
}
