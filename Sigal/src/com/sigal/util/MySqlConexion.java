package com.sigal.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlConexion {

	public static SqlSessionFactory getMapper(){
		SqlSessionFactory sqlMapper=null;
		
		{
			String archivo="ConfiguracionIbatis.xml";
			try {
				Reader reader = Resources.getResourceAsReader(archivo);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return sqlMapper;
		}
		
	}
	
	
}
