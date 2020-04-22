package com.shineon.userapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wsh
 */
@Controller
public class HomeController {

    //首页
    @RequestMapping(value = {"/index","index.html","/"})
    public String index() {
        return "/index";
    }
}
