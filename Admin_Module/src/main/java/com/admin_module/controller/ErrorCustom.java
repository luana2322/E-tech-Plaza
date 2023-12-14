package com.admin_module.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorCustom  implements ErrorController{

    @RequestMapping("/error")
    public String handleError() {
        return "pages/samples/error-404";
    }

  
    public String getErrorPath() {
        return "/error";
    }
    

}
