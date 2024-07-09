package com.lighttoinfinity.indiahotel.web.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyPresentException extends RuntimeException{

    public AlreadyPresentException(){
        super();
    }

    public AlreadyPresentException(String msg){
        super(msg);
    }

    public AlreadyPresentException(String msg, Throwable cause){
        super(msg, cause);
    }

    public AlreadyPresentException(Throwable cause){
        super(cause);
    }



}
