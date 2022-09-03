package com.day14.demorabbitmq;

public class Stopwatch {

    private final long start;
    public Stopwatch(){
        start = System.currentTimeMillis();
    }

    public double elapsed(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}

