package com._3mp0.gestionapp.controller;

import com._3mp0.gestionapp.model.Empleados;
import com._3mp0.gestionapp.services.EmpleadosServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/empleados") //Indicamos que es la rutabase de los metodos de este controlador
public class EmpleadosController {

    private final EmpleadosServiceImpl empleadosService;

    @GetMapping("/lista")
    public String mostrarListaEmpleados(Model model){
        //LLamamos al service para que nos traiga lista de desde el repository
        //Se guarda en variable
        List<Empleados> listaEmpleados = empleadosService.listarEmpleados();
        //Al model para pasar a la vista le asignamos el valor de la variable
        model.addAttribute("empleados", listaEmpleados);
        return "lista";
    }

    @GetMapping ("/formulario")
    public String mostrarFormulario(Model model){
        model.addAttribute("empleados", new Empleados());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarNuevoEmpleado(@ModelAttribute Empleados nuevoEmpleado){
        empleadosService.guardarEmpleado(nuevoEmpleado);
        return "redirect:/empleados/lista";
    }

}
