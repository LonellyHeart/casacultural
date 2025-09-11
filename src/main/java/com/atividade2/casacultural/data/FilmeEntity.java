package com.atividade2.casacultural.data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Filme")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Nome do filme obrigatório")
    private String titulo;
    
    private String sinopse;
    
    private String genero;
    
    private String lancamento; // esta sendo considerado como String, pois vai ser colocado como um VARCHAR(4) no SQL

}