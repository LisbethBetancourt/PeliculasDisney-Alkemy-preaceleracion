package com.alkemy.peliculas.peliculas.Entity;
//importaciones de librerias---------------------------------------------------------------------
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

// declaraciones-------------------------------------------------------------------------------
@Entity
@Table(name="pelicula")
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//atributos----------------------------------------------------------------------------------
    private Long id;
    private Long calificacion;
    private String imagen;
    private Long genero_Id;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

//relaciones de base de datos-----------------------------------------------------------------

   @ManyToOne(fetch= FetchType.EAGER,cascade=CascadeType.ALL ) //-> CONSULTAS CON EL EAGER: SE REALIZA UNA INICIALIZACION TEMPRANA PELICULA - GENERO

   @JoinColumn(name = "genero_id", insertable=false, updatable=false)
    private GeneroEntity genero; //

    @ManyToMany (
            cascade={
                    CascadeType.PERSIST,
                    CascadeType. MERGE

            })

    @JoinTable (
            name= "personaje_pelicula",
            joinColumns=@JoinColumn(name="personaje_id"),
            inverseJoinColumns = @JoinColumn(name="pelicula_id"))


    private List<PersonajeEntity> personajes = new ArrayList<>();

//getters y setter --------------------------------------------------------------------------
    public Long getId() { return id;}

    public void setId(Long id) { this.id = id; }

    public String getImagen() { return imagen; }

    public void setImagen(String imagen) { this.imagen = imagen; }

    public Long getCalificacion() { return calificacion;   }

    public void setCalificacion(Long calificacion) { this.calificacion = calificacion; }

    public Long getGenero_Id() { return genero_Id; }

    public void setGenero_Id(Long genero_Id) { this.genero_Id = genero_Id; }

    public LocalDate getFechaCreacion() { return fechaCreacion; }

    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}

