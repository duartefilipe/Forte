package br.forte.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class RedirectController {

    @RequestMapping("APIs")
    public String redirectApis() {
        return "API/API";
    }

}
