package com.mycompany.apirestfulservice.controllers;


import com.mycompany.apirestfulservice.exceptions.RecordNotFoundException;
import com.mycompany.apirestfulservice.modelo.Autor;
import com.mycompany.apirestfulservice.services.AutorService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@RequestMapping("/author")
public class AutorServiceController {
    
    @Autowired
    AutorService service;

    @GetMapping
    public ResponseEntity<List<Autor>> getAllAuthor() {
        List<Autor> list = service.getAllAutor();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAuthorById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Autor entity = service.getAutorById(id);

        return new ResponseEntity<Autor>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Autor> createAuthor(@Valid @RequestBody Autor myAutor) {
        Autor created = service.createAutor(myAutor);
        return new ResponseEntity<Autor>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Autor> UpdateAuthor(@Valid @RequestBody Autor myAutor)
            throws RecordNotFoundException {
        Autor updated = service.createAutor(myAutor);
        return new ResponseEntity<Autor>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteAuthorById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteAutorById(id);
        return HttpStatus.ACCEPTED;
    }
}
