package com.hot.hotshow.controller;

import com.hot.hotshow.domain.Publish;
import com.hot.hotshow.service.PublishSevice;
import com.hot.hotshow.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @package:
 * @className:
 * @description:
 */
@Controller
@RequestMapping("/publish/")
public class PublishController {
    @Autowired
    private PublishSevice publishSevice;
    @GetMapping("list")
    @ResponseBody
    public AjaxResult selectList(){
        List<Publish> publishes = publishSevice.selectPublishList();
        return AjaxResult.success().put("publishes",publishes);
    }
}
