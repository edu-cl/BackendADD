package com.mycompany.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;


@Entity
@Table(name="Libros")
public class Libros {

    @Id
    @Column(name="AUTOR_id")
    private int id;
    
    @Column(name="Titulo")
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;
    
    @ManyToMany(mappedBy = "Libros")
    private List<Usuario> usuarios = new ArrayList<>();

    public Libros() {
    }

    public Libros(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Libros{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", usuarios=" + usuarios + '}';
    }

}
