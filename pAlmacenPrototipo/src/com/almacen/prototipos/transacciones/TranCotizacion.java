package com.almacen.prototipos.transacciones;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
public class TranCotizacion extends JInternalFrame implements  ActionListener {
	private JPanel pnlPrincipal;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JScrollPane scrLista;
	private JButton btnModificar;
	private JButton btnIngreso;
	private JLabel lblMarca;
	private JTextField txtMarca;

	String cod_mar,nom_mar;
	private JTable jTable1;

	 
	String titulo2[]={"COD_MARCA","NOM_MARCA"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public TranCotizacion() { 
		super("Mant Marca", true, true, true, true);
		try {
			
			this.setPreferredSize(new java.awt.Dimension(434, 276));
			this.setBounds(0, 0, 434, 276);

			pnlPrincipal = new JPanel();
			pnlPrincipal.setLayout(null);
			getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
			pnlPrincipal.setPreferredSize(new java.awt.Dimension(359, 255));

			txtMarca = new JTextField();
			pnlPrincipal.add(txtMarca);
			txtMarca.setBounds(69, 9, 357, 21);

			lblMarca = new JLabel();
			pnlPrincipal.add(lblMarca);
			lblMarca.setText("Marca:");
			lblMarca.setBounds(12, 12, 50, 14);

			btnIngreso = new JButton();
			pnlPrincipal.add(btnIngreso);
			btnIngreso.setText("Ingreso");
			btnIngreso.setBounds(12, 38, 89, 21);
			btnIngreso.addActionListener(this);

			btnModificar = new JButton();
			pnlPrincipal.add(btnModificar);
			btnModificar.setText("Modificar");
			btnModificar.setBounds(112, 38, 91, 21);
			btnModificar.addActionListener(this);

			scrLista = new JScrollPane();
			pnlPrincipal.add(scrLista);
			scrLista.setBounds(7, 64, 419, 179);

			
			jTable1 = new JTable();
			scrLista.setViewportView(jTable1);
			jTable1.setModel(modelo2);

			btnEliminar = new JButton();
			pnlPrincipal.add(btnEliminar);
			btnEliminar.setText("Eliminar");
			btnEliminar.setBounds(224, 38, 93, 21);
			btnEliminar.addActionListener(this);

			btnBuscar = new JButton();
			pnlPrincipal.add(btnBuscar);
			btnBuscar.setText("Buscar");
			btnBuscar.setBounds(328, 38, 93, 21);
			btnBuscar.addActionListener(this);
			setVisible(true);
			pack(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
 

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnIngreso){
//				agregarProducto();
			}
			if(e.getSource()==btnEliminar){
//				eliminarProducto();
			}
			if(e.getSource()==btnModificar){
//				modificarProducto();
			}
			if(e.getSource()==btnBuscar){
//				buscarProducto();
			}
		
		}

		 

}
