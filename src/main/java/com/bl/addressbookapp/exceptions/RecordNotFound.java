package com.bl.addressbookapp.exceptions;

public class RecordNotFound extends IllegalArgumentException{
    private String msg;

    public RecordNotFound(String msg){
        super(msg);
        this.msg = msg;
    }
}
