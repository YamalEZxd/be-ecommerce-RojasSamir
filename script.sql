CREATE DATABASE IF NOT EXISTS db_ecommerce_RojasSamir;
USE db_ecommerce_RojasSamir;

CREATE TABLE IF NOT EXISTS productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(150) NOT NULL,
  categoria VARCHAR(100),
  precio_compra DECIMAL(10,2) NOT NULL,
  precio_venta DECIMAL(10,2) NOT NULL,
  stock INT NOT NULL DEFAULT 0,
  marca VARCHAR(100),
  codigo_barras VARCHAR(50) UNIQUE,
  fecha_ingreso DATE
);

CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL,
  rol VARCHAR(30) NOT NULL DEFAULT 'ROLE_USER'
);
