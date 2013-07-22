package com.sigal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;


/**
 * UtilSqlConfig.java retorna conexion con jdbc
 * 
 * @author Gustavo Antonio Correa Caja - gacorrea@synopsis.ws
 * @version 0.0.1 - 18/08/2011 - CuponiumServiceUsuario
 */
public class MySqlDBConn {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:MKYONG";
	private static final String DB_USER = "user";
	private static final String DB_PASSWORD = "password";
	
	private final static Logger logger = Logger.getLogger(MySqlDBConn.class);
	private static Connection dbConnection = null;
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.error("Error de Driver", e);
			throw new RuntimeException();
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
		} catch (SQLException e) {
			logger.error("Error de SQL", e);
			throw new RuntimeException();
		}
	}

	@SuppressWarnings("unused")
	public static Connection getDBConnection() {
		return dbConnection;
	}

}
