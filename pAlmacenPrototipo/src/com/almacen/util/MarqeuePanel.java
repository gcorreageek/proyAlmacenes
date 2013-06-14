package com.almacen.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarqeuePanel extends JPanel implements Runnable
{
    private boolean IsStoped = false;
    private JLabel label;
    public MarqeuePanel(Dimension d,Point p,String text)
    {
    	
        super();
        label = new JLabel();
        label.setText(text);
        add(label);
        setSize(d);
        setOpaque(false);
        setBackground(new Color(0,0,0,0));
        label.setLocation(0,this.getSize().height);
        Thread t = new Thread(this);
        t.start();
    }
    public static void main(String[] args) {
		
//    	new MarqeuePanel(20, 2, "dds");
	}

    @Override
    public void run() 
    {
        //Marqueue
        label.setLocation(0,this.getSize().height);
        while(!IsStoped)
        {
            if(label.getLocation().y < -label.getSize().height)
            {
                label.setLocation(0,this.getSize().height);
            }
            else
            {
                int x = 0;
                int y = label.getLocation().y - 1;
                label.setLocation(x,y);
            }
            try{Thread.sleep(30);}catch(Exception exc){}
        }
    }

    public void StopMarque()
    {
        IsStoped = true;
    }
}