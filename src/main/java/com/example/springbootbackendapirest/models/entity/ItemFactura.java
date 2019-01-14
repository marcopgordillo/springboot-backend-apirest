package com.example.springbootbackendapirest.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "facturas_items")
public class ItemFactura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer catidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCatidad() {
        return catidad;
    }

    public void setCatidad(Integer catidad) {
        this.catidad = catidad;
    }

    public Double calcularImporte() {
        return catidad.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemFactura that = (ItemFactura) o;
        return getId().equals(that.getId()) &&
                getCatidad().equals(that.getCatidad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCatidad());
    }
}
