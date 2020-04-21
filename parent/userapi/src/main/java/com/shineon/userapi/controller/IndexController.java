package com.shineon.userapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: wsh
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index","index.html","/"})
    public String demo() {
        return "/index";
    }

    @RequestMapping(value = {"/two"})
    public String two() {
        return "/two";
    }
    @RequestMapping(value = {"/three"})
    public String three() {
        return "/three";
    }
    @RequestMapping(value = {"/four"})
    public String four() {
        return "/four";
    }
}
