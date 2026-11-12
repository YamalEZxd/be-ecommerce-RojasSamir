package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    // JPQL con parámetro nombrado (seguro contra inyección)
    @Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Producto> buscarPorNombre(@Param("nombre") String nombre);

    // Usan las NamedQueries de la entidad
    List<Producto> buscarPorCategoria(@Param("categoria") String categoria);

    List<Producto> stockBajo(@Param("limite") Integer limite);
}