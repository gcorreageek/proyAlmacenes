package com.sigal.mantenimiento.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlProductoDAO implements ProductoDAO {

	SqlSessionFactory sqlMapper =MySqlConexion.getMapper();
	
	@Override
	public ArrayList<ProductoDTO> listaProductos() {
		
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<ProductoDTO>  lstProductos = new ArrayList<ProductoDTO>();
		try {
			
			lstProductos = (ArrayList<ProductoDTO>) sesion.selectList("producto.SQL_listaProductos");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		
		
		return lstProductos;
	}

	@Override
	public void registrarProducto(ProductoDTO objProducto) {
		
		SqlSession session = sqlMapper.openSession();
		
		try {
			
				session.insert("producto.SQL_registraProducto",objProducto);
				session.commit();
		} catch (Exception e) {
			System.out.println(e);
			session.close();
		}
		finally{
			session.close();
		}
		
	}

}
