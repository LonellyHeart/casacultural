/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


// BLOCO REFERENTE AO FRONTEND, NÃO SENDO UTILIZADO NO MOMENTO.

/*
package com.atividade2.casacultural.controller;

import com.atividade2.casacultural.data.AnaliseEntity;
import com.atividade2.casacultural.service.AnaliseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnaController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listarAnalises", analiseService.listarTodasAnalises());
        return "index";
    }

    @GetMapping("/deletarAnalise/{id}")
    public String deletarFuncionario(@PathVariable(value = "id") Integer id) {
        analiseService.deletarAnalise(id);
        return "redirect:/";
    }

    @GetMapping("/criarAnaliseForm")
    public String criarAnaliseForm(Model model) {
        AnaliseEntity ana = new AnaliseEntity();
        model.addAttribute("analise", ana);
        return "inserir";
    }

    @PostMapping("/salvarAnalise")
    public String salvarAnalise(@Valid @ModelAttribute("analise") AnaliseEntity ana, BindingResult result) {
        if (result.hasErrors()) {
            return "inserir";
        }
        if (ana.getId() == null) {
            analiseService.criarAnalise(ana);
        } else {
            analiseService.atualizarAnalise(ana.getId(), ana);
        }
        return "redirect:/";
    }

    @GetMapping("/atualizarAnaliseForm/{id}")
    public String atualizarAnaliseForm(@PathVariable(value = "id") Integer id, Model model) {
        AnaliseEntity ana = analiseService.getAnaliseId(id);
        model.addAttribute("funcionario", ana);
        return "atualizar";
    }
}

*/ 
