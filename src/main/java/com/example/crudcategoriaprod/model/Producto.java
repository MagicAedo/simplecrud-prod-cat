package com.example.crudcategoriaprod.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "NOMBRE")
    private String nombreProducto;

    @Column(name = "DESCRIPCION")
    private String descripcionProducto;

    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @Column(name = "STOCK_PRODUCTO")
    private Integer stockProducto;

    @Column(name = "IMG_REFERENCIA")
    private String imgReferencia;

    @Column(name = "FECHA_DESDE")
    private Date fechaDesde;

    @Column(name = "FECHA_HASTA")
    private Date fechaHasta;

    //DATOS QUE SE CRUZAN:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA",insertable = false, updatable = false)
    private Categoria categoria;


}
