package ies6.edu.ar.tpfinalmendozafrancisco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping ("/index")
        public String getIndex() {
        return "index";
    }
    
    
    // @GetMapping ("/nuevo")
    //     public String getNuevo() {
    //     return "nuevo";s
    // }
    
    // @GetMapping("7nuevo")
    // public ModelAndView nuevoMetodo(){
    //     System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    //     ModelAndView model = new ModelAndView("nuevo");
    //     return model;
    // }
}
