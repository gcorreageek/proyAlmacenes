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
-- Create schema bd_sigal
--

CREATE DATABASE IF NOT EXISTS bd_sigal;
USE bd_sigal;

--
-- Definition of table `tb_acceso_menu`
--

DROP TABLE IF EXISTS `tb_acceso_menu`;
CREATE TABLE `tb_acceso_menu` (
  `cod_accesomenu` int(11) NOT NULL AUTO_INCREMENT,
  `cod_menu` int(11) NOT NULL,
  `cod_cargo` int(11) NOT NULL,
  `habilitado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_accesomenu`),
  UNIQUE KEY `fk_accesomenu_codcargo_codmenu` (`cod_menu`,`cod_cargo`),
  KEY `fk_codcargo_cargo_idx` (`cod_cargo`),
  KEY `fk_codmenu_menu_idx` (`cod_menu`),
  CONSTRAINT `fk_codcargo_cargo` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_codmenu_menu` FOREIGN KEY (`cod_menu`) REFERENCES `tb_menu` (`cod_menu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_acceso_menu`
--

/*!40000 ALTER TABLE `tb_acceso_menu` DISABLE KEYS */;
INSERT INTO `tb_acceso_menu` (`cod_accesomenu`,`cod_menu`,`cod_cargo`,`habilitado`) VALUES 
 (1,1,1,'Habilitado'),
 (2,2,1,'Habilitado'),
 (3,3,1,'Habilitado'),
 (4,4,1,'Habilitado'),
 (5,5,1,'Habilitado'),
 (6,6,1,'Habilitado'),
 (7,7,1,'Habilitado'),
 (8,8,1,'Habilitado'),
 (9,9,1,'Habilitado'),
 (10,10,1,'Habilitado'),
 (11,11,1,'Habilitado'),
 (12,12,1,'Habilitado'),
 (13,13,1,'Habilitado'),
 (14,14,1,'Habilitado'),
 (15,15,1,'Habilitado'),
 (19,16,1,'Habilitado'),
 (20,17,1,'Habilitado'),
 (21,18,1,'Habilitado'),
 (22,19,1,'Habilitado'),
 (23,20,1,'Habilitado'),
 (31,5,28,'Desabilitado'),
 (32,1,28,'Habilitado'),
 (33,2,28,'Habilitado'),
 (34,4,28,'Habilitado'),
 (35,7,28,'Habilitado'),
 (37,2,29,'Habilitado'),
 (38,5,27,'Habilitado'),
 (40,1,27,'Habilitado'),
 (41,3,27,'Habilitado'),
 (43,6,27,'Habilitado'),
 (44,10,27,'Habilitado'),
 (45,19,27,'Habilitado'),
 (46,14,27,'Habilitado'),
 (47,15,27,'Habilitado'),
 (48,11,27,'Habilitado'),
 (49,13,27,'Habilitado'),
 (50,12,27,'Habilitado'),
 (51,21,1,'Habilitado'),
 (52,22,1,'Habilitado'),
 (53,23,1,'Habilitado');
/*!40000 ALTER TABLE `tb_acceso_menu` ENABLE KEYS */;


--
-- Definition of table `tb_area`
--

DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `cod_area` int(11) NOT NULL AUTO_INCREMENT,
  `desc_area` varchar(45) NOT NULL,
  PRIMARY KEY (`cod_area`),
  UNIQUE KEY `desc_area_UNIQUE` (`desc_area`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_area`
--

/*!40000 ALTER TABLE `tb_area` DISABLE KEYS */;
INSERT INTO `tb_area` (`cod_area`,`desc_area`) VALUES 
 (1,'Administracion del Sistema'),
 (4,'Contabilidad'),
 (5,'Externa'),
 (3,'Logistica'),
 (2,'Sistemas');
/*!40000 ALTER TABLE `tb_area` ENABLE KEYS */;


