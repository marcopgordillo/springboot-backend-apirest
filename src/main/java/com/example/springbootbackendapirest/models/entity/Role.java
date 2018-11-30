package com.example.springbootbackendapirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// import java.util.List;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 20)
  private String nombre;

  /*@ManyToMany(mappedBy = "roles") // En este sentido de la relación se debe indicar la tabla dueña de la relación en este caso de el campo que maneja la relación es decir el campo roles de la clase Usuario.
  private List<Usuario> usuarios;*/ // Este sentido de la relación no tiene interes por tanto se comenta solo como ejemplo

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Role)) return false;
    Role role = (Role) o;
    return Objects.equals(getId(), role.getId()) &&
            Objects.equals(getNombre(), role.getNombre());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getId(), getNombre());
  }

  @Override
  public String toString() {
    return "Role{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            '}';
  }
}
