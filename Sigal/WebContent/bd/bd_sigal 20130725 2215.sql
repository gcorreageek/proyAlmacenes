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
 

--
-- Definition of table `tb_cotizacion`
--

DROP TABLE IF EXISTS `tb_cotizacion`;
CREATE TABLE `tb_cotizacion` (
  `cod_cotizacion` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(15) DEFAULT NULL,
  `solicitante` varchar(150) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`cod_cotizacion`),
  KEY `fk_solicitante_idx` (`solicitante`),
  CONSTRAINT `fk_solicitante` FOREIGN KEY (`solicitante`) REFERENCES `tb_usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_cotizacion`
--

/*!40000 ALTER TABLE `tb_cotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_cotizacion` ENABLE KEYS */;


--
-- Definition of table `tb_cotizacion_detalle`
--

DROP TABLE IF EXISTS `tb_cotizacion_detalle`;
CREATE TABLE `tb_cotizacion_detalle` (
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

--
-- Dumping data for table `tb_cotizacion_detalle`
--

/*!40000 ALTER TABLE `tb_cotizacion_detalle` DISABLE KEYS */;
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




--
-- Definition of table `tb_ordencompra`
--

DROP TABLE IF EXISTS `tb_ordencompra`;
CREATE TABLE `tb_ordencompra` (
  `cod_OrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) DEFAULT NULL,
  `solicitante` varchar(150) DEFAULT NULL,
  `cod_cotizacion` int(11) NOT NULL,
  PRIMARY KEY (`cod_OrdenCompra`),
  KEY `fk_Orden_Compra_Cotizacion1` (`cod_cotizacion`),
  CONSTRAINT `fk_Orden_Compra_Cotizacion1` FOREIGN KEY (`cod_cotizacion`) REFERENCES `tb_cotizacion` (`cod_cotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra`
--

/*!40000 ALTER TABLE `tb_ordencompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_ordencompra` ENABLE KEYS */;


--
-- Definition of table `tb_ordencompra_detalle`
--

DROP TABLE IF EXISTS `tb_ordencompra_detalle`;
CREATE TABLE `tb_ordencompra_detalle` (
  `cod_DetalleOrdenCompra` int(11) NOT NULL AUTO_INCREMENT,
  `cod_ordenCompra` int(11) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_DetalleOrdenCompra`),
  KEY `fk_ordenCompra` (`cod_ordenCompra`),
  KEY `fk_producto` (`cod_producto`),
  CONSTRAINT `fk_ordenCompra` FOREIGN KEY (`cod_ordenCompra`) REFERENCES `tb_ordencompra` (`cod_OrdenCompra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_producto` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_ordencompra_detalle`
--

/*!40000 ALTER TABLE `tb_ordencompra_detalle` DISABLE KEYS */;
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
  `fechaRespuesta_pedido` date DEFAULT NULL,
  `estado_pedido` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_solicitudPedido`),
  KEY `fk_usuario` (`cod_usuario`),
  CONSTRAINT `tb_pedido_ibfk_1` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido`
--

/*!40000 ALTER TABLE `tb_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_pedido` ENABLE KEYS */;


--
-- Definition of table `tb_pedido_detalle`
--

DROP TABLE IF EXISTS `tb_pedido_detalle`;
CREATE TABLE `tb_pedido_detalle` (
  `cod_detallePedido` int(11) NOT NULL AUTO_INCREMENT,
  `cod_solicitudPedido` char(8) DEFAULT NULL,
  `cod_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`cod_detallePedido`),
  KEY `fk_pedido` (`cod_solicitudPedido`),
  KEY `fk_producto` (`cod_producto`),
  CONSTRAINT `tb_pedido_detalle_ibfk_2` FOREIGN KEY (`cod_producto`) REFERENCES `tb_producto` (`cod_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pedido_detalle`
--

/*!40000 ALTER TABLE `tb_pedido_detalle` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto`
--

 


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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_producto_proveedor`
--

 

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_proveedor`
--

 

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_usuario`
--

 

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
  FROM    (   (   bd_sigal.tb_usuario tb_usuario
               INNER JOIN
                  bd_sigal.tb_perfil tb_perfil
               ON (tb_usuario.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              bd_sigal.tb_cargo tb_cargo
           ON (tb_usuario.cod_cargo = tb_cargo.cod_cargo))
       INNER JOIN
          bd_sigal.tb_area tb_area
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
  FROM bd_sigal.tb_usuario tb_usuario
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
  FROM bd_sigal.tb_area tb_area;
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
  FROM bd_sigal.tb_cargo tb_cargo;
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
  FROM    (   bd_sigal.tb_usuario tb_usuario
           INNER JOIN
              bd_sigal.tb_area tb_area
           ON (tb_usuario.cod_area = tb_area.cod_area))
       INNER JOIN
          bd_sigal.tb_cargo tb_cargo
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
  FROM    (   (   bd_sigal.tb_detalleperfil tb_detalleperfil
               INNER JOIN
                  bd_sigal.tb_perfil tb_perfil
               ON (tb_detalleperfil.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              bd_sigal.tb_menu tb_menu
           ON (tb_detalleperfil.cod_menu = tb_menu.cod_Menu))
       INNER JOIN
          bd_sigal.tb_usuario tb_usuario
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
  FROM    (   (   bd_sigal.tb_detalleperfil tb_detalleperfil
               INNER JOIN
                  bd_sigal.tb_perfil tb_perfil
               ON (tb_detalleperfil.cod_perfil = tb_perfil.cod_perfil))
           INNER JOIN
              bd_sigal.tb_opcionesmenu tb_opcionesmenu
           ON (tb_detalleperfil.cod_opcionesMenu =
                  tb_opcionesmenu.cod_opcionesMenu))
       INNER JOIN
          bd_sigal.tb_usuario tb_usuario
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
  FROM bd_sigal.tb_producto tb_producto
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
  FROM bd_sigal.tb_producto tb_producto
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
  FROM bd_sigal.tb_solicitudpedido tb_solicitudpedido
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
  INTO bd_sigal.tb_detallepedido(cod_solicitudPedido, cod_producto, cantidad)
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
	INSERT INTO bd_sigal.tb_producto(desc_producto,
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
            INSERT INTO bd_sigal.tb_solicitudpedido(cod_solicitudPedido,
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
INSERT INTO bd_sigal.tb_usuario(nom_usuario,
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
