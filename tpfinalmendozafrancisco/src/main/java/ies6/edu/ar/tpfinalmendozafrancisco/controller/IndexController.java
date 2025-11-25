package ies6.edu.ar.tpfinalmendozafrancisco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping ("/index")
        public String getIndex() {
        return "index";
    }

    //@GetMapping("/viaje")
    //public String viaje() {
    //    return "redirect:/usuarios/nuevo";
    //}

    @GetMapping("/viaje/nuevo")
    public String nuevoViaje() {
        return "redirect:/usuarios/nuevo";
    }
}
