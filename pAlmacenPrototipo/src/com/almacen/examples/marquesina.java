package com.almacen.examples;

import java.awt.*;
import java.applet.*;

public class marquesina extends Applet implements Runnable 
	
{
	public String texto;
	public Color fondo;
	int x=0;
	private boolean entrar;	
	Button pararBT;
	Button suspenderBT;
	Button reanudarBT;
	Thread runner;
	Image fondo1;
	Font fuente= new Font("new Courier",Font.BOLD,12);
	
	public void init()
	{
		entrar=false;
		pararBT = new Button("Matar");
		suspenderBT = new Button("Supender");
		reanudarBT = new Button("Reanudar");
		setBackground(Color.black);
		
		add(pararBT);
		add(suspenderBT);
		add(reanudarBT);
		setFont(fuente);
		texto="Paragimas de Programación";
		fondo1= getImage(getCodeBase(),"La fogata de san juan1.jpg");
						 	
		
	}
	
	public void start()
	{
		if(runner==null)
		{
			runner=new Thread(this);
			runner.start();
		}
	}
	
	public void stop()
	{
		runner = null;
	}
	
	public void pause(int t)
	{
		try{
			Thread.sleep(t);
			}catch(InterruptedException e){}
		
	}
	
	public void run()
	{
		Thread thisThread=Thread.currentThread();
		while (runner == thisThread)
			{
			pause(250);
			repaint();
			}
	}
	
	
	public void paint(Graphics g)
	{
		
		g.setColor(Color.black);
		g.drawString(texto,210,x);	
		x+=10;
		g.setColor(Color.white);
		g.drawString(texto,210,x);
//		g.drawImage(fondo1,0,0,this);
		if(x>350)x=-100;
		
	}
	public void update(Graphics g)
	{
	paint(g);
	}

	
//	public boolean action(Event evt,Object arg)
//	{
//	
//	if(evt.target==pararBT)runner.stop();
//	if(evt.target==suspenderBT)	runner.suspend();
//	if(evt.target==reanudarBT)	runner.resume();
//	return true;
//	}
	

}

