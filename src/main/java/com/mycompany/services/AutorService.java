package com.mycompany.services;

import com.mycompany.exceptions.RecordNotFoundException;
import com.mycompany.modelo.Autor;
import com.mycompany.repositories.AutorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorService {

    @Autowired
    AutorRepository repository;

    public List<Autor> getAllAutor() {
        List<Autor> autorList = repository.findAll();

        if (autorList.size() > 0) {
            return autorList;
        } else {
            return new ArrayList<>();
        }
    }

    public Autor getAutorById(Long id) throws RecordNotFoundException {
        Optional<Autor> autor = repository.findById(id);

        if (autor.isPresent()) {
            return autor.get();
        } else {
            throw new RecordNotFoundException("No author record exist for given id", id);
        }
    }

    public Autor createAutor(Autor entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Autor updateAutor(Autor entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Autor> autor = repository.findById(entity.getId());

            if (autor.isPresent()) {
                Autor newEntity = autor.get();
                newEntity.setNombre(entity.getNombre());
                newEntity.setLibros(entity.getLibros());
                
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("author not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of author given", 0l);
        }
    }

    public void deleteAutorById(Long id) throws RecordNotFoundException {
        Optional<Autor> autor = repository.findById(id);
        if (autor.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No Author record exist for given id", id);
        }
    }

}
