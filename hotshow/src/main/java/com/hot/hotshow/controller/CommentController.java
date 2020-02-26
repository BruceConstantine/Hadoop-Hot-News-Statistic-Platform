package com.hot.hotshow.controller;

import com.hot.hotshow.domain.Comment;
import com.hot.hotshow.service.CommentService;
import com.hot.hotshow.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Controller
@RequestMapping("/comment/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("list")
    @ResponseBody
    public AjaxResult list(){
        List<Comment> comments = commentService.selectCommentList();
        return  AjaxResult.success().put("comments",comments);
    }
}