--
-- Definition of table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
CREATE TABLE `tb_cargo` (
  `cod_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `desc_cargo` varchar(45) DEFAULT NULL,
  `cod_area` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_cargo`),
  UNIQUE KEY `uniq_area_cargo_unico` (`desc_cargo`,`cod_area`),
  KEY `fk_codarea_cargo_idx` (`cod_area`),
  CONSTRAINT `fk_codarea_cargo` FOREIGN KEY (`cod_area`) REFERENCES `tb_area` (`cod_area`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cargo`
--

/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` (`cod_cargo`,`desc_cargo`,`cod_area`) VALUES 
 (1,'Administrador',1),
 (29,'Asistente de Logistica',3),
 (27,'DBA',2),
 (30,'Externo',5),
 (28,'Jefe de Logistica',3),
 (4,'pruea 2',NULL),
 (5,'pruea 3',NULL),
 (19,'pruea 3',1),
 (6,'pruea 4',NULL),
 (7,'pruea 6',NULL),
 (22,'pruea 6',1);
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;


--
-- Definition of table `tb_cotizacion`
--

DROP TABLE IF EXISTS `tb_cotizacion`;
CREATE TABLE `tb_cotizacion` (
  `cod_cotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `obs_cotizacion` text,
  `cod_usuario` int(11) DEFAULT NULL,
  `fecharegistro_cotizacion` datetime DEFAULT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_cotizacion`),
  KEY `fk_cotizacion_cod_usuario_idx` (`cod_usuario`),
  KEY `fk_cotizacion_cod_proveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_cotizacion_cod_proveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotizacion_cod_usuario` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cotizacion`
--

/*!40000 ALTER TABLE `tb_cotizacion` DISABLE KEYS */;
INSERT INTO `tb_cotizacion` (`cod_cotizacion`,`obs_cotizacion`,`cod_usuario`,`fecharegistro_cotizacion`,`cod_proveedor`) VALUES 
 (1,NULL,1,'2013-08-01 13:28:07',18),
 (2,NULL,1,'2013-08-01 13:29:35',18),
 (3,NULL,1,'2013-08-14 15:50:56',19),
 (4,NULL,1,'2013-08-14 23:13:33',18),
 (5,NULL,1,'2013-08-14 23:30:44',19),
 (6,NULL,1,'2013-08-14 23:37:58',19),
 (7,NULL,1,'2013-08-14 23:38:56',19),
 (8,NULL,1,'2013-08-15 15:42:01',19);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cotizacion_detalle`
--

/*!40000 ALTER TABLE `tb_cotizacion_detalle` DISABLE KEYS */;
INSERT INTO `tb_cotizacion_detalle` (`cod_detallecotizacion`,`cant_detallecotizacion`,`cod_cotizacion`,`cod_producto_proveedor`) VALUES 
 (1,23,1,1),
 (2,18,1,3),
 (3,908,2,1),
 (4,21,3,5),
 (5,13,3,4),
 (6,10,3,8),
 (7,300,4,1),
 (8,300,4,3),
 (9,50,5,6),
 (10,90,6,10),
 (11,90,6,7),
 (12,777,7,10),
 (13,777,7,7),
 (14,12,8,4),
 (15,33,8,8);
/*!40000 ALTER TABLE `tb_cotizacion_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_informe_externo`
--

DROP TABLE IF EXISTS `tb_informe_externo`;
CREATE TABLE `tb_informe_externo` (
  `cod_informe_externo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_informe_externo` datetime DEFAULT NULL,
  `tipo_informe_externo` varchar(30) DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_ordencompra` int(11) DEFAULT NULL,
  `obs_informeexterno` text,
  PRIMARY KEY (`cod_informe_externo`),
  KEY `fk_usuario_inf_ext_idx` (`cod_usuario`),
  KEY `fk_ordencompra_cod_oc_idx` (`cod_ordencompra`),
  CONSTRAINT `fk_ordencompra_cod_oc` FOREIGN KEY (`cod_ordencompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_inf_ext` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='proveedor(recepcion de los productos)';

--
-- Dumping data for table `tb_informe_externo`
--

/*!40000 ALTER TABLE `tb_informe_externo` DISABLE KEYS */;
INSERT INTO `tb_informe_externo` (`cod_informe_externo`,`fecha_informe_externo`,`tipo_informe_externo`,`cod_usuario`,`cod_ordencompra`,`obs_informeexterno`) VALUES 
 (1,'2013-08-14 16:16:02','Entrada',1,2,'ingreso de prudocutos ok!'),
 (2,'2013-08-14 16:17:33','Salida',1,2,''),
 (3,'2013-08-14 16:18:42','Entrada',1,2,'ingreso ahora si ok'),
 (4,'2013-08-14 23:17:30','Entrada',1,4,'ok lo trajo el rpoveedor al tok! muy bien!'),
 (6,'2013-08-14 23:22:44','Entrada',1,5,'si quiero mas y ademas quiero del de producto1'),
 (7,'2013-08-14 23:31:37','Entrada',1,6,'Un tv plasma!'),
 (8,'2013-08-14 23:40:18','Entrada',1,7,'k rarro!');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_informe_externo_detalle`
--

/*!40000 ALTER TABLE `tb_informe_externo_detalle` DISABLE KEYS */;
INSERT INTO `tb_informe_externo_detalle` (`cod_detalle_informe_externo`,`cod_informe_externo`,`cod_detalle_ordencompra`) VALUES 
 (1,1,4),
 (2,1,5),
 (3,1,6),
 (4,2,4),
 (5,2,5),
 (6,2,6),
 (7,3,4),
 (8,3,5),
 (9,3,6),
 (10,4,9),
 (11,4,10),
 (14,6,11),
 (15,6,12),
 (16,6,13),
 (17,7,14),
 (18,8,15),
 (19,8,16);
/*!40000 ALTER TABLE `tb_informe_externo_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_informe_interno`
--

DROP TABLE IF EXISTS `tb_informe_interno`;
CREATE TABLE `tb_informe_interno` (
  `cod_informe_interno` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_informe_interno` datetime DEFAULT NULL,
  `tipo_informe_interno` varchar(30) DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_pedido` int(11) DEFAULT NULL,
  `obs_informeinterno` text,
  PRIMARY KEY (`cod_informe_interno`),
  KEY `fk_usuario_inf_int_idx` (`cod_usuario`),
  KEY `fk_pedido_inf_int_idx` (`cod_pedido`),
  CONSTRAINT `fk_pedido_inf_int` FOREIGN KEY (`cod_pedido`) REFERENCES `tb_pedido` (`cod_solicitudPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_inf_int` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='area(salida productos, recepcion de producto devuelto)';

--
-- Dumping data for table `tb_informe_interno`
--

/*!40000 ALTER TABLE `tb_informe_interno` DISABLE KEYS */;
INSERT INTO `tb_informe_interno` (`cod_informe_interno`,`fecha_informe_interno`,`tipo_informe_interno`,`cod_usuario`,`cod_pedido`,`obs_informeinterno`) VALUES 
 (1,'2013-08-14 16:20:41','Salida',1,9,'ya te lo paso!'),
 (2,'2013-08-14 23:40:47','Salida',1,10,'ya hay va!');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_informe_interno_detalle`
--

/*!40000 ALTER TABLE `tb_informe_interno_detalle` DISABLE KEYS */;
INSERT INTO `tb_informe_interno_detalle` (`cod_detalle_informe_interno`,`cod_informe_interno`,`cod_detalle_pedido`) VALUES 
 (1,1,9),
 (2,2,10),
 (3,2,11),
 (4,2,12),
 (5,2,13);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_menu`
--

/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` (`cod_menu`,`nom_menu`,`url_menu`,`icono_menu`,`tipo_menu`,`id_submenu`,`orden_menu`,`master_menu`) VALUES 
 (1,'Mantenimientos','#',NULL,1,1,2,1),
 (2,'Producto','mainProducto',NULL,2,1,3,1),
 (3,'Proveedor','mainProveedor',NULL,2,1,4,1),
 (4,'Pedido','#',NULL,1,4,10,1),
 (5,'Inicio','inicio',NULL,1,5,1,0),
 (6,'Producto Proveedor','mainProductoProveedor',NULL,2,1,5,1),
 (7,'Nuevo Pedido','nuevoPedido',NULL,2,4,11,1),
 (8,'Evaluar Pedido','evaluarPedido',NULL,2,4,12,1),
 (9,'Cotizacion','mainCotizacion',NULL,1,9,13,0),
 (10,'Orden de Compra','mainOrdenCompra',NULL,1,10,14,0),
 (11,'Informe Interno','#',NULL,1,11,15,1),
 (12,'Entrada','mainInformeInternoEntrada',NULL,2,11,17,1),
 (13,'Salida','mainInformeInternoSalida',NULL,2,11,16,1),
 (14,'Informe Externa','#',NULL,1,14,18,1),
 (15,'Entrada','mainInformeExternoEntrada',NULL,2,14,19,1),
 (16,'Salida','mainInformeExternoSalida',NULL,2,14,20,1),
 (17,'Area','mainArea',NULL,2,1,6,1),
 (18,'Cargo','mainCargo',NULL,2,1,7,1),
 (19,'Usuario','mainUsuario',NULL,2,1,8,1),
 (20,'Acceso','mainAcceso',NULL,2,1,9,1),
 (21,'Reportes','#',NULL,1,21,21,1),
 (22,'Producto','productos',NULL,2,21,22,1),
 (23,'Informe','informe',NULL,2,21,23,1);
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;


--
-- Definition of table `tb_ordencompra`
--

DROP TABLE IF EXISTS `tb_ordencompra`;
CREATE TABLE `tb_ordencompra` (
  `cod_OrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `fecharegistro_ordencompra` datetime DEFAULT NULL,
  `cod_usuario` int(11) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  `estado_ordencompra` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_OrdenCompra`),
  KEY `fk_Orden_Compra_Cotizacion1` (`cod_cotizacion`),
  KEY `fk_orden_compa_idusario_idx` (`cod_usuario`),
  KEY `fk_ordem_compra_codproveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_ordem_compra_codproveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orden_compa_idusario` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orden_Compra_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra`
--

/*!40000 ALTER TABLE `tb_ordencompra` DISABLE KEYS */;
INSERT INTO `tb_ordencompra` (`cod_OrdenCompra`,`fecharegistro_ordencompra`,`cod_usuario`,`cod_cotizacion`,`cod_proveedor`,`estado_ordencompra`) VALUES 
 (2,'2013-08-14 16:14:12',1,3,19,'Entregada'),
 (3,'2013-08-14 23:13:58',1,1,18,'Pendiente'),
 (4,'2013-08-14 23:14:25',1,4,18,'Entregada'),
 (5,'2013-08-14 23:19:52',1,4,18,'Entregada'),
 (6,'2013-08-14 23:31:13',1,5,19,'Entregada'),
 (7,'2013-08-14 23:39:22',1,7,19,'Entregada'),
 (8,'2013-08-15 15:52:34',1,8,19,'Pendiente');
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
  CONSTRAINT `fk_ordenCompra` FOREIGN KEY (`cod_ordenCompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordencompra_detalle_cod_productoproveedor` FOREIGN KEY (`cod_producto_proveedor`) REFERENCES `tb_producto_proveedor` (`cod_producto_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra_detalle`
--

/*!40000 ALTER TABLE `tb_ordencompra_detalle` DISABLE KEYS */;
INSERT INTO `tb_ordencompra_detalle` (`cod_DetalleOrdenCompra`,`cod_ordenCompra`,`cod_producto_proveedor`,`cantidad`) VALUES 
 (4,2,5,'21'),
 (5,2,4,'13'),
 (6,2,8,'10'),
 (7,3,1,'23'),
 (8,3,3,'18'),
 (9,4,1,'300'),
 (10,4,3,'300'),
 (11,5,1,'300'),
 (12,5,3,'300'),
 (13,5,11,'400'),
 (14,6,6,'50'),
 (15,7,10,'777'),
 (16,7,7,'777'),
 (17,8,4,'12'),
 (18,8,8,'33'),
 (19,8,10,'21');
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
  `fechaRegistro_pedido` datetime DEFAULT NULL,
  `fechaEntrega_pedido` date DEFAULT NULL,
  `estado_pedido` varchar(45) DEFAULT NULL,
  `fechaEvaluacion_pedido` datetime DEFAULT NULL,
  `comentarioevaluacion_pedido` text,
  PRIMARY KEY (`cod_solicitudPedido`),
  KEY `fk_usuario` (`cod_usuario`),
  CONSTRAINT `tb_pedido_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido`
--

/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
INSERT INTO `tb_pedido` (`cod_solicitudPedido`,`cod_usuario`,`comentario_pedido`,`tipo_pedido`,`fechaDevolucion_pedido`,`fechaRegistro_pedido`,`fechaEntrega_pedido`,`estado_pedido`,`fechaEvaluacion_pedido`,`comentarioevaluacion_pedido`) VALUES 
 (3,1,'observacion','Abastecimiento',NULL,'2013-08-01 02:24:46','2013-08-02','Aprobado',NULL,'okkkk dkdkwelkmlkvslkmvsmlfvmvmfsmvmvsmsdvmkmkllllllkm'),
 (4,1,'Gutsabo anonio correa caja felix','Abastecimiento',NULL,'2013-08-01 02:43:46','2013-08-01','Aprobada',NULL,NULL),
 (5,1,'njhdhdllll kkk','Prestamo','2013-08-02','2013-08-01 12:06:51','2013-08-01','Aprobado','2013-08-15 15:56:43','ok no!'),
 (6,1,'valida la obsd ok!','Prestamo','2013-08-09','2013-08-01 12:37:26','2013-08-01','Desaprobado',NULL,'lo sentimos no tenemos stocck del producto!'),
 (7,1,'','Abastecimiento',NULL,'2013-08-01 12:40:04','2013-08-02','Aprobado','2013-08-15 15:56:23','ya chapalo velocidad 200!'),
 (8,1,'','Abastecimiento',NULL,'2013-08-01 12:42:19','2013-08-16','Aprobado','2013-08-15 15:56:00','ya camos1'),
 (9,1,'iok lo nesieto para ahora','Abastecimiento',NULL,'2013-08-14 16:19:45','2013-08-14','Atentido','2013-08-14 16:20:15','ok!'),
 (10,1,'lo neseisto ya ok!','Abastecimiento',NULL,'2013-08-14 23:11:05','2013-08-15','Atentido','2013-08-14 23:12:06','ya esta bien señor!'),
 (11,1,'ok!','Abastecimiento',NULL,'2013-08-15 14:33:05','2013-08-15','Aprobado','2013-08-15 14:38:38','vamoes'),
 (12,1,'ok!','Abastecimiento',NULL,'2013-08-15 16:03:40','2013-08-15','Sin Atender',NULL,NULL),
 (13,1,'ddd','Abastecimiento',NULL,'2013-08-15 16:04:42','2013-08-16','Sin Atender',NULL,NULL),
 (14,1,'ok! maluco','Abastecimiento',NULL,'2013-08-15 16:05:12','2013-08-15','Sin Atender',NULL,NULL),
 (15,1,'niegas amor','Abastecimiento',NULL,'2013-08-15 16:05:43','2013-08-15','Sin Atender',NULL,NULL),
 (16,1,'k ','Abastecimiento',NULL,'2013-08-15 16:06:38','2013-08-16','Sin Atender',NULL,NULL),
 (17,1,'des','Abastecimiento',NULL,'2013-08-15 16:07:10','2013-08-15','Sin Atender',NULL,NULL),
 (18,1,'d','Abastecimiento',NULL,'2013-08-15 16:07:31','2013-08-15','Sin Atender',NULL,NULL);
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
  CONSTRAINT `tb_pedido_detalle_ibfk_2` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`),
  CONSTRAINT `tb_pedido_fk_cod_pedido` FOREIGN KEY (`cod_solicitudPedido`) REFERENCES `tb_pedido` (`cod_solicitudPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido_detalle`
--

/*!40000 ALTER TABLE `tb_pedido_detalle` DISABLE KEYS */;
INSERT INTO `tb_pedido_detalle` (`cod_detallePedido`,`cod_solicitudPedido`,`cod_producto`,`cantidad`) VALUES 
 (1,3,72,21),
 (2,4,72,21),
 (3,5,71,2),
 (4,6,72,21),
 (5,6,71,43),
 (6,7,71,21),
 (7,8,72,21),
 (8,8,71,17),
 (9,9,73,4),
 (10,10,75,21),
 (11,10,79,3),
 (12,10,76,32),
 (13,10,65,32),
 (14,11,69,12),
 (15,12,76,22),
 (16,12,73,11),
 (17,12,75,4),
 (18,13,73,1),
 (19,13,69,1),
 (20,13,77,1),
 (21,13,79,1),
 (22,14,72,2),
 (23,14,71,2),
 (24,15,78,2),
 (25,15,73,2),
 (26,16,72,1),
 (27,16,73,13),
 (28,16,65,13),
 (29,17,79,4),
 (30,17,77,4),
 (31,17,76,4),
 (32,18,74,2);
/*!40000 ALTER TABLE `tb_pedido_detalle` ENABLE KEYS */;


--
-- Definition of table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
CREATE TABLE `tb_producto` (
  `cod_producto` int(11) NOT NULL AUTO_INCREMENT,
  `desc_producto` varchar(45) DEFAULT NULL,
  `unidadMedida` varchar(45) DEFAULT NULL,
  `stock_producto` int(11) DEFAULT '0',
  `habilitado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_producto`),
  UNIQUE KEY `desc_producto_umedidad_UNIQUE` (`desc_producto`,`unidadMedida`),
  KEY `fk_unidadMedida` (`unidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto`
--

/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` (`cod_producto`,`desc_producto`,`unidadMedida`,`stock_producto`,`habilitado`) VALUES 
 (65,'producto1','Unidad',368,'Habilitado'),
 (67,'Celular','Unidad',0,'Desabilitado'),
 (69,'Celular','Docena',0,'Habilitado'),
 (71,'dddsss','Unidad',600,'Habilitado'),
 (72,'ddeqad','Unidad',600,'Habilitado'),
 (73,'Silla','Unidad',17,'Habilitado'),
 (74,'Sillas de Plastico','Unidad',13,'Habilitado'),
 (75,'Televisor','Unidad',29,'Habilitado'),
 (76,'Radio','Unidad',745,'Habilitado'),
 (77,'Laptop','Unidad',10,'Habilitado'),
 (78,'Libro','Unidad',0,'Habilitado'),
 (79,'Caja Registradora','Unidad',774,'Habilitado');
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;


--
-- Definition of table `tb_producto_proveedor`
--

DROP TABLE IF EXISTS `tb_producto_proveedor`;
CREATE TABLE `tb_producto_proveedor` (
  `cod_producto_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `cod_producto` int(11) DEFAULT NULL,
  `cod_proveedor` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_producto_proveedor`),
  UNIQUE KEY `fk_codproveedor_codproducot_unicos` (`cod_producto`,`cod_proveedor`),
  KEY `fk_codproducto_producto_idx` (`cod_producto`),
  KEY `fk_codproveedor_proveedor_idx` (`cod_proveedor`),
  CONSTRAINT `fk_codproducto_producto` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_codproveedor_proveedor` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto_proveedor`
--

/*!40000 ALTER TABLE `tb_producto_proveedor` DISABLE KEYS */;
INSERT INTO `tb_producto_proveedor` (`cod_producto_proveedor`,`cod_producto`,`cod_proveedor`) VALUES 
 (13,NULL,NULL),
 (11,65,18),
 (3,65,24),
 (1,71,18),
 (5,73,19),
 (4,74,19),
 (6,75,24),
 (7,76,19),
 (8,77,19),
 (9,78,19),
 (14,78,24),
 (10,79,19);
/*!40000 ALTER TABLE `tb_producto_proveedor` ENABLE KEYS */;


--
-- Definition of table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
CREATE TABLE `tb_proveedor` (
  `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `raz_social` varchar(150) NOT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `correo` varchar(45) NOT NULL,
  `habilitado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`),
  UNIQUE KEY `raz_social_UNIQUE` (`raz_social`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_proveedor`
--

/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
INSERT INTO `tb_proveedor` (`cod_proveedor`,`raz_social`,`ruc`,`telefono`,`correo`,`habilitado`) VALUES 
 (18,'Prueba','6677777776','ju','jjjj','Habilitado'),
 (19,'Corporacion Wong','10457205550','540-233232','gcorregeek@gmail.com','Habilitado'),
 (24,'Gcorreageek SAC','','','gcorregeek@gmail.com','Habilitado'),
 (25,'Guti','','','gcorregeek@gmail.com','Habilitado'),
 (26,'Cibertec','','','gcorregeek@gmail.com','Habilitado'),
 (27,'UPC','','','gcorregeek@gmail.com','Habilitado'),
 (28,'Corporacion Coca Cola','','','gcorregeek@gmail.com','Habilitado'),
 (29,'Corporacion Lindley','','','gcorregeek@gmail.com','Habilitado'),
 (30,'Corporacion Pepsi','','','gcorregeek@gmail.com','Habilitado'),
 (31,'Corporacion KR','','','gcorregeek@gmail.com','Habilitado'),
 (32,'Topy Top SAC','','','gcorregeek@gmail.com','Habilitado'),
 (33,'Esto es Guerra SAC','','','gcorregeek@gmail.com','Habilitado'),
 (34,'Combate EIRL','','','gcorregeek@gmail.com','Habilitado'),
 (35,'Donofrio Peru','','','gcorregeek@gmail.com','Habilitado');
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;


--
-- Definition of table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
CREATE TABLE `tb_usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_usuario` varchar(45) DEFAULT NULL,
  `correo_usuario` varchar(200) DEFAULT NULL,
  `cod_cargo` int(11) NOT NULL,
  `usu_usuario` varchar(200) DEFAULT NULL,
  `pass_usuario` varchar(150) DEFAULT NULL,
  `habilitado` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  UNIQUE KEY `usu_usuario_UNIQUE` (`usu_usuario`),
  KEY `fk_cargo` (`cod_cargo`),
  CONSTRAINT `tb_usuario_fk_cod_cargo` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COMMENT='Habilitado para acceso al sistema';

--
-- Dumping data for table `tb_usuario`
--

/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` (`cod_usuario`,`nom_usuario`,`correo_usuario`,`cod_cargo`,`usu_usuario`,`pass_usuario`,`habilitado`) VALUES 
 (1,'Administrador','gcorreageek@gmail.com',1,'gcorreageek','aa743a0aaec8f7d7a1f01442503957f4d7a2d634','Habilitado'),
 (2,'Gustavo','gcorreageek@gmail.com',29,'gcorreageek1',NULL,'Habilitado'),
 (4,'Gustavo','gcorreageek@gmail.com',1,'gcorreacaja',NULL,'Habilitado'),
 (6,'Gustavo','ddddjj',28,'gcorreacaja1',NULL,'Desabilitado'),
 (8,'gustavo','gcorreageek@gmail.com',29,'nn9','8cb2237d0679ca88db6464eac60da96345513964','Desabilitado'),
 (9,'Gustavo','ggg',27,'gcorreageek4','aa743a0aaec8f7d7a1f01442503957f4d7a2d634','Habilitado'),
 (10,'gustavo','gcorreageek@gmail.com',29,'gcorreageek67','aa743a0aaec8f7d7a1f01442503957f4d7a2d634','Habilitado'),
 (11,'Gustavo','gcorreageek@gmail.com',1,'gcorreageek98','8cb2237d0679ca88db6464eac60da96345513964','Habilitado'),
 (12,'Gustavo','gcorreageek@gmail.com',22,'gcorreageek122','f7c3bc1d808e04732adf679965ccc34ca7ae3441','Habilitado'),
 (13,'Gustavo','gcorreageek@gmail.com',29,'nn12','da39a3ee5e6b4b0d3255bfef95601890afd80709','Habilitado'),
 (14,'Gustavo','gcorreageek@gmail.com',29,'gcorreageek1234','8cb2237d0679ca88db6464eac60da96345513964','Habilitado'),
 (15,'Gustavo','gcorreageek@gmail.com',1,'vamos per','7c4a8d09ca3762af61e59520943dc26494f8941b','Desabilitado');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
