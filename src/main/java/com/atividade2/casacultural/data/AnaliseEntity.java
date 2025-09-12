/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.atividade2.casacultural.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "Analise")
public class AnaliseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "Nome do filme obrigatório")
    private String filme; // De momento não será usada como objeto FilmeEntity
    
    @Size(min = 10, message = "A analise deve haver pelo menos 10 letras para ser considerada valida")
    @Column(name = "analise")
    private String texto;
    
   @NotNull(message = "A analise deve conter uma nota para ser considerada valida")
    private double nota;

}