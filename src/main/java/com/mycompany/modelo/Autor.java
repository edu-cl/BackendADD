package com.mycompany.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Autores")
public class Autor implements Serializable{
    
    @Id
    @Column(name="AUTOR_ID")
    private int id;
    
    @Column(name="Nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "Autores ")
    private List<Libros> libros=new ArrayList<>();
    
    public Autor(){}

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", libros=" + libros + '}';
    }

    
    
    
    
}
