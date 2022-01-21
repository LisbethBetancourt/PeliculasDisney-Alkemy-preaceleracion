package com.alkemy.peliculas.peliculas.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name="personaje")
public class PersonajeEntity<insertable> {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
//------------------------------------------atributos--------------------------//
  private Long id;
  private Long edad;
  private String nombre;
  private String historia;
  private String imagen;
  private Double peso;
  // Relaciones ----------------------------------------------------------------//


  @ManyToMany (mappedBy ="personajes", cascade = CascadeType.ALL)



  List <PeliculaEntity> peliculas =new ArrayList<>();


//---------------------------getter y setter

  public Long getEdad() {   return edad;   }

  public void setEdad(Long edad) {    this.edad = edad;  }

  public String getHistoria() {
    return historia;
  }

  public void setHistoria(String historia) {
    this.historia = historia;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public Double getPeso() {
    return peso;
  }

  public void setPeso(Double peso) {   this.peso = peso; }
}

