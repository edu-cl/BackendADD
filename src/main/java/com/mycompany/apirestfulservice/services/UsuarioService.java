package com.mycompany.apirestfulservice.services;


import com.mycompany.apirestfulservice.exceptions.RecordNotFoundException;
import com.mycompany.apirestfulservice.modelo.Usuario;
import com.mycompany.apirestfulservice.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    UserRepository repository;

    public List<Usuario> getAllUser() {
        List<Usuario> userList = repository.findAll();

        if (userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<>();
        }
    }

    public Usuario getUserById(Long id) throws RecordNotFoundException {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new RecordNotFoundException("No user record exist for given id", id);
        }
    }

    public Usuario createUser(Usuario entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Usuario updateUser(Usuario entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Usuario> usuario = repository.findById(entity.getId());

            if (usuario.isPresent()) {
                Usuario newEntity = usuario.get();
                newEntity.setNombre(entity.getNombre());
                newEntity.setLibros(entity.getLibros());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("User not found", entity.getId());
            }
        } else {
            throw new RecordNotFoundException("No id of User given", 0l);
        }
    }
    
        public void deleteUserById(Long id) throws RecordNotFoundException{
        Optional<Usuario> usuario = repository.findById(id);
        if(usuario.isPresent()){
            repository.deleteById(id);
        }else{
            throw new RecordNotFoundException("No User record exist for given id", id);
        }
    }
}
