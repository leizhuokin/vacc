package cn.edu.zut.vacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/queryUser")
    public String queryUser(){
        return "queryUser";
    }
    @RequestMapping("/queryVaccine")
    public String queryVaccine(){
        return "queryVaccine";
    }
    @RequestMapping("/queryUservaccine")
    public String queryUservaccine(){
        return "queryUservaccine";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
