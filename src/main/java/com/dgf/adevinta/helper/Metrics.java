package com.dgf.adevinta.helper;

public class Metrics {

    private final long start=System.nanoTime();

    public long end() {
        return (System.nanoTime()-start);
    }
}
