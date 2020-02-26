package com.hot.hotshow.controller;

import com.hot.hotshow.domain.Source;
import com.hot.hotshow.service.SourceService;
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
@RequestMapping("/source/")
public class SourceController {
    @Autowired
    private SourceService sourceService;
    @GetMapping("list")
    @ResponseBody
    public AjaxResult top10(){
        List<Source> sources = sourceService.selectSourceTop10();
        return AjaxResult.success().put("sources",sources);
    }
}
