package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public class ProveedorListado_JDialog extends JDialog implements  ActionListener, MouseListener {
	MenuPrincipal objMenuP;
	private JTextField jTextField6;
	private JLabel jLabel7;
	private JLabel jLabel1;
	private JComboBox cboTipoIdentificacion;
	private JLabel jLabel3;
	private JTextField jTextField1;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;
	private JButton btnBuscar;
	private JScrollPane scrLista;
	private JButton btnIngreso;

	String cod_mar,nom_mar;
	private JTable jTable1;
 
	String titulo2[]={"COD","EMPRESA","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public ProveedorListado_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(776, 289));
			this.setBounds(0, 0, 776, 289);

			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					btnIngreso = new JButton();
					pnlPrincipal.add(btnIngreso);
					btnIngreso.setText("Nueva Proveedor");
					btnIngreso.setBounds(561, 5, 180, 21);
					btnIngreso.addActionListener(this);
				}
				{
					scrLista = new JScrollPane();
					pnlPrincipal.add(scrLista);
					scrLista.setBounds(0, 60, 758, 186);
					{
						jTable1 = new JTable();
						scrLista.setViewportView(jTable1);
						jTable1.setModel(modelo2);
						jTable1.addMouseListener(this);
					}
				}
				{
					btnBuscar = new JButton();
					pnlPrincipal.add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setBounds(424, 5, 93, 21);
					btnBuscar.addActionListener(this);
				}
				{
					jTextField1 = new JTextField();
					pnlPrincipal.add(jTextField1);
					jTextField1.setBounds(269, 31, 144, 21);
				}
				{
					jLabel3 = new JLabel();
					pnlPrincipal.add(jLabel3);
					jLabel3.setText("Numero:");
					jLabel3.setBounds(215, 34, 79, 14);
				}
				{
					ComboBoxModel cboTipoIdentificacionModel = 
							new DefaultComboBoxModel(
									new String[] { "SELECCIONAR", "DNI","RUC" });
					cboTipoIdentificacion = new JComboBox();
					pnlPrincipal.add(cboTipoIdentificacion);
					cboTipoIdentificacion.setModel(cboTipoIdentificacionModel);
					cboTipoIdentificacion.setBounds(61, 30, 149, 23);
				}
				{
					jLabel1 = new JLabel();
					pnlPrincipal.add(jLabel1);
					jLabel1.setText("Tipo:");
					jLabel1.setBounds(4, 34, 50, 14);
				}
				{
					jLabel7 = new JLabel();
					pnlPrincipal.add(jLabel7);
					jLabel7.setText("Empresa:");
					jLabel7.setBounds(4, 8, 50, 14);
				}
				{
					jTextField6 = new JTextField();
					pnlPrincipal.add(jTextField6);
					jTextField6.setBounds(61, 5, 357, 21);
				}
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(359, 255));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(btnIngreso==e.getSource()){ 
				proveedorNuevo = new  ProveedorNuevo_JDialog(objMenuP);
				proveedorNuevo.setVisible(true);
				proveedorNuevo.pack(); 
			}
			if(e.getSource()==btnBuscar){
				Object[]  obj={"PROVE1101","SODIMAC","RUC","10457205550","Augusto Yeck","540-2606","Mz BBB 2 lt 40","gcorreageek@gmail.com"};
				modelo2.addRow(obj);
			}
		}


		@Override
		public void mouseClicked(MouseEvent e) { }


		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource()==jTable1 && e.getClickCount()==2){
				this.setVisible(false);
			}
		}


		@Override
		public void mouseReleased(MouseEvent e) { }


		@Override
		public void mouseEntered(MouseEvent e) { }


		@Override
		public void mouseExited(MouseEvent e) {  }

		 

}
