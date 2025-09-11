/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.service;
import com.atividade2.casacultural.data.FilmeEntity;
import com.atividade2.casacultural.data.FilmeRepository;
import com.atividade2.casacultural.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public FilmeEntity criarFilme(FilmeEntity fil) {
        fil.setId(null);
        filmeRepository.save(fil);
        return fil;
    }

    public FilmeEntity atualizarFilme(Integer filId, FilmeEntity filmeRequest) {
        FilmeEntity fil = getFilmeId(filId);
        fil.setTitulo(filmeRequest.getTitulo());
        fil.setSinopse(filmeRequest.getSinopse());
        fil.setGenero(filmeRequest.getGenero());
        fil.setAnoLancamento(filmeRequest.getAnoLancamento());
        return fil;
    }

    public FilmeEntity getFilmeId(Integer filId) { 
        return filmeRepository.findById(filId).orElseThrow(() -> new ResourceNotFoundException("Analise não encontrada" + filId));                
    } 

    public List<FilmeEntity> listarTodosFilmes() {
        return filmeRepository.findAll();
    }

    public void deletarFilme(Integer filId) {
        FilmeEntity fil = getFilmeId(filId);
        filmeRepository.deleteById(fil.getId());
    }
    
    public List<FilmeEntity> getFilmePorTitulo(String nomeFilme) {
        return filmeRepository.findByTituloContaining(nomeFilme);
    }
}
    