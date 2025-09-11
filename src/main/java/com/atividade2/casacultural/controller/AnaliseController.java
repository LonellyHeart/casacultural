/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.controller;


import com.atividade2.casacultural.data.AnaliseEntity;
import com.atividade2.casacultural.service.AnaliseService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnaliseController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping("/lista-analise")
    public ResponseEntity<List> getAllAnalises() {
        List<AnaliseEntity> analises = analiseService.listarTodasAnalises();
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

    @GetMapping("/pesquisar-analise/{id}")
    public ResponseEntity<AnaliseEntity> getAnaliseById(@PathVariable Integer id) {
        AnaliseEntity analise = analiseService.getAnaliseId(id);
        return new ResponseEntity<>(analise, HttpStatus.OK);
    }

    @PostMapping("/adicionar-analise")
    public ResponseEntity<AnaliseEntity> addAnalise(@Valid @RequestBody AnaliseEntity ana) {
        var novaAnalise = analiseService.criarAnalise(ana);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-analise/{id}")
    public ResponseEntity<AnaliseEntity> atualizarAnalise(@PathVariable Integer id, @RequestBody AnaliseEntity ana) {
        var analiseAtualizada = analiseService.atualizarAnalise(id, ana);
        return new ResponseEntity<>(analiseAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/deletar-analise/{id}")
    public ResponseEntity deletarAnalise(@PathVariable Integer id) {
        analiseService.deletarAnalise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pesquisar-nome-analise/{nome}")
    public ResponseEntity<List> getPesquisarPorNomeFilmeAnalises(@PathVariable String nomeFilme) {

        List<AnaliseEntity> analises = analiseService.getAnalisePorNomeFilme(nomeFilme);

        return new ResponseEntity<>(analises, HttpStatus.OK);

    }

    @GetMapping("/maiores-notas")
    public ResponseEntity<List<AnaliseEntity>> getMaioresNotas() {
        List<AnaliseEntity> analises = analiseService.getMaioresNotas();
        return new ResponseEntity<>(analises, HttpStatus.OK);

    }

}
