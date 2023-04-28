package com.example.crudcategoriaprod.service.impl;


import com.example.crudcategoriaprod.dto.CategoriaDTO;
import com.example.crudcategoriaprod.mappers.CategoriasMapper;
import com.example.crudcategoriaprod.model.Categoria;
import com.example.crudcategoriaprod.repository.ICategoriaRepository;
import com.example.crudcategoriaprod.service.interfaces.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriasService{

    @Autowired
    private ICategoriaRepository cr;


    @Override
    public List<Categoria>  findAll(){return cr.findAll();}

    @Override
    public Optional<Categoria> findById(Long id) {
        return Optional.of(cr.findById(id)).get();
    }

    @Override
    public Categoria createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoriaToCreate = CategoriasMapper.INSTANCE.toCategoria(categoriaDTO);
        if(categoriaToCreate.getDescripcionCategoria().equals("") && categoriaToCreate.getDescripcionCategoria() != null ) {
            categoriaToCreate.setDescripcionCategoria(null);
        }
        categoriaToCreate.setFechaDesde(new Date());
        return cr.save(categoriaToCreate);
    }

}
