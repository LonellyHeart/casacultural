/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author MATRIZ
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
}
    
}
    
/* Classe criada especificamente para o Index.html*/