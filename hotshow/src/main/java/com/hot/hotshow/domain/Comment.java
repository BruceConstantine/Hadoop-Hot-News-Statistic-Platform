package com.hot.hotshow.domain;

public class Comment {
    private String type;

    private Integer commentSum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCommentSum() {
        return commentSum;
    }

    public void setCommentSum(Integer commentSum) {
        this.commentSum = commentSum;
    }
}