package com.example.crudcategoriaprod.service.interfaces;

import com.example.crudcategoriaprod.dto.ProductoDTO;
import com.example.crudcategoriaprod.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IProductoService {
    //GET ALL
    List<Producto> findAll();
    //GET BY ID
    Optional<Producto> findById(Long id);
    //GET BY CAT
    List<Producto> findByCategory(Long idCategoria);

    //CREATE
    Producto createProducto(ProductoDTO productoDTO);

    //UPDATE
    Producto updateProducto(ProductoDTO productoDTO);

    //DELETE
    void deleteProducto(Long id);




}
