/**
 * MySqlOrdenCompraDAO 28/07/2013
 */
package com.sigal.ordencompra.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
 





import com.sigal.ordencompra.bean.OrdenCompraDTO;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlOrdenCompraDAO implements OrdenCompraDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper(); 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDTO> buscarOCPag(OrdenCompraDTO ocViene,
			Integer inicio, Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<OrdenCompraDTO> lstOC = new ArrayList<OrdenCompraDTO>();
		try {
			if (ocViene == null) {
				OrdenCompraDTO ocHere = new OrdenCompraDTO();
				ocHere.setInicio(inicio);
				ocHere.setTamano(tamano);
				lstOC = (List<OrdenCompraDTO>) sesion.selectList(
						"oc.SQL_listaOCPag", ocHere);
			} else { 
				if(!"".equals(ocViene.getNom_usuario())){
					System.out.println("nomsuario");
					ocViene.setNom_usuario("%"+ocViene.getNom_usuario()+"%");
					ocViene.setInicio(inicio);
					ocViene.setTamano(tamano);
					lstOC= (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXNombrePag",ocViene);
				} else if(ocViene.getFechaInicio()!=null   &&  ocViene.getFechaFin()!=null ){
					System.out.println("fechas");
					ocViene.setFechaInicio(ocViene.getFechaInicio());
					ocViene.setFechaFin(ocViene.getFechaFin());
					ocViene.setInicio(inicio);
					ocViene.setTamano(tamano);
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXFechasPag",ocViene);
				} 
			}
		} finally {
			sesion.close();
		}
		return lstOC; 
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDTO> buscarOC(OrdenCompraDTO ocViene)
			throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<OrdenCompraDTO> lstOC = new ArrayList<OrdenCompraDTO>();
		try {
			if (ocViene == null) {
				lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOC");
			} else {
				System.out.println("nomusu:"+ocViene.getNom_usuario()); 
				System.out.println("fecha:"+ocViene.getFechaInicio()+"|"+ocViene.getFechaFin());
				if(!"".equals(ocViene.getNom_usuario())){
					System.out.println("nomsuario");
					ocViene.setNom_usuario("%"+ocViene.getNom_usuario()+"%"); 
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXNombre",ocViene);
				} else if(ocViene.getFechaInicio()!=null  && ocViene.getFechaFin()!=null ){
					System.out.println("fechas");
					ocViene.setFechaInicio(ocViene.getFechaInicio());
					ocViene.setFechaFin(ocViene.getFechaFin()); 
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXFechas",ocViene);
				} 
			}
		}  finally {
			sesion.close();
		}
		return lstOC;
	} 
	@Override
	public Object insertarOC(OrdenCompraDTO oc,
			List<OrdenCompraDetalleDTO> ocDet) throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		try {  
			sesion.insert("oc.SQL_registraOC",oc);
			for (OrdenCompraDetalleDTO  detalleOrdenCompraDTO : ocDet) {  
				detalleOrdenCompraDTO.setCod_ordenCompra(oc.getCod_OrdenCompra());//  
				sesion.insert("ocdetalle.SQL_registraDetalleOC",detalleOrdenCompraDTO);
			} 
			sesion.commit();
		} catch (Exception e) { 
			sesion.rollback(); 
			throw e;
		}finally{
			sesion.close();
		} 
		return null;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDTO> buscarOCPagEntregada(OrdenCompraDTO ocViene,
			Integer inicio, Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<OrdenCompraDTO> lstOC = new ArrayList<OrdenCompraDTO>();
		try {
			if (ocViene == null) {
				OrdenCompraDTO ocHere = new OrdenCompraDTO();
				ocHere.setInicio(inicio);
				ocHere.setTamano(tamano);
				lstOC = (List<OrdenCompraDTO>) sesion.selectList(
						"oc.SQL_listaOCPagEntregada", ocHere);
			} else { 
				if(!"".equals(ocViene.getNom_usuario())){
					System.out.println("nomsuario");
					ocViene.setNom_usuario("%"+ocViene.getNom_usuario()+"%");
					ocViene.setInicio(inicio);
					ocViene.setTamano(tamano);
					lstOC= (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXNombrePagEntregada",ocViene);
				} else if(ocViene.getFechaInicio()!=null   &&  ocViene.getFechaFin()!=null ){
					System.out.println("fechas");
					ocViene.setFechaInicio(ocViene.getFechaInicio());
					ocViene.setFechaFin(ocViene.getFechaFin());
					ocViene.setInicio(inicio);
					ocViene.setTamano(tamano);
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXFechasPagEntregada",ocViene);
				} 
			}
		} finally {
			sesion.close();
		}
		return lstOC; 
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDTO> buscarOCEntregada(OrdenCompraDTO ocViene)
			throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<OrdenCompraDTO> lstOC = new ArrayList<OrdenCompraDTO>();
		try {
			if (ocViene == null) {
				lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCEntregada");
			} else {
				System.out.println("nomusu:"+ocViene.getNom_usuario()); 
				System.out.println("fecha:"+ocViene.getFechaInicio()+"|"+ocViene.getFechaFin());
				if(!"".equals(ocViene.getNom_usuario())){
					System.out.println("nomsuario");
					ocViene.setNom_usuario("%"+ocViene.getNom_usuario()+"%"); 
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXNombreEntregada",ocViene);
				} else if(ocViene.getFechaInicio()!=null  && ocViene.getFechaFin()!=null ){
					System.out.println("fechas");
					ocViene.setFechaInicio(ocViene.getFechaInicio());
					ocViene.setFechaFin(ocViene.getFechaFin()); 
					lstOC = (List<OrdenCompraDTO>) sesion.selectList("oc.SQL_listaOCXFechasEntregada",ocViene);
				} 
			}
		}  finally {
			sesion.close();
		}
		return lstOC;
	}  

}
