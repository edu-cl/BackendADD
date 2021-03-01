package com.mycompany.apirestfulservice.repositories;


import com.mycompany.apirestfulservice.modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long>{
    
}
