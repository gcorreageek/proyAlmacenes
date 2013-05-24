package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

 
public class MantMarcas extends JInternalFrame implements  ActionListener {
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
	 public MantMarcas() { 
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
			
		}

		 

}
