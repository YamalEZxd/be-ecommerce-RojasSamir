package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoDTO(
    Integer id,
    @NotBlank String nombre,
    String categoria,
    @NotNull BigDecimal precioCompra,
    @NotNull BigDecimal precioVenta,
    @NotNull Integer stock,
    String marca,
    String codigoBarras,
    LocalDate fechaIngreso) {
}
