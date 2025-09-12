/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.atividade2.casacultural.controller;

import com.atividade2.casacultural.data.FilmeEntity;
import com.atividade2.casacultural.service.FilmeService;
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
public class FilController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("/lista-filme")
    public String viewListaFilme(Model model) {
        model.addAttribute("listarFilmes", filmeService.listarTodosFilmes());
        return "lista-filme";
    }

    @GetMapping("/deletarFilme/{id}")
    public String deletarFilme(@PathVariable(value = "id") Integer id) {
        filmeService.deletarFilme(id);
        return "redirect:/lista-filme";
    }

    @GetMapping("/criarFilmeForm")
    public String criarFilmeForm(Model model) {
        FilmeEntity fil = new FilmeEntity();
        model.addAttribute("filme", fil);
        return "cadastro-filme";
    }

    @PostMapping("/salvarFilme")
    public String salvarFilme(@Valid @ModelAttribute("filme") FilmeEntity fil, BindingResult result) {
        if (result.hasErrors()) {
            return "cadastro-filme";
        }
        if (fil.getId() == null) {
            filmeService.criarFilme(fil);
        } else {
            filmeService.atualizarFilme(fil.getId(), fil);
        }
        return "redirect:/lista-filme";
    }

    @GetMapping("/atualizarFilmeForm/{id}")
    public String atualizarFilmeForm(@PathVariable(value = "id") Integer id, Model model) {
        FilmeEntity fil = filmeService.getFilmeId(id);
        model.addAttribute("filme", fil);
        return "atualizar-filme";
    }
}
