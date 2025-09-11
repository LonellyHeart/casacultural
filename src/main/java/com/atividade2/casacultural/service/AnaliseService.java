/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.service;

import com.atividade2.casacultural.data.AnaliseEntity;
import com.atividade2.casacultural.data.AnaliseRepository;
import com.atividade2.casacultural.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    @Autowired
    AnaliseRepository analiseRepository;

    public AnaliseEntity criarAnalise(AnaliseEntity ana) {
        ana.setId(null);
        analiseRepository.save(ana);
        return ana;
    }

    public AnaliseEntity atualizarAnalise(Integer anaId, AnaliseEntity analiseRequest) {
        AnaliseEntity ana = getAnaliseId(anaId);
        ana.setFilme(analiseRequest.getFilme());
        ana.setAnalise(analiseRequest.getAnalise());
        ana.setNota(analiseRequest.getNota());
        analiseRepository.save(ana);
        return ana;
    }

    public AnaliseEntity getAnaliseId(Integer anaId) { 
        return analiseRepository.findById(anaId).orElseThrow(() -> new ResourceNotFoundException("Analise não encontrada" + anaId));                
    } 

    public List<AnaliseEntity> listarTodasAnalises() {
        return analiseRepository.findAll();
    }

    public void deletarAnalise(Integer anaId) {
        AnaliseEntity ana = getAnaliseId(anaId);
        analiseRepository.deleteById(ana.getId());
    }
    
    public List<AnaliseEntity> getAnalisePorNomeFilme(String filme) {

        return analiseRepository.findByFilmeContaining(filme);
    }
    
     public List<AnaliseEntity> getMaioresNotas() { 
        return analiseRepository.findAllMaiorNota();     
    } 
        
}
