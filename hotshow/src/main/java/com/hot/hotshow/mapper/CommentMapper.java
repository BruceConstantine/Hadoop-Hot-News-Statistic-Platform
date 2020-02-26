package com.hot.hotshow.mapper;

import com.hot.hotshow.domain.Comment;

import java.util.List;

public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment>  selectCommentList();
}