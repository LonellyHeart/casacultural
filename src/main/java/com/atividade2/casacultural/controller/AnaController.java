/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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

    @GetMapping("/lista-analise")
    public String viewListaAnalise(Model model) {
        model.addAttribute("listarAnalises", analiseService.listarTodasAnalises());
        return "lista-analise";
    }

    @GetMapping("/deletarAnalise/{id}")
    public String deletarAnalise(@PathVariable(value = "id") Integer id) {
        analiseService.deletarAnalise(id);
        return "redirect:/lista-analise";
    }

    @GetMapping("/criarAnaliseForm")
    public String criarAnaliseForm(Model model) {
        AnaliseEntity ana = new AnaliseEntity();
        model.addAttribute("analise", ana);
        return "nova-analise";
    }

    @PostMapping("/salvarAnalise")
    public String salvarAnalise(@Valid @ModelAttribute("analise") AnaliseEntity ana, BindingResult result) {
        if (result.hasErrors()) {
            return "nova-analise";
        }
        if (ana.getId() == null) {
            analiseService.criarAnalise(ana);
        } else {
            analiseService.atualizarAnalise(ana.getId(), ana);
        }
        return "redirect:/lista-analise";
    }

    @GetMapping("/atualizarAnaliseForm/{id}")
    public String atualizarAnaliseForm(@PathVariable(value = "id") Integer id, Model model) {
        AnaliseEntity ana = analiseService.getAnaliseId(id);
        model.addAttribute("analise", ana);
        return "atualizar-analise";
    }
}
