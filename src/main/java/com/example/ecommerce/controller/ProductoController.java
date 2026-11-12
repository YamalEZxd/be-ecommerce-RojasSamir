package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.ProductoDTO;
import com.example.ecommerce.service.ProductoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public List<ProductoDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ProductoDTO obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @GetMapping("/buscar")
    public List<ProductoDTO> buscar(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/categoria/{categoria}")
    public List<ProductoDTO> porCategoria(@PathVariable String categoria) {
        return service.buscarPorCategoria(categoria);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDTO crear(@Valid @RequestBody ProductoDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public ProductoDTO actualizar(@PathVariable Integer id, @Valid @RequestBody ProductoDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}
