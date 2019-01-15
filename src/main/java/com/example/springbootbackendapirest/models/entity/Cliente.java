package com.example.springbootbackendapirest.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacío.")
    @Size(min = 4, max = 12, message = "el tamaño tiene que estar entre 4 y 12.")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacío.")
    @Column(nullable = false)
    private String apellido;

    @NotEmpty(message = "no puede estar vacío.")
    @Email(message = "no es una dirección de correo bien formada.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "no puede estar vacío.")
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    private String foto;

    @NotNull(message = "no puede estar vacío")
    @ManyToOne(fetch = FetchType.LAZY) // carga peresoza, solo cuando se le llama carga los datos.
    @JoinColumn(name = "region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Es necesario omitir estas propiedades ya que al estar utilizando el fetch tipo LAZY se genera un proxy en el campo region que podría lanzar un error, por tanto solo quedan las propiedades de la clase Region (id, nombre).
    private Region region;

    @JsonIgnoreProperties({"cliente", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL) // Relación OneToMany Bidireccional
    private List<Factura> facturas;

    public Cliente() {
        this.facturas = new ArrayList<>();
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) &&
                Objects.equals(getNombre(), cliente.getNombre()) &&
                Objects.equals(getApellido(), cliente.getApellido()) &&
                Objects.equals(getEmail(), cliente.getEmail()) &&
                Objects.equals(getCreateAt(), cliente.getCreateAt()) &&
                Objects.equals(getFoto(), cliente.getFoto()) &&
                Objects.equals(getRegion(), cliente.getRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNombre(), getApellido(), getEmail(), getCreateAt(), getFoto(), getRegion());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", createAt=" + createAt + '\'' +
                ", foto=" + foto + '\'' +
                ", region=" + region +
                '}';
    }
}
