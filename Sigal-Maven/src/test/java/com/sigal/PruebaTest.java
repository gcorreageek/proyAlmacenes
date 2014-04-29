package com.sigal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PruebaTest {

	Prueba prueba;
	
	@Before
	public void iniciando(){
		prueba = new Prueba();
	}
	
	
	
	@Test
	public void test() {
//		prueba = new Prueba();
		assertEquals(prueba.saluda(), "Hola Gus!");
	}

}
