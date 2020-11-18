package com.skyc.demo.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteCon {

    @RequestMapping("/test")
    public String entryTest(){
        return "fore/test";
    }

}
