package com.example.crudcategoriaprod.controller;

import com.example.crudcategoriaprod.dto.ProductoDTO;
import com.example.crudcategoriaprod.mappers.ProductosMapper;
import com.example.crudcategoriaprod.model.Producto;
import com.example.crudcategoriaprod.service.interfaces.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RequestMapping("/api/productos")
public class ProductoController {

    private final IProductoService ps;

    public ProductoController(IProductoService ps) {
        this.ps = ps;
    }

    //GETTERS
    @GetMapping("/all")
    public ResponseEntity<List<ProductoDTO>> findAll(){
        List<Producto> productos = ps.findAll();
        if(productos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productos.stream().map(ProductosMapper.INSTANCE
                ::toProductoDTO).collect(Collectors.toList()),HttpStatus.OK);
    }

    @GetMapping("/idEnabled/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable(value = "id", required = true) Long aId){
        Optional<Producto> producto = ps.findById(aId);
        if(producto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ProductosMapper.INSTANCE.toProductoDTO(producto.get())
                ,HttpStatus.OK );
    }

    @GetMapping("/idCat/{id}")
    public ResponseEntity<List<ProductoDTO>> findByCat(@PathVariable(value = "id", required = true) Long aId){
        List<Producto> productos = ps.findByCategory(aId);
        if(productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productos.stream().map(ProductosMapper.INSTANCE
                ::toProductoDTO).collect(Collectors.toList()),HttpStatus.OK);
    }

    //POST
    @PostMapping("/create")
    public ResponseEntity<ProductoDTO> createProducto(@Valid @RequestBody ProductoDTO productoDTO){
        ProductoDTO productoDto  = ProductosMapper.INSTANCE.
                toProductoDTO(ps.createProducto(productoDTO));
        return new ResponseEntity<>(productoDto,HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping("/update")
    public ResponseEntity<Boolean> updateProducto(@Valid @RequestBody ProductoDTO productoDTO){
        ps.updateProducto(productoDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProducto(
            @PathVariable(value = "id", required = true) Long aId) {
        ps.deleteProducto(aId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }




}
