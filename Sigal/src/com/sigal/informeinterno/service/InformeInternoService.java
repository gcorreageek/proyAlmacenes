package com.sigal.informeinterno.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;

import com.sigal.dao.DAOFactory;
import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;
import com.sigal.informeinterno.dao.InformeInternoDAO;
import com.sigal.util.Constantes;

public class InformeInternoService {
	private final Log log = org.apache.commons.logging.LogFactory.getLog(getClass());
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	InformeInternoDAO objInformeInternoDAO = fabrica.getInformeInternoDAO();
	
	public Object registrar(InformeInternoDTO objii, List<InformeInternoDetalleDTO> lstIIDet) throws Exception {
		return objInformeInternoDAO.registrarII(objii, lstIIDet);
	}
	public List<InformeInternoDTO> lista(InformeInternoDTO objii ) throws Exception { 
		List<InformeInternoDTO> informeInternoLista = new ArrayList<InformeInternoDTO>();
		List<InformeInternoDTO> lst = objInformeInternoDAO.buscaInformeInterno(objii);
		int t = lst.size(); 
		int inicial = 0;
		List<InformeInternoDetalleDTO> detalle = null;
		for (int i = 0; i < t; i++) {
			InformeInternoDTO ii = lst.get(i);
			if(inicial==0){ 
				detalle = new ArrayList<InformeInternoDetalleDTO>();
			}
			inicial=1;
			InformeInternoDetalleDTO iiDetalle = new InformeInternoDetalleDTO();
			iiDetalle.setDesc_producto(ii.getDesc_producto());
			iiDetalle.setUnidadMedida(ii.getUnidadMedida());
			iiDetalle.setCantidad(ii.getCantidad()); 
			detalle.add(iiDetalle); 
			if(i+1<t){//Entra si hay un registro siguiente
				Integer cod = ii.getCod_informe_interno();
				Integer codSiguiente = lst.get(i+1).getCod_informe_interno(); 
				if(cod!=codSiguiente){ 
					inicial = 0;
					ii.setDetalle(detalle);
					informeInternoLista.add(ii);
				}  
			}else{//Este es el ultimo registro
				inicial = 0;
				ii.setDetalle(detalle);
				informeInternoLista.add(ii);
			} 
		} 
		return informeInternoLista;
	}
	public List<InformeInternoDetalleDTO> getDetalle(InformeInternoDTO objii ) throws Exception {
		 List<InformeInternoDetalleDTO> lstDetalle = new ArrayList<InformeInternoDetalleDTO>();
		 List<InformeInternoDTO> lst = objInformeInternoDAO.buscaInformeInterno(objii);
		 for (InformeInternoDTO informeInternoDTO : lst) {
			 InformeInternoDetalleDTO det = new InformeInternoDetalleDTO();
			 det.setCantidad(informeInternoDTO.getCantidad());
			 det.setDesc_producto(informeInternoDTO.getDesc_producto());
			 det.setUnidadMedida(informeInternoDTO.getUnidadMedida());
			 lstDetalle.add(det);
		 } 
		return lstDetalle;
	} 
	
	

}
