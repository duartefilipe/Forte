package br.forte.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class RedirectController {

    @RequestMapping("APIs")
    public String redirectApis() {
        return "API/API";
    }

    @RequestMapping("Trigger")
    public String redirecionaTrigger() {
        System.out.println("Foi pras triggers");
        return "API/Trigger";
    }

}
