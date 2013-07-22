CREATE DATABASE  IF NOT EXISTS `gcorreageek` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gcorreageek`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: gcorreageek
-- ------------------------------------------------------
-- Server version	5.5.9

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_area`
--

DROP TABLE IF EXISTS `tb_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_area` (
  `cod_area` int(11) NOT NULL,
  `desc_area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_area`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_area`
--

LOCK TABLES `tb_area` WRITE;
/*!40000 ALTER TABLE `tb_area` DISABLE KEYS */;
INSERT INTO `tb_area` VALUES (1,'Almacen'),(2,'Sistemas'),(3,'Logistica'),(4,'Contabilidad');
/*!40000 ALTER TABLE `tb_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cargo` (
  `cod_cargo` int(11) NOT NULL,
  `desc_cargo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo`
--

LOCK TABLES `tb_cargo` WRITE;
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` VALUES (1,'Jefe de Area'),(2,'Asistente de Area');
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_categoria`
--

DROP TABLE IF EXISTS `tb_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_categoria` (
  `cod_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `desc_categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_categoria`
--

LOCK TABLES `tb_categoria` WRITE;
/*!40000 ALTER TABLE `tb_categoria` DISABLE KEYS */;
INSERT INTO `tb_categoria` VALUES (1,'escritorio'),(2,'limpieza');
/*!40000 ALTER TABLE `tb_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contacto`
--

DROP TABLE IF EXISTS `tb_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_contacto` (
  `cod_Contacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(300) DEFAULT NULL,
  `correo` varchar(300) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cod_Contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contacto`
--

LOCK TABLES `tb_contacto` WRITE;
/*!40000 ALTER TABLE `tb_contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cotizacion`
--

DROP TABLE IF EXISTS `tb_cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_cotizacion` (
  `cod_cotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(15) DEFAULT NULL,
  `solicitante` varchar(150) DEFAULT NULL,
  `cod_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`cod_cotizacion`),
  KEY `fk_Cotizacion_Proveedor1` (`cod_proveedor`),
  CONSTRAINT `fk_Cotizacion_Proveedor1` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cotizacion`
--

LOCK TABLES `tb_cotizacion` WRITE;
/*!40000 ALTER TABLE `tb_cotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_informe_externo`
--

DROP TABLE IF EXISTS `tb_detalle_informe_externo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalle_informe_externo` (
  `cod_detalle_informe_externo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_informe_externo` int(11) DEFAULT NULL,
  `cod_detalle_ordencompra` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detalle_informe_externo`),
  KEY `fk_informeext_id_idx` (`cod_informe_externo`),
  KEY `fk_codoc_ext_id_idx` (`cod_detalle_ordencompra`),
  CONSTRAINT `fk_codoc_ext_id` FOREIGN KEY (`cod_detalle_ordencompra`) REFERENCES `tb_detalleordencompra` (`cod_DetalleOrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_informeext_id` FOREIGN KEY (`cod_informe_externo`) REFERENCES `tb_informe_externo` (`cod_informe_externo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_informe_externo`
--

LOCK TABLES `tb_detalle_informe_externo` WRITE;
/*!40000 ALTER TABLE `tb_detalle_informe_externo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalle_informe_externo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalle_informe_interno`
--

DROP TABLE IF EXISTS `tb_detalle_informe_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalle_informe_interno` (
  `cod_detalle_informe_interno` int(11) NOT NULL AUTO_INCREMENT,
  `cod_informe_interno` int(11) DEFAULT NULL,
  `cod_detalle_pedido` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detalle_informe_interno`),
  KEY `fk_informeint_pk_idx` (`cod_informe_interno`),
  KEY `fk_detallepedido_pk_idx` (`cod_detalle_pedido`),
  CONSTRAINT `fk_detallepedido_pk` FOREIGN KEY (`cod_detalle_pedido`) REFERENCES `tb_detallepedido` (`cod_detallePedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_informeint_pk` FOREIGN KEY (`cod_informe_interno`) REFERENCES `tb_informe_interno` (`cod_informe_interno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalle_informe_interno`
--

LOCK TABLES `tb_detalle_informe_interno` WRITE;
/*!40000 ALTER TABLE `tb_detalle_informe_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalle_informe_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detallecontacto`
--

DROP TABLE IF EXISTS `tb_detallecontacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detallecontacto` (
  `cod_detalleContacto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(500) DEFAULT NULL,
  `cod_contacto` int(11) NOT NULL,
  `cod_proveedor` int(11) NOT NULL,
  PRIMARY KEY (`cod_detalleContacto`),
  KEY `fk_Detalle_Contacto_Contacto` (`cod_contacto`),
  KEY `fk_Detalle_Contacto_Proveedor1` (`cod_proveedor`),
  CONSTRAINT `fk_Detalle_Contacto_Contacto` FOREIGN KEY (`cod_contacto`) REFERENCES `tb_contacto` (`cod_Contacto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Contacto_Proveedor1` FOREIGN KEY (`cod_proveedor`) REFERENCES `tb_proveedor` (`cod_proveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detallecontacto`
--

LOCK TABLES `tb_detallecontacto` WRITE;
/*!40000 ALTER TABLE `tb_detallecontacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detallecontacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detallecotizacion`
--

DROP TABLE IF EXISTS `tb_detallecotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detallecotizacion` (
  `cod_detallecotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  `cod_producto` int(11) NOT NULL,
  PRIMARY KEY (`cod_detallecotizacion`),
  KEY `fk_Detalle_Cotizacion_Cotizacion1` (`cod_cotizacion`),
  KEY `fk_Detalle_Cotizacion_Producto1` (`cod_producto`),
  CONSTRAINT `fk_Detalle_Cotizacion_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Cotizacion_Producto1` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detallecotizacion`
--

LOCK TABLES `tb_detallecotizacion` WRITE;
/*!40000 ALTER TABLE `tb_detallecotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detallecotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleordencompra`
--

DROP TABLE IF EXISTS `tb_detalleordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalleordencompra` (
  `cod_DetalleOrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `cod_ordenCompra` int(11) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_DetalleOrdenCompra`),
  KEY `fk_ordenCompra` (`cod_ordenCompra`),
  KEY `fk_producto` (`cod_producto`),
  CONSTRAINT `fk_ordenCompra` FOREIGN KEY (`cod_ordenCompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleordencompra`
--

LOCK TABLES `tb_detalleordencompra` WRITE;
/*!40000 ALTER TABLE `tb_detalleordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detalleordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detallepedido`
--

DROP TABLE IF EXISTS `tb_detallepedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detallepedido` (
  `cod_detallePedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_solicitudPedido` char(8) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detallePedido`),
  KEY `fk_pedido` (`cod_solicitudPedido`),
  KEY `fk_producto` (`cod_producto`),
  CONSTRAINT `tb_detallepedido_ibfk_2` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detallepedido`
--

LOCK TABLES `tb_detallepedido` WRITE;
/*!40000 ALTER TABLE `tb_detallepedido` DISABLE KEYS */;
INSERT INTO `tb_detallepedido` VALUES (15,NULL,1,10),(16,NULL,1,10),(17,NULL,4,10),(18,NULL,1,10),(19,NULL,4,10),(20,NULL,1,10),(21,NULL,4,10),(22,NULL,1,20),(23,NULL,3,20),(24,NULL,4,20),(25,NULL,1,10),(26,NULL,3,10),(27,NULL,1,10),(28,NULL,3,10),(29,NULL,1,10),(30,NULL,3,10),(31,NULL,4,10),(32,'SOL00009',1,20),(33,'SOL00009',3,20),(34,'SOL00009',4,20),(35,'SOL00010',1,10),(36,'SOL00010',3,12),(37,'SOL00010',4,12),(38,'SOL00011',1,10),(39,'SOL00011',3,10),(40,'SOL00011',4,10),(41,'SOL00012',1,10),(42,'SOL00012',3,10),(43,'SOL00012',4,10),(44,'SOL00013',1,10),(45,'SOL00013',3,10);
/*!40000 ALTER TABLE `tb_detallepedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detalleperfil`
--

DROP TABLE IF EXISTS `tb_detalleperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_detalleperfil` (
  `codigo_detalleperfil` int(11) NOT NULL,
  `cod_perfil` int(11) DEFAULT NULL,
  `cod_menu` int(11) DEFAULT NULL,
  `cod_opcionesMenu` int(11) DEFAULT NULL,
  `cod_opcion` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo_detalleperfil`),
  KEY `fk_perfil` (`cod_perfil`),
  KEY `fk_menuOpciones` (`cod_opcionesMenu`),
  KEY `fk_menu` (`cod_menu`),
  CONSTRAINT `fk_menu` FOREIGN KEY (`cod_menu`) REFERENCES `tb_menu` (`cod_Menu`),
  CONSTRAINT `fk_menuOpciones` FOREIGN KEY (`cod_opcionesMenu`) REFERENCES `tb_opcionesmenu` (`cod_opcionesMenu`),
  CONSTRAINT `fk_perfil` FOREIGN KEY (`cod_perfil`) REFERENCES `tb_perfil` (`cod_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detalleperfil`
--

LOCK TABLES `tb_detalleperfil` WRITE;
/*!40000 ALTER TABLE `tb_detalleperfil` DISABLE KEYS */;
INSERT INTO `tb_detalleperfil` VALUES (1,1,1,1,1),(2,1,2,2,2),(3,1,2,3,3),(4,1,5,6,4),(5,1,NULL,NULL,5),(6,1,NULL,NULL,6),(7,1,NULL,NULL,7),(8,1,NULL,NULL,8),(9,1,NULL,NULL,9),(10,1,NULL,NULL,10),(11,1,NULL,NULL,11),(12,1,NULL,NULL,12),(13,1,NULL,NULL,13),(14,1,NULL,NULL,14),(15,1,NULL,NULL,15);
/*!40000 ALTER TABLE `tb_detalleperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_informe_externo`
--

DROP TABLE IF EXISTS `tb_informe_externo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_informe_externo`
--

LOCK TABLES `tb_informe_externo` WRITE;
/*!40000 ALTER TABLE `tb_informe_externo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_externo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_informe_interno`
--

DROP TABLE IF EXISTS `tb_informe_interno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `fk_pedido_inf_int` FOREIGN KEY (`cod_pedido`) REFERENCES `tb_solicitudpedido` (`cod_solicitudPedido`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_inf_int` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='area(salida productos, recepcion de producto devuelto)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_informe_interno`
--

LOCK TABLES `tb_informe_interno` WRITE;
/*!40000 ALTER TABLE `tb_informe_interno` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_informe_interno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_marca`
--

DROP TABLE IF EXISTS `tb_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_marca` (
  `cod_marca` int(11) NOT NULL AUTO_INCREMENT,
  `desc_marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_marca`
--

LOCK TABLES `tb_marca` WRITE;
/*!40000 ALTER TABLE `tb_marca` DISABLE KEYS */;
INSERT INTO `tb_marca` VALUES (1,'Faber-Castell'),(2,'Faber-Castell'),(3,'Navarrete'),(4,'Artesco');
/*!40000 ALTER TABLE `tb_marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu` (
  `cod_Menu` int(11) NOT NULL,
  `desc_Menu` varchar(45) DEFAULT NULL,
  `actionUrl_Menu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_Menu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'Solicitud de Pedidos Internos','SPI.action'),(2,'Solicitud de Pedidos Externos','SPI.action'),(3,'Recepción de Producto','SPI.action'),(4,'Salida  de producto','SPI.action'),(5,'Devolución Interna','SPI.action'),(6,'Devolucion Externa','SPI.action'),(7,'Gestion de Reportes','SPI.action'),(8,'Configuraciones','Mantenimientos.action');
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_opciones`
--

DROP TABLE IF EXISTS `tb_opciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_opciones` (
  `cod_opcion` int(11) NOT NULL AUTO_INCREMENT,
  `nom_opcion` varchar(200) DEFAULT NULL,
  `url_opcion` varchar(200) DEFAULT NULL,
  `icono_opcion` varchar(200) DEFAULT NULL,
  `tipo_opcion` int(11) DEFAULT NULL,
  `id_subopcion` int(11) DEFAULT NULL,
  `orden_opcion` int(11) DEFAULT NULL,
  `master_opcion` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_opcion`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_opciones`
--

LOCK TABLES `tb_opciones` WRITE;
/*!40000 ALTER TABLE `tb_opciones` DISABLE KEYS */;
INSERT INTO `tb_opciones` VALUES (1,'Mantenimientos','#',NULL,1,1,2,1),(2,'Producto','mainProducto',NULL,2,1,3,1),(3,'Proveedor','mainProveedor',NULL,2,1,4,1),(4,'Pedido','#',NULL,1,4,6,1),(5,'Inicio','inicio',NULL,1,5,1,0),(6,'Producto Proveedor','mainProductoProveedor',NULL,2,1,5,1),(7,'Nuevo Pedido','nuevoPedido',NULL,2,4,7,1),(8,'Evaluar Pedido','evaluarPedido',NULL,2,4,8,1),(9,'Cotizacion','mainCotizacion',NULL,1,9,9,0),(10,'Orden de Compra','mainOrdenCompra',NULL,1,10,10,0),(11,'Informe Interno','#',NULL,1,11,11,1),(12,'Entrada','mainInformeInternoEntrada',NULL,2,11,13,1),(13,'Salida','mainInformeInternoSalida',NULL,2,11,12,1),(14,'Informe Externa','#',NULL,1,14,14,1),(15,'Entrada','mainInformeExternoEntrada',NULL,2,14,15,1);
/*!40000 ALTER TABLE `tb_opciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_opcionesmenu`
--

DROP TABLE IF EXISTS `tb_opcionesmenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_opcionesmenu` (
  `cod_opcionesMenu` int(11) NOT NULL,
  `cod_Menu` int(11) DEFAULT NULL,
  `desc_OpcionesMenu` varchar(45) DEFAULT NULL,
  `actionUrl_OpcionesMenu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_opcionesMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_opcionesmenu`
--

LOCK TABLES `tb_opcionesmenu` WRITE;
/*!40000 ALTER TABLE `tb_opcionesmenu` DISABLE KEYS */;
INSERT INTO `tb_opcionesmenu` VALUES (1,1,'Registrar Solicitud de Pedido','registrarSol_Ped'),(2,2,'Registrar Solicitud de Cotizacion','registrarSol_Cot'),(3,2,'Registrar Orden de Compra','registrarOrd_Com'),(4,3,'Registrar Informe de Recepcion de Producto','registraInfRec_Int'),(5,4,'Registrar Informe de Salida de Producto','registraInfSal_Pro'),(6,5,'Registrar Informe de Devolucion Interna','registraInfDev_Int'),(7,6,'Registrar Informe de Devolucion Externa','registraInfDev_Ext'),(8,2,'Evaluar Pedido','evaluar_Ped');
/*!40000 ALTER TABLE `tb_opcionesmenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ordencompra`
--

DROP TABLE IF EXISTS `tb_ordencompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_ordencompra` (
  `cod_OrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) DEFAULT NULL,
  `solicitante` varchar(150) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  PRIMARY KEY (`cod_OrdenCompra`),
  KEY `fk_Orden_Compra_Cotizacion1` (`cod_cotizacion`),
  CONSTRAINT `fk_Orden_Compra_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ordencompra`
--

LOCK TABLES `tb_ordencompra` WRITE;
/*!40000 ALTER TABLE `tb_ordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_ordencompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil`
--

DROP TABLE IF EXISTS `tb_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_perfil` (
  `cod_perfil` int(11) NOT NULL,
  `desc_perfil` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil`
--

LOCK TABLES `tb_perfil` WRITE;
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` VALUES (1,'Administrador del sistema'),(2,'Jefe de area'),(3,'Asistente de area'),(4,'Jefe de almacen'),(5,'Asistente de almacen');
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_producto`
--

DROP TABLE IF EXISTS `tb_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_producto` (
  `cod_producto` int(11) NOT NULL AUTO_INCREMENT,
  `desc_producto` varchar(45) DEFAULT NULL,
  `cod_unidadMedida` int(11) DEFAULT NULL,
  `cod_marca` int(11) DEFAULT NULL,
  `cod_categoria` int(11) DEFAULT NULL,
  `stock_producto` int(11) DEFAULT NULL,
  `estado_producto` char(1) DEFAULT NULL,
  PRIMARY KEY (`cod_producto`),
  KEY `fk_marca` (`cod_marca`),
  KEY `fk_unidadMedida` (`cod_unidadMedida`),
  KEY `tb_producto_ibfk_3` (`cod_categoria`),
  CONSTRAINT `tb_producto_ibfk_1` FOREIGN KEY (`cod_marca`) REFERENCES `tb_marca` (`cod_marca`),
  CONSTRAINT `tb_producto_ibfk_2` FOREIGN KEY (`cod_unidadMedida`) REFERENCES `tb_unidadmedida` (`cod_unidadMedida`),
  CONSTRAINT `tb_producto_ibfk_3` FOREIGN KEY (`cod_categoria`) REFERENCES `tb_categoria` (`cod_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_producto`
--

LOCK TABLES `tb_producto` WRITE;
/*!40000 ALTER TABLE `tb_producto` DISABLE KEYS */;
INSERT INTO `tb_producto` VALUES (1,'lapicero azul',1,1,1,500,'A'),(2,'lapicero rojo',1,1,1,200,'D'),(3,'cuaderno rayado',1,1,1,365,'A'),(4,'cuaderno cuadriculado',1,1,1,260,'A'),(9,'nuevo',1,1,1,NULL,NULL);
/*!40000 ALTER TABLE `tb_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_proveedor`
--

DROP TABLE IF EXISTS `tb_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_proveedor` (
  `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `raz_social` varchar(150) DEFAULT NULL,
  `tipo` varchar(150) DEFAULT NULL,
  `ruc` varchar(15) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`cod_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_proveedor`
--

LOCK TABLES `tb_proveedor` WRITE;
/*!40000 ALTER TABLE `tb_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_solicitudpedido`
--

DROP TABLE IF EXISTS `tb_solicitudpedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_solicitudpedido` (
  `cod_solicitudPedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_usuario` int(11) DEFAULT NULL,
  `comentario_pedido` text,
  `tipo_pedido` varchar(45) DEFAULT NULL,
  `fechaDevolucion_pedido` date DEFAULT NULL,
  `fechaRegistro_pedido` date DEFAULT NULL,
  `fechaRespuesta_pedido` date DEFAULT NULL,
  `estado_pedido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_solicitudPedido`),
  KEY `fk_usuario` (`cod_usuario`),
  CONSTRAINT `tb_solicitudpedido_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_solicitudpedido`
--

LOCK TABLES `tb_solicitudpedido` WRITE;
/*!40000 ALTER TABLE `tb_solicitudpedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_solicitudpedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_unidadmedida`
--

DROP TABLE IF EXISTS `tb_unidadmedida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_unidadmedida` (
  `cod_unidadMedida` int(11) NOT NULL AUTO_INCREMENT,
  `desc_unidadMedida` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_unidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_unidadmedida`
--

LOCK TABLES `tb_unidadmedida` WRITE;
/*!40000 ALTER TABLE `tb_unidadmedida` DISABLE KEYS */;
INSERT INTO `tb_unidadmedida` VALUES (1,'kilo'),(2,'Gramo'),(3,'Metro Lineal'),(4,'Metro Cuadrado'),(5,'Metro Cubico'),(6,'Pieza'),(7,'Cabeza'),(8,'Par'),(9,'Juego'),(10,'Tonelada'),(11,'Barril'),(12,'Decenas'),(13,'Cientos'),(14,'Caja'),(15,'Botella');
/*!40000 ALTER TABLE `tb_unidadmedida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_usuario` varchar(45) DEFAULT NULL,
  `apePat_usuario` varchar(45) DEFAULT NULL,
  `apeMat_usuario` varchar(45) DEFAULT NULL,
  `cod_cargo` int(11) DEFAULT NULL,
  `cod_area` int(11) DEFAULT NULL,
  `id_usuario` varchar(45) DEFAULT NULL,
  `pass_usuario` varchar(150) DEFAULT NULL,
  `cod_perfil` int(11) DEFAULT NULL,
  `estado_usuario` char(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usuario`),
  UNIQUE KEY `ck_uni` (`id_usuario`),
  KEY `fk_cargo` (`cod_cargo`),
  KEY `fk_area` (`cod_area`),
  KEY `fk_perfil` (`cod_perfil`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`cod_cargo`) REFERENCES `tb_cargo` (`cod_cargo`),
  CONSTRAINT `tb_usuario_ibfk_2` FOREIGN KEY (`cod_area`) REFERENCES `tb_area` (`cod_area`),
  CONSTRAINT `tb_usuario_ibfk_3` FOREIGN KEY (`cod_perfil`) REFERENCES `tb_perfil` (`cod_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'david','perez','chate',1,1,'dperez','aa743a0aaec8f7d7a1f01442503957f4d7a2d634',1,'A'),(2,'jose','perez','chate',1,1,'jperez','aa743a0aaec8f7d7a1f01442503957f4d7a2d634',2,'A'),(3,'waldo','gamarra','abarca',1,2,'wgamarra','aa743a0aaec8f7d7a1f01442503957f4d7a2d634',3,'A'),(4,'jorge','anyosa','vergara',1,1,'janyosa','aa743a0aaec8f7d7a1f01442503957f4d7a2d634',4,'A'),(5,'carlos','soria','miranda',1,1,'csoria','aa743a0aaec8f7d7a1f01442503957f4d7a2d634',5,'D'),(40,'joselito','aaa','aaa',2,3,'jose01','7c4a8d09ca3762af61e59520943dc26494f8941b',NULL,'A'),(41,'','','',1,1,'','da39a3ee5e6b4b0d3255bfef95601890afd80709',NULL,'A');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-22  4:38:07
