package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class ProveedorNuevo_JDialog extends JDialog implements ActionListener {
	private JPanel pnlArriba;

	 private JButton btnListar;
	String titulo2[]={"CODIGO","MARCA"};
	int veces=0;
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 private JButton jButton1;
	 private JLabel jLabel5;
	 private JTextField txtMarca;
	 private JLabel lblMarca;
	 private JLabel jLabel1;
	 private JComboBox cboTipoIdentificacion;
	 private JLabel jLabel3;
	 private JTextField jTextField1;
	 private JTextField jTextField2;
	 private JLabel jLabel2;
	 private JLabel jLabel4;
	 private JLabel jLabel6;
	 private JTextField jTextField5;
	 private JTextField jTextField3;
	 private JTextField jTextField4;
	 public static String  COD_PROD,NOM_PROD,NOM_MAR;
//	 TranProducto objProd;
	 String NOMBREPROD;

	 public ProveedorNuevo_JDialog(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);

	    try{
	    	getContentPane().setLayout(null);
			pnlArriba = new JPanel();

			getContentPane().add(pnlArriba, "North");
			//pnlArriba.setLayout(pnlArribaLayout);
			pnlArriba.setBounds(0, 0, 438, 136);
			pnlArriba.setLayout(null);
			{
				jTextField4 = new JTextField();
				pnlArriba.add(jTextField4);
				jTextField4.setBounds(203, 86, 221, 21);
			}
			{
				jLabel5 = new JLabel();
				pnlArriba.add(jLabel5);
				jLabel5.setText("Direccion:");
				jLabel5.setBounds(144, 89, 79, 14);
			}
			{
				jTextField3 = new JTextField();
				pnlArriba.add(jTextField3);
				jTextField3.setBounds(71, 86, 69, 21);
			}
			{
				jTextField5 = new JTextField();
				pnlArriba.add(jTextField5);
				jTextField5.setBounds(71, 110, 259, 21);
			}
			{
				jLabel6 = new JLabel();
				pnlArriba.add(jLabel6);
				jLabel6.setText("Correo:");
				jLabel6.setBounds(12, 113, 79, 14);
			}
			{
				jLabel4 = new JLabel();
				pnlArriba.add(jLabel4);
				jLabel4.setText("Telefono:");
				jLabel4.setBounds(12, 89, 79, 14);
			}
			{
				jLabel2 = new JLabel();
				pnlArriba.add(jLabel2);
				jLabel2.setText("Responsable:");
				jLabel2.setBounds(12, 66, 79, 14);
			}
			{
				jTextField2 = new JTextField();
				pnlArriba.add(jTextField2);
				jTextField2.setBounds(85, 62, 341, 21);
			}
			{
				jTextField1 = new JTextField();
				pnlArriba.add(jTextField1);
				jTextField1.setBounds(276, 32, 150, 21);
			}
			{
				jLabel3 = new JLabel();
				pnlArriba.add(jLabel3);
				jLabel3.setText("Numero:");
				jLabel3.setBounds(223, 38, 79, 14);
			}
			{
				ComboBoxModel cboTipoIdentificacionModel = 
						new DefaultComboBoxModel(
								new String[] { "SELECCIONAR", "ELECTRO BANCAS","DELTRON","" });
				cboTipoIdentificacion = new JComboBox();
				pnlArriba.add(cboTipoIdentificacion);
				cboTipoIdentificacion.setModel(cboTipoIdentificacionModel);
				cboTipoIdentificacion.setBounds(69, 34, 149, 23);
			}
			{
				jLabel1 = new JLabel();
				pnlArriba.add(jLabel1);
				jLabel1.setText("Tipo:");
				jLabel1.setBounds(12, 38, 50, 14);
			}
			{
				lblMarca = new JLabel();
				pnlArriba.add(lblMarca);
				lblMarca.setText("Empresa:");
				lblMarca.setBounds(12, 12, 50, 14);
			}
			{
				txtMarca = new JTextField();
				pnlArriba.add(txtMarca);
				txtMarca.setBounds(69, 9, 357, 21);
			}
			{
				btnListar = new JButton();
				getContentPane().add(btnListar);
				btnListar.setText("Guardar");
				btnListar.setBounds(67, 136, 90, 21);
				btnListar.addActionListener(this);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Cancelar");
				jButton1.setBounds(204, 136, 90, 21);
				jButton1.addActionListener(this);
			}

			//			txtNombre.setText(objProd.NOMBRE_PROD);

			this.setSize(474, 200);
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
