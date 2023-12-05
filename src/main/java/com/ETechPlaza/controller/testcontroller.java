package com.ETechPlaza.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcontroller {

    @GetMapping("/index")
    public String sayhello(){
        return "index";
    }
}
