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

import com.almacen.prototipos.principal.MenuPrincipal;

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
public class ProductoNuevo_JDialog extends JDialog implements ActionListener {
	MenuPrincipal objMenuP;
	 private JButton btnListar;
	String titulo2[]={"CODIGO","MARCA"};
	int veces=0;
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 private JButton jButton1;
	 private JButton btnNuevaMarca;
	 private JLabel jLabel1;
	 private JComboBox cboMarca;
	 private JButton btnNuevaUMedida;
	 private JComboBox jComboBox1;
	 private JLabel jLabel2;
	 private JLabel lblMarca;
	 private JTextField txtMarca;
	 public static String  COD_PROD,NOM_PROD,NOM_MAR;
//	 TranProducto objProd;
	 String NOMBREPROD;

	 public ProductoNuevo_JDialog(Frame padre) {
		 // padre y modal
	    super( (Frame)padre, true);

	    try{
	    	getContentPane().setLayout(null);

			//pnlArriba.setLayout(pnlArribaLayout);
			{
				btnListar = new JButton();
				getContentPane().add(btnListar);
				btnListar.setText("Guardar");
				btnListar.setBounds(109, 94, 90, 21);
				btnListar.addActionListener(this);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Cancelar");
				jButton1.setBounds(204, 94, 90, 21);
				jButton1.addActionListener(this);
			}
			{
				txtMarca = new JTextField();
				getContentPane().add(txtMarca);
				txtMarca.setBounds(101, 14, 399, 25);
			}
			{
				lblMarca = new JLabel();
				getContentPane().add(lblMarca);
				lblMarca.setText("Producto:");
				lblMarca.setBounds(13, 12, 115, 25);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("U.Medida:");
				jLabel2.setBounds(12, 64, 115, 25);
			}
			{
				ComboBoxModel cboMarcaModel = 
						new DefaultComboBoxModel(
								new String[] { "SELECCIONAR", "3M","MICROSOFT","ORACLE" });
						
				cboMarca = new JComboBox();
				getContentPane().add(cboMarca);
				cboMarca.setModel(cboMarcaModel);
				cboMarca.setBounds(102, 40, 199, 24);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Marca:");
				jLabel1.setBounds(12, 38, 115, 25);
			}
			{
				ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "SELECCIONAR", "UND","CAJA","DOCENA","MILLAR" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(103, 64, 199, 24);
			}
			{
				btnNuevaMarca = new JButton();
				getContentPane().add(btnNuevaMarca);
				btnNuevaMarca.setText("Nueva Marca");
				btnNuevaMarca.setBounds(313, 41, 138, 23);
				btnNuevaMarca.addActionListener(this);
			}
			{
				btnNuevaUMedida = new JButton();
				getContentPane().add(btnNuevaUMedida);
				btnNuevaUMedida.setText("Nueva U.Medida");
				btnNuevaUMedida.setBounds(314, 69, 137, 23);
				btnNuevaUMedida.addActionListener(this);
			}

			//			txtNombre.setText(objProd.NOMBRE_PROD);

			this.setSize(526, 159);
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
		if(e.getSource()==btnNuevaMarca){
			MarcaNueva_JDialog marcaNueva = new MarcaNueva_JDialog(objMenuP);
			marcaNueva.setVisible(true);
			marcaNueva.pack();
		}
		if(e.getSource()==btnNuevaUMedida){
			UMedidaNueva_JDialog umedidaNueva = new UMedidaNueva_JDialog(objMenuP);
			umedidaNueva.setVisible(true);
			umedidaNueva.pack();
		}
		
	}
	
	 
}
