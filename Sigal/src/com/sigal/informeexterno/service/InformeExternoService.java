package com.sigal.informeexterno.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.informeexterno.dao.InformeExternoDAO;
import com.sigal.util.Constantes;

public class InformeExternoService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	InformeExternoDAO objInformeExternoDAO = fabrica.getInformeExternoDAO();
	
	public Object registrarOrdenCompra(InformeExternoDTO objii, List<InformeExternoDetalleDTO> lstIIDet) throws Exception {
		return objInformeExternoDAO.registrarIE(objii, lstIIDet);
	} 
	
	

}
