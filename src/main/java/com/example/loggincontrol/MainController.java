package com.example.loggincontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Anotacion para decir que sera un controlador
@Controller
public class MainController {

    @GetMapping("")
    public String HomePage(){

        return "index";
    }

    //esta sera la ruta que le asignaremos,esto se mirara en el buscador
    @GetMapping("/admin/login")
    public String AdminLogin() {
        //Retornamos a la vista del Administrador
        return "admin/admin_login";
    }

    @GetMapping("/customer/login")
    public String CustomerLogin() {
        return "/customer/customer_login";
    }

    @GetMapping("/admin/home")
    public String PageAdmin() {
        return "/admin/admin_home";
    }

    @GetMapping("/customer/home")
    public String PageCustomer() {
        return "/customer/customer_home";
    }

}
