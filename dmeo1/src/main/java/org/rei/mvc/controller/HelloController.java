package org.rei.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //當路徑為"/"時
    @RequestMapping(value = "/")
    public String index(){
        //返回視圖名稱，然後就會跳到該名稱的頁面
        return "index";
    }

    @RequestMapping(value = "/target")
    public String totarget(){
        return "target";
    }
}
