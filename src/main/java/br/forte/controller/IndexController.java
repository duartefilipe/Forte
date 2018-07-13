package br.forte.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("Login")
    public String Login(HttpServletRequest rq) throws ClassNotFoundException{
//        System.out.println("Foi pro Login");
        return "Index/login";
    }

    @RequestMapping("Index")
    public String Index(HttpServletRequest rq) throws ClassNotFoundException{
//        System.out.println("Foi pra index");
        return "Index/index";
    }

    @RequestMapping("ZabiRepo")
    public String ZabiRepo(HttpServletRequest rq) throws ClassNotFoundException{
//        System.out.println("Foi para os graficos");
        return "Index/ZabiRepo";
    }

}