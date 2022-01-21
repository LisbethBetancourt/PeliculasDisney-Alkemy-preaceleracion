package com.alkemy.peliculas.peliculas.Entity;


import javax.persistence.*;



@Entity
@Table (name="genero")
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String imagen;

//-----------------------------getter -setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
