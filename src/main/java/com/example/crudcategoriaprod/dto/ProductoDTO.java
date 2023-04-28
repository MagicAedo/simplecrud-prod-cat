package com.example.crudcategoriaprod.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProductoDTO {

    private Long id;

    @NotBlank
    private String nombreProducto;

    @Length(max = 200)
    private String descripcionProducto;

    @PositiveOrZero
    private Long idCategoria;

    @NotNull
    private Integer stockProducto;


    private String imgReferencia;


    private String nombreCategoria;

    private Date fechaDesde;

    private Date fechaHasta;
}
