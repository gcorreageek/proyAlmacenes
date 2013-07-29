-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.9


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sql314707
--

CREATE DATABASE IF NOT EXISTS sql314707;
USE sql314707;

--
-- Definition of table `tb_acceso_menu`
--

DROP TABLE IF EXISTS `tb_acceso_menu`;
CREATE TABLE `tb_acceso_menu` (
  `cod_accesomenu` int(11) NOT NULL AUTO_INCREMENT,
  `cod_menu` int(11) DEFAULT NULL,
  `cod_cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_accesomenu`),
  KEY `fk_codcargo_cargo_idx` (`cod_cargo`),
  KEY `fk_codmenu_menu_idx` (`cod_menu`),
  CONSTRAINT `fk_codcargo_cargo` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_codmenu_menu` FOREIGN KEY (`cod_menu`) REFERENCES `tb_menu` (`cod_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_acceso_menu`
--

/*!40000 ALTER TABLE `tb_acceso_menu` DISABLE KEYS */;
INSERT INTO `tb_acceso_menu` (`cod_accesomenu`,`cod_menu`,`cod_cargo`) VALUES 
 (1,1,1),
 (2,2,1),
 (3,3,1),
 (4,4,1),
 (5,5,1),
 (6,6,1),
 (7,7,1),
 (8,8,1),
 (9,9,1),
 (10,10,1),
 (11,11,1),
 (12,12,1),
 (13,13,1),
 (14,14,1),
 (15,15,1),
 (16,1,2),
 (17,2,2),
 (18,5,2);
/*!40000 ALTER TABLE `tb_acceso_menu` ENABLE KEYS */;


--
-- Definition of table `tb_area`
--

DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `cod_area` int(11) NOT NULL,
  `desc_area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_area`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_area`
--

/*!40000 ALTER TABLE `tb_area` DISABLE KEYS */;
INSERT INTO `tb_area` (`cod_area`,`desc_area`) VALUES 
 (1,'Almacen'),
 (2,'Sistemas'),
 (3,'Logistica'),
 (4,'Contabilidad');
/*!40000 ALTER TABLE `tb_area` ENABLE KEYS */;


