package com.sigal.informeinterno.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;
import com.sigal.informeinterno.dao.InformeInternoDAO;
import com.sigal.util.Constantes;

public class InformeInternoService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	InformeInternoDAO objInformeInternoDAO = fabrica.getInformeInternoDAO();
	
	public void registrar(InformeInternoDTO objii, List<InformeInternoDetalleDTO> lstIIDet) throws Exception {
		objInformeInternoDAO.registrarII(objii, lstIIDet);
	}
//
//	/**
//	 * @param objInformeInterno
//	 * @param lstIIDet
//	 */
//	public void registrar(InformeInternoDTO objInformeInterno,
//			List<InformeInternoDetalleDTO> lstIIDet) {
//		// TODO Auto-generated method stub
//		
//	} 
	
	

}
