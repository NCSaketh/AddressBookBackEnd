package com.bl.addressbookapp.exceptions;

public class DetailsNotProvidedExceptions extends IllegalArgumentException{
    private String msg;

    public DetailsNotProvidedExceptions(String msg){
        super(msg);
        this.msg = msg;

    }
}