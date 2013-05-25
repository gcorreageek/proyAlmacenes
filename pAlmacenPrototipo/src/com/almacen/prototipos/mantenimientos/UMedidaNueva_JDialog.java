package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UMedidaNueva_JDialog extends JDialog implements ActionListener {
	private JTextField txtNombre;
	private JPanel pnlArriba;
	private JLabel lblNombre;

	 private JButton btnListar;
	String titulo2[]={"CODIGO","MARCA"};
	int veces=0;
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 private JButton jButton1;
	 public static String  COD_PROD,NOM_PROD,NOM_MAR;
//	 TranProducto objProd;
	 String NOMBREPROD;

	 public UMedidaNueva_JDialog(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);

	    try{
	    	getContentPane().setLayout(null);
			pnlArriba = new JPanel();

			getContentPane().add(pnlArriba, "North");
			//pnlArriba.setLayout(pnlArribaLayout);
			pnlArriba.setBounds(0, 0, 394, 31);
			{
				btnListar = new JButton();
				getContentPane().add(btnListar);
				btnListar.setText("Guardar");
				btnListar.setBounds(166, 29, 90, 21);
				btnListar.addActionListener(this);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Cancelar");
				jButton1.setBounds(261, 29, 90, 21);
				jButton1.addActionListener(this);
			}

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("U.Medida:");
			lblNombre.setBounds(21, 12, 53, 14);
			lblNombre.setPreferredSize(new java.awt.Dimension(89, 14));

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(79, 9, 450, 21);
			txtNombre.setPreferredSize(new java.awt.Dimension(247, 21));
			//			txtNombre.setText(objProd.NOMBRE_PROD);

			this.setSize(382, 100);
			//cargarMarcas();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	 
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	 
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnListar){
//			cargarProducto();
			setVisible(false);
		}
		if(e.getSource()==jButton1){
			COD_PROD=null;
			setVisible(false);
		}
	}
	
	 
}
