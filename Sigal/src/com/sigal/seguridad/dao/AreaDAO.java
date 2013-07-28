package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.AreaDTO;

public interface AreaDAO {

	AreaDTO getArea(Integer codarea);
	List<AreaDTO> listarArea(AreaDTO area);
	
}
