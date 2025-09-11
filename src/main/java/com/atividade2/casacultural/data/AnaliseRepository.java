
package com.atividade2.casacultural.data;


import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

@Repository 
public interface AnaliseRepository extends JpaRepository<AnaliseEntity, Integer> { 

    AnaliseEntity findByFilme(String filme); 

    List<AnaliseEntity> findByFilmeStartingWith(String filme); 

    List<AnaliseEntity> findByFilmeEndingWith(String filme); 

    List<AnaliseEntity> findByFilmeContaining(String filme); 

    List<AnaliseEntity> findByOrderByFilmeAsc(); 

    List<AnaliseEntity> findByOrderByFilmeDesc(); 
    
    @Query(value = "SELECT * FROM Analise a WHERE a.nota = (SELECT MAX(nota) FROM Analise)", nativeQuery = true)
    List<AnaliseEntity> findAllMaiorNota();

} 