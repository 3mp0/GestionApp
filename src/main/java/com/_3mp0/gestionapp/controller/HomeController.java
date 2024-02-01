package com._3mp0.gestionapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    //Indica ruta y tipo de solicitud
    public String mostrarHome(){
        return "home";
        //Metodo que
    }
}
