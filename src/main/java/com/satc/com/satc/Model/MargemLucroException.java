package com.satc.com.satc.Model;

public class MargemLucroException extends Exception{

    public MargemLucroException(){
        super("A margem de lucro deve ser superior ou igual a 20%");
    }

}
