package com.mycompany.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @Column(name = "USUARIO_ID")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @JsonIgnoreProperties(value = {"groups"}, allowSetters = true)
    @JoinTable(name = "Leen", joinColumns = @JoinColumn(name = "USUARIO_ID"), inverseJoinColumns = @JoinColumn(name = "LIBRO_ID"))
    @ManyToMany(cascade = {CascadeType.MERGE})
    private List<Libros> libros = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int id, String nombre) {
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
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", libros=" + libros + '}';
    }

}
