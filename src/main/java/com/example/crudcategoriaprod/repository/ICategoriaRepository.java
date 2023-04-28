package com.example.crudcategoriaprod.repository;

import com.example.crudcategoriaprod.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {


}
