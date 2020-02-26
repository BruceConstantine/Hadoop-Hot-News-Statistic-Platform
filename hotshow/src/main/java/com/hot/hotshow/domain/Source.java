package com.hot.hotshow.domain;

public class Source {
    private String source;

    private Integer sourceCnt;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getSourceCnt() {
        return sourceCnt;
    }

    public void setSourceCnt(Integer sourceCnt) {
        this.sourceCnt = sourceCnt;
    }
}