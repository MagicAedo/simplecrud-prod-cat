package com.example.crudcategoriaprod.repository;

import com.example.crudcategoriaprod.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Long> {
    //Query para buscar productos por id categoria
    @Query(value = "SELECT p FROM Producto p "+
            "WHERE p.idCategoria = :id")
    List<Producto> findByCategory(@Param("id") Long id);

}
