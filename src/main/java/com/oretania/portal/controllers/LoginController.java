package com.oretania.portal.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    
    @GetMapping(value = { "/welcome" })
    public String welcome() {

        return "welcome";
    }
    
    @PreAuthorize(value = "MAT")
    @GetMapping(value = { "/asignaturas/matematicas" })
    public String matematicas() {

        return "matematicas";
    }

    @PreAuthorize(value = "LEN")
    @GetMapping(value = { "/asignaturas/lengua" })
    public String lengua() {

        return "lengua";
    }

    @PreAuthorize(value = "ING")
    @GetMapping(value = { "/asignaturas/ingles" })
    public String ingles() {

        return "ingles";
    }

    @PreAuthorize(value = "REL")
    @GetMapping(value = { "/asignaturas/religion" })
    public String religion() {

        return "religion";
    }

    @PreAuthorize(value = "FIS")
    @GetMapping(value = { "/asignaturas/fisica" })
    public String fisica() {

        return "fisica";
    }

    @PreAuthorize(value = "QUI")
    @GetMapping(value = { "/asignaturas/quimica" })
    public String quimica() {

        return "quimica";
    }
}