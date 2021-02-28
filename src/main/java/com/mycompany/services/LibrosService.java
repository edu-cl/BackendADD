package com.mycompany.services;

import com.mycompany.exceptions.RecordNotFoundException;
import com.mycompany.modelo.Libros;
import com.mycompany.repositories.LibrosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class LibrosService {

    @Autowired
    LibrosRepository repository;

    public List<Libros> getAllBook() {
        List<Libros> librosList = repository.findAll();

        if (librosList.size() > 0) {
            return librosList;
        } else {
            return new ArrayList<>();
        }
    }

    public Libros getBookById(Long id) throws RecordNotFoundException {
        Optional<Libros> libros = repository.findById(id);

        if (libros.isPresent()) {
            return libros.get();
        } else {
            throw new RecordNotFoundException("No book record exist for given id", id);
        }
    }
    
   

    public Libros createBook(Libros entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Libros updateBook(Libros entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Libros> libro = repository.findById(entity.getId());

            if (libro.isPresent()) {
                Libros newEntity = libro.get();
                newEntity.setTitulo(entity.getTitulo());
                newEntity.setAutor(entity.getAutor());
                newEntity.setUsuarios(entity.getUsuarios());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Book not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of book given", 0l);
        }
    }
    
        public void deleteBookById(Long id) throws RecordNotFoundException{
        Optional<Libros> libros = repository.findById(id);
        if(libros.isPresent()){
            repository.deleteById(id);
        }else{
            throw new RecordNotFoundException("No book record exist for given id", id);
        }
    }

}
