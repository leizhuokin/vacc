package cn.edu.zut.vacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    @GetMapping()
    public String index(){
        return "/login";
    }
}
