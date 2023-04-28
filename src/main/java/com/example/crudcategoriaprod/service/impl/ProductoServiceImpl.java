package com.example.crudcategoriaprod.service.impl;


import com.example.crudcategoriaprod.dto.ProductoDTO;
import com.example.crudcategoriaprod.mappers.ProductosMapper;
import com.example.crudcategoriaprod.model.Producto;
import com.example.crudcategoriaprod.repository.IProductosRepository;
import com.example.crudcategoriaprod.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    private final IProductosRepository pr;

    public ProductoServiceImpl(IProductosRepository pr) {
        this.pr = pr;
    }

    @Override
    public List<Producto> findAll() {
        return pr.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return Optional.of(pr.findById(id)).get();
    }

    @Override
    public List<Producto> findByCategory(Long idCategoria) {
        return pr.findByCategory(idCategoria);
    }

    @Override
    public Producto createProducto(ProductoDTO productoDTO) {
        Producto productoToCreate = ProductosMapper.INSTANCE.toProducto(productoDTO);
        productoToCreate.setFechaDesde(new Date());
        return pr.save(productoToCreate);
    }

    @Override
    public Producto updateProducto(ProductoDTO productoDTO) {
        Producto productoToUpdate = ProductosMapper.INSTANCE.toProducto(productoDTO);

        Optional<Producto> productoBD = pr.findById(productoToUpdate.getId());

        if(productoBD.isPresent()){
            if(productoToUpdate.getIdCategoria() != null) {
                productoBD.get().setIdCategoria(productoToUpdate.getIdCategoria());
            }
            productoBD.get().setNombreProducto(productoToUpdate.getNombreProducto());
            productoBD.get().setDescripcionProducto(productoToUpdate.getDescripcionProducto());
            productoBD.get().setStockProducto(productoToUpdate.getStockProducto());
            return pr.save(productoBD.get());
        }else {
            return null;
        }

    }

    @Override
    public void deleteProducto(Long id) {
        pr.deleteById(id);
    }
}
