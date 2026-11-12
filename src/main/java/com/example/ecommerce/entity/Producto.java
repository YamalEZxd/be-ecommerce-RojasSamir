package com.example.ecommerce.entity;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Producto.buscarPorCategoria",
        query = "SELECT p FROM Producto p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Producto.stockBajo",
        query = "SELECT p FROM Producto p WHERE p.stock < :limite")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String categoria;

    @Column(name = "precio_compra")
    private BigDecimal precioCompra;

    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

    private Integer stock;

    private String marca;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
}