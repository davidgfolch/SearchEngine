package com.dgf.adevinta.model;

import static java.lang.String.format;

public class SearchResult {

    private static final String OUTPUT_FORMAT = "%3d%% -> %s";

    private Integer percent;
    private String file;

    public SearchResult(int percent, String file) {
        this.percent = percent;
        this.file = file;
    }

    public Integer getPercent() {
        return percent;
    }

    public String toString() {
        return format(OUTPUT_FORMAT,percent,file);
    }
}
