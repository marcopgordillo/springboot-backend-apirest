package com.example.springbootbackendapirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 20)
  private String username;

  @Column(length = 60)
  private String password;

  private Boolean enabled;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "role_id"})})
  private List<Role> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Usuario)) return false;
    Usuario usuario = (Usuario) o;
    return Objects.equals(getId(), usuario.getId()) &&
            Objects.equals(getUsername(), usuario.getUsername()) &&
            Objects.equals(getPassword(), usuario.getPassword()) &&
            Objects.equals(getEnabled(), usuario.getEnabled()) &&
            Objects.equals(getRoles(), usuario.getRoles());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getId(), getUsername(), getPassword(), getEnabled(), getRoles());
  }

  @Override
  public String toString() {
    return "Usuario{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", enabled=" + enabled +
            ", roles=" + roles +
            '}';
  }
}
