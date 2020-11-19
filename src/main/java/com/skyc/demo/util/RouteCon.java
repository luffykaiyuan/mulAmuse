package com.skyc.demo.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteCon {

    @RequestMapping("/uploadTest")
    public String entryTest(){
        return "test/uploadTest";
    }

}
