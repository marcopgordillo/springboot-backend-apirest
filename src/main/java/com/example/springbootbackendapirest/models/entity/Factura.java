package com.example.springbootbackendapirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String observacion;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cliente_id") // es el estándar así que no es necesario en este caso
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factura factura = (Factura) o;

        if (!getId().equals(factura.getId())) return false;
        if (!getDescripcion().equals(factura.getDescripcion())) return false;
        if (!getObservacion().equals(factura.getObservacion())) return false;
        return getCreateAt().equals(factura.getCreateAt());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        result = 31 * result + getObservacion().hashCode();
        result = 31 * result + getCreateAt().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", observacion='" + observacion + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}
