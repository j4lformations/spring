package com.j4ltechnologies.formation.spring.mvc.jsp.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe Bienvenue, créée le 15/07/2022 à 09:01
 *
 * @author Joachim Zadi
 * @version 1.0 du 15/07/2022
 */
@Controller
@RequestMapping("/")
public class Bienvenue {

    @GetMapping()
    public String disBonjour(){
        return "bonjour";
    }
}
