package com.example.crudcategoriaprod.service.interfaces;

import com.example.crudcategoriaprod.dto.CategoriaDTO;
import com.example.crudcategoriaprod.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ICategoriasService {

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    Categoria createCategoria(CategoriaDTO categoriaDTO);


}
