package com.example.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductoDTO;
import com.example.ecommerce.entity.Producto;
import com.example.ecommerce.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository repo;

    private ProductoDTO toDTO(Producto p) {
        return new ProductoDTO(p.getId(), p.getNombre(), p.getCategoria(),
            p.getPrecioCompra(), p.getPrecioVenta(), p.getStock(),
            p.getMarca(), p.getCodigoBarras(), p.getFechaIngreso());
    }

    private Producto toEntity(ProductoDTO d, Producto p) {
        p.setNombre(d.nombre());
        p.setCategoria(d.categoria());
        p.setPrecioCompra(d.precioCompra());
        p.setPrecioVenta(d.precioVenta());
        p.setStock(d.stock());
        p.setMarca(d.marca());
        p.setCodigoBarras(d.codigoBarras());
        p.setFechaIngreso(d.fechaIngreso());
        return p;
    }

    public List<ProductoDTO> listar() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    public ProductoDTO obtener(Integer id) {
        return toDTO(repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no existe")));
    }

    public ProductoDTO crear(ProductoDTO d) {
        return toDTO(repo.save(toEntity(d, new Producto())));
    }

    public ProductoDTO actualizar(Integer id, ProductoDTO d) {
        Producto p = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no existe"));
        return toDTO(repo.save(toEntity(d, p)));
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

    public List<ProductoDTO> buscarPorNombre(String nombre) {
        return repo.buscarPorNombre(nombre).stream().map(this::toDTO).toList();
    }

    public List<ProductoDTO> buscarPorCategoria(String categoria) {
        return repo.buscarPorCategoria(categoria).stream().map(this::toDTO).toList();
    }
}
