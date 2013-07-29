/**
 * MySqlCotizacionDAO 28/07/2013
 */
package com.sigal.cotizacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.cotizacion.bean.CotizacionDTO;
import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlCotizacionDAO implements CotizacionDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();

	@Override
	public Object insertarCotizacion(CotizacionDTO coti,
			List<CotizacionDetalleDTO> cotiDet) {
		SqlSession sesion =sqlMapper.openSession();
		try { 
			System.out.println("coti"+coti.getRaz_social());
			sesion.insert("cotizacion.SQL_registraCotizacion",coti);
			for (CotizacionDetalleDTO detallePedidoDTO : cotiDet) { 
				System.out.println("cann:"+detallePedidoDTO.getCant_detallecotizacion());
				detallePedidoDTO.setCod_cotizacion(coti.getCod_cotizacion());//SQL_registraDetalleCotizacion  
				sesion.insert("cotizaciondetalle.SQL_registraDetalleCotizacion",detallePedidoDTO);
			} 
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
			sesion.close();
		}finally{
			sesion.close();
		} 
		return null;
	} 
	@Override
	public List<CotizacionDTO> buscarCotizacionPag(
			CotizacionDTO cotizacionViene, Integer inicio, Integer tamano)
			throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<CotizacionDTO> lstCotizacion = new ArrayList<CotizacionDTO>();
		try {
			if (cotizacionViene == null) {
				CotizacionDTO cotizacionHere = new CotizacionDTO();
				cotizacionHere.setInicio(inicio);
				cotizacionHere.setTamano(tamano);
				lstCotizacion = (List<CotizacionDTO>) sesion.selectList(
						"cotizacion.SQL_listaCotizacionPag", cotizacionHere);
			} else { 
				if(!"".equals(cotizacionViene.getNom_usuario())){
					System.out.println("nomsuario");
					cotizacionViene.setNom_usuario("%"+cotizacionViene.getNom_usuario()+"%");
					cotizacionViene.setInicio(inicio);
					cotizacionViene.setTamano(tamano);
					lstCotizacion= (List<CotizacionDTO>) sesion.selectList("cotizacion.SQL_listaCotizacionXNombrePag",cotizacionViene);
				} else if(cotizacionViene.getFechaInicio()!=null   &&  cotizacionViene.getFechaFin()!=null ){
					System.out.println("fechas");
					cotizacionViene.setFechaInicio(cotizacionViene.getFechaInicio());
					cotizacionViene.setFechaFin(cotizacionViene.getFechaFin());
					cotizacionViene.setInicio(inicio);
					cotizacionViene.setTamano(tamano);
					lstCotizacion = (List<CotizacionDTO>) sesion.selectList("cotizacion.SQL_listaCotizacionXFechasPag",cotizacionViene);
				} 
			}
		} finally {
			sesion.close();
		}
		return lstCotizacion; 
	} 
	@Override
	public List<CotizacionDTO> buscarCotizacion(CotizacionDTO cotizacionViene)
			throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<CotizacionDTO> lstCotizacion = new ArrayList<CotizacionDTO>();
		try {
			if (cotizacionViene == null) {
				lstCotizacion = (List<CotizacionDTO>) sesion.selectList("cotizacion.SQL_listaCotizacion");
			} else {
				System.out.println("nomusu:"+cotizacionViene.getNom_usuario()); 
				System.out.println("fecha:"+cotizacionViene.getFechaInicio()+"|"+cotizacionViene.getFechaFin());
				if(!"".equals(cotizacionViene.getNom_usuario())){
					System.out.println("nomsuario");
					cotizacionViene.setNom_usuario("%"+cotizacionViene.getNom_usuario()+"%"); 
					lstCotizacion = (List<CotizacionDTO>) sesion.selectList("cotizacion.SQL_listaCotizacionXNombre",cotizacionViene);
				} else if(cotizacionViene.getFechaInicio()!=null  && cotizacionViene.getFechaFin()!=null ){
					System.out.println("fechas");
					cotizacionViene.setFechaInicio(cotizacionViene.getFechaInicio());
					cotizacionViene.setFechaFin(cotizacionViene.getFechaFin()); 
					lstCotizacion = (List<CotizacionDTO>) sesion.selectList("cotizacion.SQL_listaCotizacionXFechas",cotizacionViene);
				} 
			}
		}  finally {
			sesion.close();
		}
		return lstCotizacion;
	}

}
