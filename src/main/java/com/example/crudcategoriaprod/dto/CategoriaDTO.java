package com.example.crudcategoriaprod.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotBlank
    private String nombreCategoria;

    @Length(max = 100)
    private String descripcionCategoria;


    private Date fechaDesde;

    private Date fechaHasta;
}
