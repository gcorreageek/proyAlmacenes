package com.almacen.prototipos.busquedas;
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
public class BuscarProducto extends JDialog implements ActionListener {
	private JTextField txtNombre;
	private JPanel pnlArriba;
	private JButton btnBuscar;
	private JLabel lblNombre;
	private JTable tblProducto;
	private JScrollPane scrProducto;

	 private JButton btnListar;
	String titulo2[]={"COD_PROD","NOM_PROD","OBS_PROD"};
	int veces=0;
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public static String  COD_PROD,NOM_PROD,NOM_MAR;
	 private JPanel pnlMedio;
	 private JButton btnCancelar;
	 private JButton btnAceptar;
	 private JPanel pnlAbajo;
//	 TranProducto objProd;
	 String NOMBREPROD;

	 public BuscarProducto(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);

	    try{
			pnlArriba = new JPanel();

			pnlMedio = new JPanel();

			pnlAbajo = new JPanel();
			getContentPane().add(pnlAbajo, BorderLayout.SOUTH);
			pnlAbajo.setBounds(0, 303, 751, 28);

			btnAceptar = new JButton();
			pnlAbajo.add(btnAceptar);
			btnAceptar.setText("Aceptar");
			btnAceptar.setPreferredSize(new java.awt.Dimension(107, 21));
			btnAceptar.addActionListener(this);

			btnCancelar = new JButton();
			pnlAbajo.add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setPreferredSize(new java.awt.Dimension(107, 21));
			btnCancelar.addActionListener(this);

			getContentPane().add(pnlMedio, BorderLayout.CENTER);
			GridLayout pnlMedioLayout = new GridLayout(1, 1);
			pnlMedioLayout.setHgap(5);
			pnlMedioLayout.setVgap(5);
			pnlMedioLayout.setColumns(1);
			pnlMedio.setLayout(pnlMedioLayout);
			pnlMedio.setBounds(0, 74, 748, 229);
			pnlMedio.setPreferredSize(new java.awt.Dimension(788, 293));

			scrProducto = new JScrollPane();
			pnlMedio.add(scrProducto);
			scrProducto.setBounds(19, 73, 718, 247);

			tblProducto = new JTable();
			scrProducto.setViewportView(tblProducto);
			tblProducto.setModel(modelo2);

			getContentPane().add(pnlArriba, BorderLayout.NORTH);
			//pnlArriba.setLayout(pnlArribaLayout);
			pnlArriba.setBounds(0, 0, 748, 74);

			lblNombre = new JLabel();
			pnlArriba.add(lblNombre);
			lblNombre.setText("Nombre:");
			lblNombre.setBounds(21, 12, 53, 14);
			lblNombre.setPreferredSize(new java.awt.Dimension(71, 14));

			txtNombre = new JTextField();
			pnlArriba.add(txtNombre);
			txtNombre.setBounds(79, 9, 450, 21);
			txtNombre.setPreferredSize(new java.awt.Dimension(489, 21));
//			txtNombre.setText(objProd.NOMBRE_PROD);

			btnBuscar = new JButton();
			pnlArriba.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(192, 36, 108, 26);
			btnBuscar.setPreferredSize(new java.awt.Dimension(95, 21));

			btnListar = new JButton();
			pnlArriba.add(btnListar);
			btnListar.setText("Listar");
			btnListar.setBounds(326, 35, 101, 27);
			btnListar.setPreferredSize(new java.awt.Dimension(74, 21));
			btnListar.addActionListener(this);

			btnBuscar.addActionListener(this);


			this.setSize(781, 425);
			//cargarMarcas();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	 
	/********PARA CARGAR LOS DATOS DEL TABLA********/
	public void cargarProducto(){
		//Obtener fila seleccionada de la tabla
		int fila = tblProducto.getSelectedRow();
		System.out.println(modelo2.getValueAt(fila, 0));
		int cod=  Integer.parseInt(""+modelo2.getValueAt(fila, 0));
		COD_PROD=String.valueOf(cod);
		//String titulo2[]={"COD_PROD","NOM_PROD","COD_MAR","NOM_MAR","UMED_PROD","OBS_PROD"};
		  NOM_PROD=(String)modelo2.getValueAt(fila, 1);
		txtNombre.setText(NOM_PROD);/*
		String cod_mar=(String) modelo2.getValueAt(fila, 2),nom_mar=(String)modelo2.getValueAt(fila, 3);
		NOM_MAR=nom_mar+"-"+cod_mar;
		cboMarca.setSelectedItem(NOM_MAR);*/
	} 
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==btnAceptar){
			cargarProducto();
			setVisible(false);
		}
		if(e.getSource()==btnCancelar){
			COD_PROD=null;
			setVisible(false);
		}
	}


}
