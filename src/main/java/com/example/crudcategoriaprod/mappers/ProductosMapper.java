package com.example.crudcategoriaprod.mappers;

import com.example.crudcategoriaprod.dto.ProductoDTO;
import com.example.crudcategoriaprod.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductosMapper {

    ProductosMapper INSTANCE = Mappers.getMapper(ProductosMapper.class);

    //VA PARA ENTIDAD DESDE DTO

    @Mapping(target = "categoria", ignore = true)
    @Mapping(target = "imgReferencia", source="imgReferencia")
    Producto toProducto(ProductoDTO dto);

    //VA PARA DTO DESDE ENTIDAD
    @Mapping(target = "nombreCategoria", source = "categoria.nombreCategoria")
    ProductoDTO toProductoDTO(Producto entidad);

}
