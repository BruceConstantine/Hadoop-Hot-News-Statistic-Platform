package com.hot.hotshow.controller;

import com.hot.hotshow.domain.Type0;
import com.hot.hotshow.service.Type0Service;
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
@RequestMapping("/type/")
public class Type0Controller {
    @Autowired
    private Type0Service type0Service;
    @GetMapping("list")
    @ResponseBody
    public AjaxResult selectList(){
        List<Type0> type0s = type0Service.selectType0List();
        return AjaxResult.success().put("type0s",type0s);
    }
    @GetMapping("sum")
    @ResponseBody
    public AjaxResult selectSum(){
        Long totals = type0Service.selectSum();
        return AjaxResult.success().put("total",totals);
    }
}
