package com.mycompany.apirestfulservice.controllers;


import com.mycompany.apirestfulservice.exceptions.RecordNotFoundException;
import com.mycompany.apirestfulservice.modelo.Libros;
import com.mycompany.apirestfulservice.services.LibrosService;
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
@RequestMapping("/book")
public class LibroServiceController {

    @Autowired
    LibrosService service;

    @GetMapping
    public ResponseEntity<List<Libros>> getAllBook() {
        List<Libros> list = service.getAllBook();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> getBookById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Libros entity = service.getBookById(id);

        return new ResponseEntity<Libros>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Libros> createBook(@Valid @RequestBody Libros myBook) {
        Libros created = service.createBook(myBook);
        return new ResponseEntity<Libros>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Libros> UpdateBook(@Valid @RequestBody Libros myItem)
            throws RecordNotFoundException {
        Libros updated = service.createBook(myItem);
        return new ResponseEntity<Libros>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteBookById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteBookById(id);
        return HttpStatus.ACCEPTED;
    }
}
