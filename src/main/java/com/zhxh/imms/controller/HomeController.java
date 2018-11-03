package com.zhxh.imms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class HomeController {
    @Value("${application.hello:Hello JSP}")
    private String hello="Hello Jsp";

    @RequestMapping(value={"/"})
    public String index(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message",this.hello);

        return "index";
    }
}
