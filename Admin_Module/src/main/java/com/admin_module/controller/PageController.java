package com.admin_module.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/button")
    public String  button(){
        return "pages/ui-features/buttons";
    }

    @GetMapping("/dropdown")
    public String  dropdow(){
        return "pages/ui-features/dropdowns";
    }

    @GetMapping("/typography")
    public String  typography(){
        return "pages/ui-features/typography";
    }
//    end 1

    @GetMapping("/basic_table")
    public String  basictable(){
        return "pages/tables/basic-table";
    }
    //    end 2


   

    @GetMapping("/error-404")
    public String  error_404(){
        return "pages/samples/error-404";
    }

    @GetMapping("/error-500")
    public String  error_500(){
        return "pages/samples/error-500";
    }


    //    end 3
    @GetMapping("/mdi")
    public String  icon(){
        return "pages/icons/mdi";
    }
    //    end 4
    @GetMapping("/form")
    public String  form(){
        return "pages/forms/basic_elements";
    }

    //    end 5
    @GetMapping("/documentation")
    public String  document(){
        return "pages/documentation/documentation";
    }

    //    end 6
    @GetMapping("/chartjs")
    public String  chart(){
        return "pages/charts/chartjs";
    }
}
