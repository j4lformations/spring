package com.j4ltechnologies.formation.spring.sd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Classe Bienvenue, créée le 30/04/2021 à 17:01
 *
 * @author Joachim Zadi
 * @version 1.0 du 30/04/2021
 */
@Controller
public class Bienvenue {

    @GetMapping("/")
    public String Bonjour(){
        return "bonjour";
    }
}
