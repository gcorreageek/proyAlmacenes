/**
 * InformeExternoDAO 29/07/2013
 */
package com.sigal.informeexterno.dao;

import java.util.List;

import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface InformeExternoDAO {

	Object registrarIE(InformeExternoDTO ie, List<InformeExternoDetalleDTO> ieDet);
}
