-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2024 a las 23:26:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parcial_1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activo`
--

CREATE TABLE `activo` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `periodos_depreciacion_total` int(11) NOT NULL,
  `valor_compra` decimal(8,2) NOT NULL,
  `tipo_activo_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`codigo`, `nombre`) VALUES
(1, 'Quito'),
(2, 'Guayaquil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `ruc` varchar(13) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `ruc`, `nombre`, `direccion`) VALUES
(1, '1723456784001', 'Peter Parker', 'Av. Amazonas'),
(4, '1548576543002', 'Demi Lovato', 'Av. Colon y America'),
(5, '1745676543001', 'Juan Perez', 'Cotocollao'),
(6, '0583948576001', 'VIviana Perez', 'Rumuñahui');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante_contable`
--

CREATE TABLE `comprobante_contable` (
  `numero` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

CREATE TABLE `cuenta` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_cuenta_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `depreciacion`
--

CREATE TABLE `depreciacion` (
  `numero` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `responsable` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_contable`
--

CREATE TABLE `detalle_contable` (
  `id` int(11) NOT NULL,
  `cuenta_codigo` int(11) NOT NULL,
  `cantidad_debe` decimal(8,2) DEFAULT NULL,
  `cantidad_haber` decimal(8,2) DEFAULT NULL,
  `comprobante_contable_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_depreciaciones`
--

CREATE TABLE `detalle_depreciaciones` (
  `id` int(11) NOT NULL,
  `activo_id` int(11) NOT NULL,
  `nro_periodo_depreciacion` int(11) NOT NULL,
  `valor_depreciacion_periodo` decimal(8,2) NOT NULL,
  `depreciacion_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `id` int(11) NOT NULL,
  `articulo_codigo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `cabecera_factura_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_nomina`
--

CREATE TABLE `detalle_nomina` (
  `id` int(11) NOT NULL,
  `motivo_codigo` int(11) NOT NULL,
  `monto` decimal(8,2) NOT NULL,
  `nomina_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `sueldo` decimal(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`cedula`, `nombre`, `fecha_ingreso`, `sueldo`) VALUES
('1746555678', 'Juan', '2024-06-10 23:40:27', 512.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `nro` varchar(45) NOT NULL,
  `fecha` datetime NOT NULL,
  `ciudad_codigo` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulos`
--

CREATE TABLE `modulos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `modulos`
--

INSERT INTO `modulos` (`id`, `nombre`) VALUES
(1, 'nomina'),
(2, 'activos'),
(3, 'contabilidad'),
(4, 'facturacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modulo_rol`
--

CREATE TABLE `modulo_rol` (
  `modulo_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `modulo_rol`
--

INSERT INTO `modulo_rol` (`modulo_id`, `rol_id`) VALUES
(1, 2),
(2, 2),
(3, 2),
(4, 2),
(1, 3),
(2, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motivo`
--

CREATE TABLE `motivo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina`
--

CREATE TABLE `nomina` (
  `numero` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `empleado_cedula` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(1, 'admin'),
(2, 'grupo a'),
(3, 'grupo b'),
(4, 'grupo c');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_activo`
--

CREATE TABLE `tipo_activo` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_cuenta`
--

CREATE TABLE `tipo_cuenta` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasenia` varchar(50) NOT NULL,
  `rol_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `contrasenia`, `rol_id`) VALUES
(1, 'leydi', '123456', 1),
(2, 'tony', '123456', 2),
(3, 'peter', '123456', 2),
(4, 'camila', '123456', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activo`
--
ALTER TABLE `activo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_activo_tipo_activo1_idx` (`tipo_activo_codigo`);

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comprobante_contable`
--
ALTER TABLE `comprobante_contable`
  ADD PRIMARY KEY (`numero`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_cuenta_tipo_cuenta1_idx` (`tipo_cuenta_codigo`);

--
-- Indices de la tabla `depreciacion`
--
ALTER TABLE `depreciacion`
  ADD PRIMARY KEY (`numero`);

--
-- Indices de la tabla `detalle_contable`
--
ALTER TABLE `detalle_contable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_contable_cuenta1_idx` (`cuenta_codigo`),
  ADD KEY `fk_detalle_contable_comprobante_contable1_idx` (`comprobante_contable_numero`);

--
-- Indices de la tabla `detalle_depreciaciones`
--
ALTER TABLE `detalle_depreciaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_depreciaciones_activo1_idx` (`activo_id`),
  ADD KEY `fk_detalle_depreciaciones_depreciacion1_idx` (`depreciacion_numero`);

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Detalle_Articulo1_idx` (`articulo_codigo`),
  ADD KEY `fk_Detalle_cabecera_factura1_idx` (`cabecera_factura_id`);

--
-- Indices de la tabla `detalle_nomina`
--
ALTER TABLE `detalle_nomina`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_detalle_nomina_nomina1_idx` (`nomina_numero`),
  ADD KEY `fk_detalle_nomina_motivo1_idx` (`motivo_codigo`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cabecera_factura_ciudad_idx` (`ciudad_codigo`),
  ADD KEY `fk_cabecera_factura_cliente1_idx` (`cliente_id`);

--
-- Indices de la tabla `modulos`
--
ALTER TABLE `modulos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `modulo_rol`
--
ALTER TABLE `modulo_rol`
  ADD KEY `fk_modulo` (`modulo_id`),
  ADD KEY `fk_rol` (`rol_id`);

--
-- Indices de la tabla `motivo`
--
ALTER TABLE `motivo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `fk_nomina_empleado1_idx` (`empleado_cedula`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_activo`
--
ALTER TABLE `tipo_activo`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuarios_rol` (`rol_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activo`
--
ALTER TABLE `activo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `comprobante_contable`
--
ALTER TABLE `comprobante_contable`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `depreciacion`
--
ALTER TABLE `depreciacion`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_contable`
--
ALTER TABLE `detalle_contable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_depreciaciones`
--
ALTER TABLE `detalle_depreciaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_nomina`
--
ALTER TABLE `detalle_nomina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `modulos`
--
ALTER TABLE `modulos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `motivo`
--
ALTER TABLE `motivo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `nomina`
--
ALTER TABLE `nomina`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tipo_activo`
--
ALTER TABLE `tipo_activo`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_cuenta`
--
ALTER TABLE `tipo_cuenta`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `activo`
--
ALTER TABLE `activo`
  ADD CONSTRAINT `fk_activo_tipo_activo1` FOREIGN KEY (`tipo_activo_codigo`) REFERENCES `tipo_activo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD CONSTRAINT `fk_cuenta_tipo_cuenta1` FOREIGN KEY (`tipo_cuenta_codigo`) REFERENCES `tipo_cuenta` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_contable`
--
ALTER TABLE `detalle_contable`
  ADD CONSTRAINT `fk_detalle_contable_comprobante_contable1` FOREIGN KEY (`comprobante_contable_numero`) REFERENCES `comprobante_contable` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_contable_cuenta1` FOREIGN KEY (`cuenta_codigo`) REFERENCES `cuenta` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_depreciaciones`
--
ALTER TABLE `detalle_depreciaciones`
  ADD CONSTRAINT `fk_detalle_depreciaciones_activo1` FOREIGN KEY (`activo_id`) REFERENCES `activo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_depreciaciones_depreciacion1` FOREIGN KEY (`depreciacion_numero`) REFERENCES `depreciacion` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `fk_Detalle_Articulo1` FOREIGN KEY (`articulo_codigo`) REFERENCES `articulo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_cabecera_factura1` FOREIGN KEY (`cabecera_factura_id`) REFERENCES `factura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_nomina`
--
ALTER TABLE `detalle_nomina`
  ADD CONSTRAINT `fk_detalle_nomina_motivo1` FOREIGN KEY (`motivo_codigo`) REFERENCES `motivo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalle_nomina_nomina1` FOREIGN KEY (`nomina_numero`) REFERENCES `nomina` (`numero`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_cabecera_factura_ciudad` FOREIGN KEY (`ciudad_codigo`) REFERENCES `ciudad` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cabecera_factura_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `modulo_rol`
--
ALTER TABLE `modulo_rol`
  ADD CONSTRAINT `fk_modulo` FOREIGN KEY (`modulo_id`) REFERENCES `modulos` (`id`),
  ADD CONSTRAINT `fk_rol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD CONSTRAINT `fk_nomina_empleado1` FOREIGN KEY (`empleado_cedula`) REFERENCES `empleado` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_rol` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