--
-- Definition of table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
CREATE TABLE `tb_cargo` (
  `cod_cargo` int(11) NOT NULL,
  `desc_cargo` varchar(45) DEFAULT NULL,
  `cod_area` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_cargo`),
  KEY `fk_codarea_cargo_idx` (`cod_area`),
  CONSTRAINT `fk_codarea_cargo` FOREIGN KEY (`cod_area`) REFERENCES `tb_area` (`cod_area`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cargo`
--

/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` (`cod_cargo`,`desc_cargo`,`cod_area`) VALUES 
 (1,'Jefe de Almacen',1),
 (2,'Jefe de RRHH',2);
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;


--
-- Definition of table `tb_cotizacion`
--

DROP TABLE IF EXISTS `tb_cotizacion`;
CREATE TABLE `tb_cotizacion` (
  `cod_cotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `obs_cotizacion` text,
  `cod_usuario` int(11) DEFAULT NULL,
  `fecharegistro_cotizacion` date DEFAULT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_cotizacion`),
  KEY `fk_cotizacion_cod_usuario_idx` (`cod_usuario`),
  KEY `fk_cotizacion_cod_proveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_cotizacion_cod_proveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotizacion_cod_usuario` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cotizacion`
--

/*!40000 ALTER TABLE `tb_cotizacion` DISABLE KEYS */;
INSERT INTO `tb_cotizacion` (`cod_cotizacion`,`obs_cotizacion`,`cod_usuario`,`fecharegistro_cotizacion`,`cod_proveedor`) VALUES 
 (5,NULL,1,'2013-07-28',12);
/*!40000 ALTER TABLE `tb_cotizacion` ENABLE KEYS */;


--
-- Definition of table `tb_cotizacion_detalle`
--

DROP TABLE IF EXISTS `tb_cotizacion_detalle`;
CREATE TABLE `tb_cotizacion_detalle` (
  `cod_detallecotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `cant_detallecotizacion` int(11) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  `cod_producto_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`cod_detallecotizacion`),
  KEY `fk_Detalle_Cotizacion_Cotizacion1` (`cod_cotizacion`),
  KEY `fk_detalle_cotizacion_cod_productoproveedor_idx` (`cod_producto_proveedor`),
  CONSTRAINT `fk_detalle_cotizacion_cod_productoproveedor` FOREIGN KEY (`cod_producto_proveedor`) REFERENCES `tb_producto_proveedor` (`cod_producto_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Cotizacion_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cotizacion_detalle`
--

/*!40000 ALTER TABLE `tb_cotizacion_detalle` DISABLE KEYS */;
INSERT INTO `tb_cotizacion_detalle` (`cod_detallecotizacion`,`cant_detallecotizacion`,`cod_cotizacion`,`cod_producto_proveedor`) VALUES 
 (1,43,5,4),
 (2,9,5,2);
/*!40000 ALTER TABLE `tb_cotizacion_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_informe_externo`
--

DROP TABLE IF EXISTS `tb_informe_externo`;
CREATE TABLE `tb_informe_externo` (
  `cod_informe_externo` int(11) NOT NULL AUTO_INCREMENT,
  `nro_informe_externo` varchar(45) DEFAULT NULL,
  `fecha_informe_externo` datetime DEFAULT NULL,
  `tipo_informe_externo` int(11) DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_ordencompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_informe_externo`),
  KEY `fk_usuario_inf_ext_idx` (`cod_usuario`),
  KEY `fk_ordencompra_cod_oc_idx` (`cod_ordencompra`),
  CONSTRAINT `fk_ordencompra_cod_oc` FOREIGN KEY (`cod_ordencompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_inf_ext` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='proveedor(recepcion de los productos)';

--
-- Dumping data for table `tb_informe_externo`
--

/*!40000 ALTER TABLE `tb_informe_externo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_externo` ENABLE KEYS */;


--
-- Definition of table `tb_informe_externo_detalle`
--

DROP TABLE IF EXISTS `tb_informe_externo_detalle`;
CREATE TABLE `tb_informe_externo_detalle` (
  `cod_detalle_informe_externo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_informe_externo` int(11) DEFAULT NULL,
  `cod_detalle_ordencompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detalle_informe_externo`),
  KEY `fk_informeext_id_idx` (`cod_informe_externo`),
  KEY `fk_codoc_ext_id_idx` (`cod_detalle_ordencompra`),
  CONSTRAINT `fk_codoc_ext_id` FOREIGN KEY (`cod_detalle_ordencompra`) REFERENCES `tb_ordencompra_detalle` (`cod_DetalleOrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_informeext_id` FOREIGN KEY (`cod_informe_externo`) REFERENCES `tb_informe_externo` (`cod_informe_externo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_informe_externo_detalle`
--

/*!40000 ALTER TABLE `tb_informe_externo_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_externo_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_informe_interno`
--

DROP TABLE IF EXISTS `tb_informe_interno`;
CREATE TABLE `tb_informe_interno` (
  `cod_informe_interno` int(11) NOT NULL AUTO_INCREMENT,
  `nro_informe_interno` varchar(45) DEFAULT NULL,
  `fecha_informe_interno` datetime DEFAULT NULL,
  `tipo_informe_interno` int(11) DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_pedido` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_informe_interno`),
  KEY `fk_usuario_inf_int_idx` (`cod_usuario`),
  KEY `fk_pedido_inf_int_idx` (`cod_pedido`),
  CONSTRAINT `fk_pedido_inf_int` FOREIGN KEY (`cod_pedido`) REFERENCES `tb_pedido` (`cod_solicitudPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_inf_int` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='area(salida productos, recepcion de producto devuelto)';

--
-- Dumping data for table `tb_informe_interno`
--

/*!40000 ALTER TABLE `tb_informe_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_interno` ENABLE KEYS */;


--
-- Definition of table `tb_informe_interno_detalle`
--

DROP TABLE IF EXISTS `tb_informe_interno_detalle`;
CREATE TABLE `tb_informe_interno_detalle` (
  `cod_detalle_informe_interno` int(11) NOT NULL AUTO_INCREMENT,
  `cod_informe_interno` int(11) DEFAULT NULL,
  `cod_detalle_pedido` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detalle_informe_interno`),
  KEY `fk_informeint_pk_idx` (`cod_informe_interno`),
  KEY `fk_detallepedido_pk_idx` (`cod_detalle_pedido`),
  CONSTRAINT `fk_detallepedido_pk` FOREIGN KEY (`cod_detalle_pedido`) REFERENCES `tb_pedido_detalle` (`cod_detallePedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_informeint_pk` FOREIGN KEY (`cod_informe_interno`) REFERENCES `tb_informe_interno` (`cod_informe_interno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_informe_interno_detalle`
--

/*!40000 ALTER TABLE `tb_informe_interno_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_interno_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `cod_menu` int(11) NOT NULL AUTO_INCREMENT,
  `nom_menu` varchar(200) DEFAULT NULL,
  `url_menu` varchar(200) DEFAULT NULL,
  `icono_menu` varchar(200) DEFAULT NULL,
  `tipo_menu` int(11) DEFAULT NULL,
  `id_submenu` int(11) DEFAULT NULL,
  `orden_menu` int(11) DEFAULT NULL,
  `master_menu` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_menu`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_menu`
--

/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` (`cod_menu`,`nom_menu`,`url_menu`,`icono_menu`,`tipo_menu`,`id_submenu`,`orden_menu`,`master_menu`) VALUES 
 (1,'Mantenimientos','#',NULL,1,1,2,1),
 (2,'Producto','mainProducto',NULL,2,1,3,1),
 (3,'Proveedor','mainProveedor',NULL,2,1,4,1),
 (4,'Pedido','#',NULL,1,4,6,1),
 (5,'Inicio','inicio',NULL,1,5,1,0),
 (6,'Producto Proveedor','mainProductoProveedor',NULL,2,1,5,1),
 (7,'Nuevo Pedido','nuevoPedido',NULL,2,4,7,1),
 (8,'Evaluar Pedido','evaluarPedido',NULL,2,4,8,1),
 (9,'Cotizacion','mainCotizacion',NULL,1,9,9,0),
 (10,'Orden de Compra','mainOrdenCompra',NULL,1,10,10,0),
 (11,'Informe Interno','#',NULL,1,11,11,1),
 (12,'Entrada','mainInformeInternoEntrada',NULL,2,11,13,1),
 (13,'Salida','mainInformeInternoSalida',NULL,2,11,12,1),
 (14,'Informe Externa','#',NULL,1,14,14,1),
 (15,'Entrada','mainInformeExternoEntrada',NULL,2,14,15,1);
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;


--
-- Definition of table `tb_ordencompra`
--

DROP TABLE IF EXISTS `tb_ordencompra`;
CREATE TABLE `tb_ordencompra` (
  `cod_OrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fecharegistro_ordencompra` date DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_OrdenCompra`),
  KEY `fk_Orden_Compra_Cotizacion1` (`cod_cotizacion`),
  KEY `fk_orden_compa_idusario_idx` (`cod_usuario`),
  KEY `fk_ordem_compra_codproveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_ordem_compra_codproveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_compa_idusario` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orden_Compra_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra`
--

/*!40000 ALTER TABLE `tb_ordencompra` DISABLE KEYS */;
INSERT INTO `tb_ordencompra` (`cod_OrdenCompra`,`fecharegistro_ordencompra`,`cod_usuario`,`cod_cotizacion`,`cod_proveedor`) VALUES 
 (3,'2013-07-28',1,5,12);
/*!40000 ALTER TABLE `tb_ordencompra` ENABLE KEYS */;


--
-- Definition of table `tb_ordencompra_detalle`
--

DROP TABLE IF EXISTS `tb_ordencompra_detalle`;
CREATE TABLE `tb_ordencompra_detalle` (
  `cod_DetalleOrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `cod_ordenCompra` int(11) DEFAULT NULL,
  `cod_producto_proveedor` int(11) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_DetalleOrdenCompra`),
  KEY `fk_ordenCompra` (`cod_ordenCompra`),
  KEY `fk_producto` (`cod_producto_proveedor`),
  CONSTRAINT `fk_ordencompra_detalle_cod_productoproveedor` FOREIGN KEY (`cod_producto_proveedor`) REFERENCES `tb_producto_proveedor` (`cod_producto_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordenCompra` FOREIGN KEY (`cod_ordenCompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra_detalle`
--

/*!40000 ALTER TABLE `tb_ordencompra_detalle` DISABLE KEYS */;
INSERT INTO `tb_ordencompra_detalle` (`cod_DetalleOrdenCompra`,`cod_ordenCompra`,`cod_producto_proveedor`,`cantidad`) VALUES 
 (1,3,4,'43'),
 (2,3,2,'9'),
 (3,3,3,'2');
/*!40000 ALTER TABLE `tb_ordencompra_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_pedido`
--

DROP TABLE IF EXISTS `tb_pedido`;
CREATE TABLE `tb_pedido` (
  `cod_solicitudPedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_usuario` int(11) DEFAULT NULL,
  `comentario_pedido` text,
  `tipo_pedido` varchar(45) DEFAULT NULL,
  `fechaDevolucion_pedido` date DEFAULT NULL,
  `fechaRegistro_pedido` date DEFAULT NULL,
  `fechaEntrega_pedido` date DEFAULT NULL,
  `estado_pedido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_solicitudPedido`),
  KEY `fk_usuario` (`cod_usuario`),
  CONSTRAINT `tb_pedido_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido`
--

/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` (`cod_solicitudPedido`,`cod_usuario`,`comentario_pedido`,`tipo_pedido`,`fechaDevolucion_pedido`,`fechaRegistro_pedido`,`fechaEntrega_pedido`,`estado_pedido`) VALUES 
 (1,1,'sss','sss','2013-11-07','2013-07-27','2013-09-07','Sin Atender'),
 (2,1,NULL,NULL,NULL,NULL,NULL,'Sin Atender'),
 (3,1,'prueba obs','Prestamo',NULL,NULL,NULL,'Sin Atender'),
 (4,1,'noiguna','Prestamo',NULL,NULL,NULL,'Sin Atender'),
 (5,1,'yes!','Prestamo',NULL,NULL,NULL,'Sin Atender'),
 (6,1,'federica','Prestamo',NULL,NULL,NULL,'Sin Atender'),
 (7,1,'kkk','Prestamo',NULL,NULL,NULL,'Sin Atender'),
 (8,1,'se','Prestamo','0012-07-05',NULL,'0012-07-05','Sin Atender'),
 (9,1,'bien ok!','Prestamo','0034-01-03',NULL,'0034-01-03','Sin Atender'),
 (10,1,'ddddddd','Prestamo','2013-07-29',NULL,'2013-07-29','Sin Atender'),
 (11,1,'ser','Prestamo','2013-07-24',NULL,'2013-07-01','Sin Atender'),
 (12,1,'ddd','Prestamo','2013-07-17','2013-07-27','2013-07-01','Sin Atender'),
 (14,1,'ssss','Prestamo','2013-07-31','2013-07-27','2013-07-01','Sin Atender'),
 (15,1,'ser','Prestamo','2013-07-25','2013-07-27','2013-07-01','Sin Atender'),
 (16,1,'niguna','Abastecimiento','2013-07-02','2013-07-27','2013-07-01','Desaprobado');
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;


--
-- Definition of table `tb_pedido_detalle`
--

DROP TABLE IF EXISTS `tb_pedido_detalle`;
CREATE TABLE `tb_pedido_detalle` (
  `cod_detallePedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_solicitudPedido` int(11) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detallePedido`),
  KEY `fk_pedido` (`cod_solicitudPedido`),
  KEY `fk_producto` (`cod_producto`),
  CONSTRAINT `tb_pedido_fk_cod_pedido` FOREIGN KEY (`cod_solicitudPedido`) REFERENCES `tb_pedido` (`cod_solicitudPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_pedido_detalle_ibfk_2` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido_detalle`
--

/*!40000 ALTER TABLE `tb_pedido_detalle` DISABLE KEYS */;
INSERT INTO `tb_pedido_detalle` (`cod_detallePedido`,`cod_solicitudPedido`,`cod_producto`,`cantidad`) VALUES 
 (1,NULL,33,21),
 (2,1,61,2),
 (3,1,32,4),
 (4,1,61,21),
 (5,1,60,13),
 (6,1,60,27),
 (7,1,56,56),
 (8,1,61,12),
 (9,1,62,24),
 (10,1,32,2),
 (11,1,26,22),
 (12,1,56,8),
 (13,1,26,1),
 (14,1,33,4),
 (15,1,26,22),
 (16,1,35,1),
 (17,1,26,2),
 (18,1,56,4),
 (19,1,61,34),
 (20,1,56,16),
 (21,1,26,3),
 (22,12,26,12),
 (23,12,35,32),
 (24,14,26,21),
 (25,14,61,56),
 (26,16,26,21),
 (27,16,61,25);
/*!40000 ALTER TABLE `tb_pedido_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
CREATE TABLE `tb_producto` (
  `cod_producto` int(11) NOT NULL AUTO_INCREMENT,
  `desc_producto` varchar(45) DEFAULT NULL,
  `unidadMedida` varchar(45) DEFAULT NULL,
  `stock_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_producto`),
  KEY `fk_unidadMedida` (`unidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto`
--

/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` (`cod_producto`,`desc_producto`,`unidadMedida`,`stock_producto`) VALUES 
 (26,'pp','Docena',350),
 (32,'aaa','',NULL),
 (33,'aaa','',NULL),
 (34,'piza','',NULL),
 (35,'Celular sin pantalla','',NULL),
 (37,'Celular sin pantalla','',NULL),
 (49,'Celular sin pantalla','',NULL),
 (50,'p','',NULL),
 (52,'ultimo','',NULL),
 (54,'Tiza','',NULL),
 (55,'Prueba',NULL,NULL),
 (56,'ADIDAS','Unidad',NULL),
 (57,'ADIDAS','Unidad',NULL),
 (58,'caido','Unidad',NULL),
 (59,'loco','Media Docena',NULL),
 (60,'s','2',NULL),
 (61,'adidad marca de 3 tiras','Caja',80),
 (62,'tizas','Docena',NULL);
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;


--
-- Definition of table `tb_producto_proveedor`
--

DROP TABLE IF EXISTS `tb_producto_proveedor`;
CREATE TABLE `tb_producto_proveedor` (
  `cod_producto_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `cod_producto` int(11) DEFAULT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL COMMENT 'precio es referencial',
  PRIMARY KEY (`cod_producto_proveedor`),
  KEY `fk_codproducto_producto_idx` (`cod_producto`),
  KEY `fk_codproveedor_proveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_codproducto_producto` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_codproveedor_proveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto_proveedor`
--

/*!40000 ALTER TABLE `tb_producto_proveedor` DISABLE KEYS */;
INSERT INTO `tb_producto_proveedor` (`cod_producto_proveedor`,`cod_producto`,`cod_proveedor`,`precio`) VALUES 
 (2,56,12,NULL),
 (3,55,12,NULL),
 (4,61,12,NULL),
 (5,60,13,NULL);
/*!40000 ALTER TABLE `tb_producto_proveedor` ENABLE KEYS */;


--
-- Definition of table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
CREATE TABLE `tb_proveedor` (
  `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `raz_social` varchar(150) DEFAULT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_proveedor`
--

/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` (`cod_proveedor`,`raz_social`,`ruc`,`telefono`,`correo`) VALUES 
 (3,'b','','',''),
 (5,'e','','',''),
 (6,'e','','',''),
 (7,'Abe','','',NULL),
 (12,'Abe production','10457205550','5402601','gcorreageek@gmail.com'),
 (13,'Rensox sa','45720111','703-0222','cccc@gmail.com');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;


--
-- Definition of table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
CREATE TABLE `tb_usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_usuario` varchar(45) DEFAULT NULL,
  `apePat_usuario` varchar(45) DEFAULT NULL,
  `apeMat_usuario` varchar(45) DEFAULT NULL,
  `cod_cargo` int(11) DEFAULT NULL,
  `id_usuario` varchar(45) DEFAULT NULL,
  `pass_usuario` varchar(150) DEFAULT NULL,
  `estado_usuario` char(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  UNIQUE KEY `ck_uni` (`id_usuario`),
  KEY `fk_cargo` (`cod_cargo`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_usuario`
--

/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` (`cod_usuario`,`nom_usuario`,`apePat_usuario`,`apeMat_usuario`,`cod_cargo`,`id_usuario`,`pass_usuario`,`estado_usuario`) VALUES 
 (1,'Gustavo','Correa','Caja',1,'gcorreageek','aa743a0aaec8f7d7a1f01442503957f4d7a2d634','1');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;


--
-- Definition of procedure `sp_buscaUsuario`
--

DROP PROCEDURE IF EXISTS `sp_buscaUsuario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscaUsuario`(Vid_usuario varchar(40))
BEGIN
SELECT tb_perfil.desc_perfil,
       tb_area.desc_area,
       tb_cargo.desc_cargo,
       tb_usuario.cod_usuario,
       tb_usuario.nom_usuario,
       tb_usuario.apePat_usuario,
       tb_usuario.apeMat_usuario,
       tb_usuario.id_usuario,
       tb_usuario.pass_usuario,
       tb_usuario.cod_perfil
  FROM    (   (   sql314707.tb_usuario tb_usuario
               INNER JOIN
                  sql314707.tb_perfil tb_perfil
               ON (tb_usuario.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              sql314707.tb_cargo tb_cargo
           ON (tb_usuario.cod_cargo = tb_cargo.cod_cargo))
       INNER JOIN
          sql314707.tb_area tb_area
       ON (tb_usuario.cod_area = tb_area.cod_area)
 WHERE (tb_usuario.id_usuario = Vid_usuario) and (tb_usuario.estado_usuario='A');
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_buscaUsuarioM`
--

DROP PROCEDURE IF EXISTS `sp_buscaUsuarioM`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscaUsuarioM`(Vid_usuario varchar(45))
BEGIN
SELECT tb_usuario.nom_usuario,
       tb_usuario.apePat_usuario,
       tb_usuario.apeMat_usuario,
       tb_usuario.cod_cargo,
       tb_usuario.cod_area,
       tb_usuario.id_usuario
  FROM sql314707.tb_usuario tb_usuario
 WHERE (tb_usuario.id_usuario = Vid_usuario);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ListaAreas`
--

DROP PROCEDURE IF EXISTS `sp_ListaAreas`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ListaAreas`()
BEGIN
	SELECT tb_area.cod_area, tb_area.desc_area
  FROM sql314707.tb_area tb_area;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_ListaCargos`
--

DROP PROCEDURE IF EXISTS `sp_ListaCargos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ListaCargos`()
BEGIN
	SELECT tb_cargo.cod_cargo, tb_cargo.desc_cargo
  FROM sql314707.tb_cargo tb_cargo;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listaDetUsuarios`
--

DROP PROCEDURE IF EXISTS `sp_listaDetUsuarios`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaDetUsuarios`()
BEGIN
	SELECT tb_usuario.nom_usuario,
       tb_usuario.apePat_usuario,
       tb_usuario.apeMat_usuario,
       tb_area.desc_area,
       tb_cargo.desc_cargo,
       tb_usuario.id_usuario,
       tb_usuario.estado_usuario
  FROM    (   sql314707.tb_usuario tb_usuario
           INNER JOIN
              sql314707.tb_area tb_area
           ON (tb_usuario.cod_area = tb_area.cod_area))
       INNER JOIN
          sql314707.tb_cargo tb_cargo
       ON (tb_usuario.cod_cargo = tb_cargo.cod_cargo);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listaMenu`
--

DROP PROCEDURE IF EXISTS `sp_listaMenu`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaMenu`(varcod_perfil int)
BEGIN
	SELECT distinct tb_menu.desc_Menu,
       tb_menu.cod_Menu,
       tb_menu.actionUrl_Menu
  FROM    (   (   sql314707.tb_detalleperfil tb_detalleperfil
               INNER JOIN
                  sql314707.tb_perfil tb_perfil
               ON (tb_detalleperfil.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              sql314707.tb_menu tb_menu
           ON (tb_detalleperfil.cod_menu = tb_menu.cod_Menu))
       INNER JOIN
          sql314707.tb_usuario tb_usuario
       ON (tb_usuario.cod_perfil = tb_perfil.cod_perfil)
 WHERE (tb_usuario.cod_perfil = varcod_perfil);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listaOpcionesMenu`
--

DROP PROCEDURE IF EXISTS `sp_listaOpcionesMenu`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaOpcionesMenu`(varcod_menu int,varcod_perfil int)
BEGIN
	SELECT tb_opcionesmenu.cod_opcionesMenu,
       tb_opcionesmenu.cod_Menu,
       tb_opcionesmenu.desc_OpcionesMenu,
       tb_opcionesmenu.actionUrl_OpcionesMenu
  FROM    (   (   sql314707.tb_detalleperfil tb_detalleperfil
               INNER JOIN
                  sql314707.tb_perfil tb_perfil
               ON (tb_detalleperfil.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              sql314707.tb_opcionesmenu tb_opcionesmenu
           ON (tb_detalleperfil.cod_opcionesMenu =
                  tb_opcionesmenu.cod_opcionesMenu))
       INNER JOIN
          sql314707.tb_usuario tb_usuario
       ON (tb_usuario.cod_perfil = tb_perfil.cod_perfil)
 WHERE (tb_opcionesmenu.cod_Menu =varcod_menu ) AND (tb_usuario.cod_perfil = varcod_perfil);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listaProductos`
--

DROP PROCEDURE IF EXISTS `sp_listaProductos`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaProductos`(estado_producto char(1))
BEGIN
	SELECT tb_producto.cod_producto,
       tb_producto.desc_producto,
       tb_producto.cod_unidadMedida,
       tb_producto.cod_marca,
       tb_producto.cod_categoria,
       tb_producto.stock_producto,
       tb_producto.estado_producto
  FROM sql314707.tb_producto tb_producto
 WHERE (tb_producto.estado_producto = estado_producto);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_listaProductosCD`
--

DROP PROCEDURE IF EXISTS `sp_listaProductosCD`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listaProductosCD`()
BEGIN
	SELECT tb_producto.cod_producto, tb_producto.desc_producto
  FROM sql314707.tb_producto tb_producto
 WHERE (tb_producto.estado_producto = 'A');
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_obtenerUltimoCodigo`
--

DROP PROCEDURE IF EXISTS `sp_obtenerUltimoCodigo`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_obtenerUltimoCodigo`()
BEGIN
	SELECT tb_solicitudpedido.cod_solicitudPedido
  FROM sql314707.tb_solicitudpedido tb_solicitudpedido
ORDER BY tb_solicitudpedido.cod_solicitudPedido DESC
 LIMIT 1;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registraDetallePedido`
--

DROP PROCEDURE IF EXISTS `sp_registraDetallePedido`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registraDetallePedido`( Vcod_solicitudPedido	char(8),
                                            Vcod_producto	int,
                                            Vcantidad	int)
BEGIN
	INSERT
  INTO sql314707.tb_detallepedido(cod_solicitudPedido, cod_producto, cantidad)
VALUES (Vcod_solicitudPedido,Vcod_producto,Vcantidad);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registraProducto`
--

DROP PROCEDURE IF EXISTS `sp_registraProducto`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registraProducto`(Vdesc_producto	varchar(45),
                                      Vcod_unidadMedida	int(11),
                                      Vcod_marca	int(11),
                                      Vcod_categoria	int(11))
BEGIN
	INSERT INTO sql314707.tb_producto(desc_producto,
                                 cod_unidadMedida,
                                 cod_marca,
                                 cod_categoria)
VALUES (Vdesc_producto,
        Vcod_unidadMedida,
        Vcod_marca,
        Vcod_categoria);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarSolicitudPedido`
--

DROP PROCEDURE IF EXISTS `sp_registrarSolicitudPedido`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarSolicitudPedido`(Vcod_solicitudPedido	char(8),	
                        Vcod_usuario	int,	
                        Vcomentario_pedido	text,	
                        Vtipo_pedido	varchar(45),	
                        VfechaDevolucion_pedido	date,	
                        VfechaRegistro_pedido	date,		
                        VfechaRespuesta_pedido	date,		
                        Vestado_pedido	varchar(45))
BEGIN
            INSERT INTO sql314707.tb_solicitudpedido(cod_solicitudPedido,
                                                    cod_usuario,
                                                    comentario_pedido,
                                                    tipo_pedido,
                                                    fechaDevolucion_pedido,
                                                    fechaRegistro_pedido,
                                                    fechaRespuesta_pedido,
                                                    estado_pedido)
            VALUES (Vcod_solicitudPedido	,	
                        Vcod_usuario	,	
                        Vcomentario_pedido	,	
                        Vtipo_pedido	,	
                        VfechaDevolucion_pedido	,	
                        VfechaRegistro_pedido	,		
                        VfechaRespuesta_pedido	,		
                        Vestado_pedido	) ;
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `sp_registrarUsuario`
--

DROP PROCEDURE IF EXISTS `sp_registrarUsuario`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarUsuario`(Vnom_usuario	varchar(45),
                                      VapePat_usuario	varchar(45),
                                      VapeMat_usuario	varchar(45),
                                      Vcod_cargo	int(11),
                                      Vcod_area	int(11),
                                      Vid_usuario	varchar(45),
                                      Vpass_usuario	varchar(150))
BEGIN
INSERT INTO sql314707.tb_usuario(nom_usuario,
                                apePat_usuario,
                                apeMat_usuario,
                                cod_cargo,
                                cod_area,
                                id_usuario,
                                pass_usuario,estado_usuario)
VALUES (Vnom_usuario,
        VapePat_usuario,
        VapeMat_usuario,
        Vcod_cargo,
        Vcod_area,
        Vid_usuario,
        Vpass_usuario,'A');
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
