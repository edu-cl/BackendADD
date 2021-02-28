package com.mycompany.controllers;

import com.mycompany.exceptions.RecordNotFoundException;
import com.mycompany.modelo.Libros;
import com.mycompany.modelo.Usuario;
import com.mycompany.services.UsuarioService;
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
@RequestMapping("/user")
public class UsuarioServiceController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUser() {
        List<Usuario> list = service.getAllUser();

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        Usuario entity = service.getUserById(id);

        return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario myUser) {
        Usuario created = service.createUser(myUser);
        return new ResponseEntity<Usuario>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> UpdateUser(@Valid @RequestBody Usuario myUser)
            throws RecordNotFoundException {
        Usuario updated = service.createUser(myUser);
        return new ResponseEntity<Usuario>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.ACCEPTED;
    }
}
