package com.hot.hotshow.service;

import com.hot.hotshow.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectCommentList();
}
