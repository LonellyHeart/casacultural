
package com.atividade2.casacultural.data;


import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Integer> { 

    AnaliseEntity findByNomeFilme(String nomeFilme); 

    List<AnaliseEntity> findByNomeFilmeStartingWith(String nomeFilme); 

    List<AnaliseEntity> findByNomeFilmeEndingWith(String nomeFilme); 

    List<AnaliseEntity> findByNomeFilmeContaining(String nomeFilme); 

    List<AnaliseEntity> findByOrderByNomeFilmeAsc(); 

    List<AnaliseEntity> findByOrderByNomeFilmeDesc(); 
    
    @Query(value = "SELECT * FROM Analise a WHERE a.nota = (SELECT MAX(nota) FROM Analise)", nativeQuery = true)
    List<AnaliseEntity> findAllMaiorNota();

} 