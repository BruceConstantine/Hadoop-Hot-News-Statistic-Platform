package com.hot.hotshow.service.impl;

import com.hot.hotshow.domain.Comment;
import com.hot.hotshow.mapper.CommentMapper;
import com.hot.hotshow.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired  private CommentMapper commentMapper;
    @Override
    public List<Comment> selectCommentList(){ return commentMapper.selectCommentList(); }
}
