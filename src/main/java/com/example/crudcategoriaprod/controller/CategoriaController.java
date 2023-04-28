package com.example.crudcategoriaprod.controller;


import com.example.crudcategoriaprod.dto.CategoriaDTO;
import com.example.crudcategoriaprod.mappers.CategoriasMapper;
import com.example.crudcategoriaprod.model.Categoria;
import com.example.crudcategoriaprod.service.interfaces.ICategoriasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriasService cs;


    //GETTERS

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> categorias = cs.findAll();
        if(categorias.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorias.stream().map(CategoriasMapper.INSTANCE
                ::toCategoriaDTO).collect(Collectors.toList()),HttpStatus.OK);
    }

    @GetMapping("/idEnabled/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable(value = "id", required = true) Long aId){
        Optional<Categoria> categoria = cs.findById(aId);
        if(categoria.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(CategoriasMapper.INSTANCE.toCategoriaDTO(categoria.get())
                ,HttpStatus.OK );
    }

    //POST
    @PostMapping("/create")
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoriatoDto  = CategoriasMapper.INSTANCE.
                toCategoriaDTO(cs.createCategoria(categoriaDTO));
        return new ResponseEntity<>(categoriatoDto,HttpStatus.CREATED);
    }




}
