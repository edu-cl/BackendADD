package com.mycompany.apirestfulservice.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "Libros")
public class Libros {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Titulo")
    private String titulo;

     @JsonIgnoreProperties(value = {"libros"}, allowSetters = true)
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;

    @JsonIgnoreProperties(value = {"libros"}, allowSetters = true)
    @ManyToMany(mappedBy = "libros" , cascade = CascadeType.MERGE)
    private List<Usuario> usuarios = new ArrayList<>();

    public Libros() {
    }

    public Libros(Long id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
