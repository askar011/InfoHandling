package com.askar.infohandler.util;

public class GeneratorId {

    private static long parserId = 0 ;

    public static long generateParserId(){
        return parserId++;
    }

    public static long getParserId() {
        return parserId;
    }
}
