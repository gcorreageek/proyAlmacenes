package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
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
public class DetalleProductoNuevo_JDialog extends JDialog implements  ActionListener {
	MenuPrincipal objMenuP;
	private JTextField jTextField4;
	private JLabel jLabel4;
	private JButton jButton2;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JButton jButton1;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JPanel pnlPrincipal;
	private JLabel jLabel1;
	private JButton btnIngreso;
	private JLabel lblMarca;
	private JTextField txtMarca;

	String cod_mar,nom_mar;

	String titulo2[]={"CODIGO","PRODUCTO","MARCA","UMEDIDA"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 private JButton btnNuevaMarca;
	 public DetalleProductoNuevo_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(448, 220));
			this.setBounds(0, 0, 448, 220);

			pnlPrincipal = new JPanel();
			pnlPrincipal.setLayout(null);
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(440, 188));

			txtMarca = new JTextField();
			pnlPrincipal.add(txtMarca);
			txtMarca.setBounds(76, 8, 357, 21); 
			txtMarca.setEditable(false);

			lblMarca = new JLabel();
			pnlPrincipal.add(lblMarca);
			lblMarca.setText("Producto:");
			lblMarca.setBounds(12, 12, 64, 14);

			btnIngreso = new JButton();
			pnlPrincipal.add(btnIngreso);
			btnIngreso.setText("Guardar");
			btnIngreso.setBounds(48, 147, 89, 21);
			btnIngreso.addActionListener(this);

			{
				jLabel1 = new JLabel();
				pnlPrincipal.add(jLabel1);
				jLabel1.setText("Marca:");
				jLabel1.setBounds(12, 38, 64, 14);
			}
			{
				btnNuevaMarca = new JButton();
				pnlPrincipal.add(btnNuevaMarca);
				btnNuevaMarca.setText("Buscar Producto");
				btnNuevaMarca.setBounds(280, 34, 128, 23);
				btnNuevaMarca.addActionListener(this);
			}
			{
				jLabel2 = new JLabel();
				pnlPrincipal.add(jLabel2);
				jLabel2.setText("U.Medida:");
				jLabel2.setBounds(12, 68, 64, 14);
			}
			{
				jLabel3 = new JLabel();
				pnlPrincipal.add(jLabel3);
				jLabel3.setText("Proveedor:");
				jLabel3.setBounds(12, 97, 64, 14);
			}
			{
				jButton1 = new JButton();
				pnlPrincipal.add(jButton1);
				jButton1.setText("Buscar Proveedor");
				jButton1.setBounds(280, 93, 128, 23);
				jButton1.addActionListener(this);
			}
			{
				jTextField1 = new JTextField();
				pnlPrincipal.add(jTextField1);
				jTextField1.setBounds(76, 35, 186, 21); 
				jTextField1.setEditable(false);
			}
			{
				jTextField2 = new JTextField();
				pnlPrincipal.add(jTextField2);
				jTextField2.setBounds(76, 65, 186, 21); 
				jTextField2.setEditable(false);
			}
			{
				jTextField3 = new JTextField();
				pnlPrincipal.add(jTextField3);
				jTextField3.setBounds(76, 94, 186, 21); 
				jTextField3.setEditable(false);
			}
			{
				jButton2 = new JButton();
				pnlPrincipal.add(jButton2);
				jButton2.setText("Cancelar");
				jButton2.setBounds(158, 147, 89, 21);
				jButton2.addActionListener(this);
			}
			{
				jLabel4 = new JLabel();
				pnlPrincipal.add(jLabel4);
				jLabel4.setText("Precio:");
				jLabel4.setBounds(12, 123, 64, 14);
			}
			{
				jTextField4 = new JTextField();
				pnlPrincipal.add(jTextField4); 
				jTextField4.setBounds(76, 120, 89, 21);
			}
//			setVisible(true);
//			pack(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(btnIngreso==e.getSource()){
				this.setVisible(false);
			}
			if(jButton2==e.getSource()){
				this.setVisible(false);
			}
			
			if(btnNuevaMarca==e.getSource()){
				ProductoListado_JDialog productoListado = new ProductoListado_JDialog(objMenuP);
				productoListado.setVisible(true);
				productoListado.pack();
			}
			if(jButton1==e.getSource()){
				ProveedorListado_JDialog proveedorListado = new ProveedorListado_JDialog(objMenuP);
				proveedorListado.setVisible(true);
				proveedorListado.pack();
			}
			
			
			 
			
		}

		 

}
