/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.controller;


import com.atividade2.casacultural.data.FilmeEntity;
import com.atividade2.casacultural.service.FilmeService;
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
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("/lista-filme")
    public ResponseEntity<List> getAllAnalises() {
        List<FilmeEntity> filmes = filmeService.listarTodosFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @GetMapping("/pesquisar-filme/{id}")
    public ResponseEntity<FilmeEntity> getAnaliseById(@PathVariable Integer id) {
        FilmeEntity filme = filmeService.getFilmeId(id);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @PostMapping("/adicionar-filme")
    public ResponseEntity<FilmeEntity> addFilme(@Valid @RequestBody FilmeEntity fil) {
        var novoFilme = filmeService.criarFilme(fil);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar-filme/{id}")
    public ResponseEntity<FilmeEntity> atualizarFilme(@PathVariable Integer id, @RequestBody FilmeEntity fil) {
        var filmeAtualizado = filmeService.atualizarFilme(id, fil);
        return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar-filme/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    @GetMapping("/pesquisar-nome-filme/{nome}") 
    public ResponseEntity<List> getPesquisarTitulosFilmes(@PathVariable String titulo) { 
        List<FilmeEntity> filmes = filmeService.getFilmePorTitulo(titulo); 
        return new ResponseEntity<>(filmes, HttpStatus.OK); 

    } 
    
    

      
}
