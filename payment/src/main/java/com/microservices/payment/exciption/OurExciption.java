package com.microservices.payment.exciption;

public class OurExciption extends  RuntimeException{


    public OurExciption(String message) {
        super(message);
    }

}
