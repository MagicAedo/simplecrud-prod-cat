package com.example.crudcategoriaprod.mappers;


import com.example.crudcategoriaprod.dto.CategoriaDTO;
import com.example.crudcategoriaprod.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriasMapper {

    CategoriasMapper INSTANCE = Mappers.getMapper(CategoriasMapper.class);

    //VA PARA ENTIDAD DESDE DTO
    Categoria toCategoria(CategoriaDTO categoriaDTO);
    //VA PARA DTO DESDE CATEGORIA
    CategoriaDTO toCategoriaDTO(Categoria categoria);
}
