package com.almacen.prototipos.busquedas;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

import com.almacen.prototipos.mantenimientos.DetalleProductoNuevo_JDialog;
import com.almacen.prototipos.mantenimientos.ProductoNuevo_JDialog;
import com.almacen.prototipos.mantenimientos.ProveedorNuevo_JDialog;
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
public class BuscarCotizacionListado_JDialog extends JDialog implements  ActionListener, MouseListener {
//	MenuPrincipal objMenuP;
	private JLabel jLabel5;
	private JComboBox cboCargo;
	private JLabel lblCargo;
	private JComboBox cboArea;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JLabel jLabel4;
	private JLabel jLabel1;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;
	private JLabel jLabel2;
	private JButton btnBuscar;
	private JScrollPane scrLista;

	String cod_mar,nom_mar;
	private JTable jTable1;
	String titulo2[]={"FECHA","AREA","RESPONSABLE","CARGO"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public BuscarCotizacionListado_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(778, 335));
			this.setBounds(0, 0, 778, 335);
//			this.setVisible(true);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					scrLista = new JScrollPane();
					pnlPrincipal.add(scrLista);
					scrLista.setBounds(0, 101, 758, 186);
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
					btnBuscar.setBounds(501, 38, 154, 21);
					btnBuscar.addActionListener(this);
				}
				{
					jLabel2 = new JLabel();
					pnlPrincipal.add(jLabel2);
					jLabel2.setText("Responsable:");
					jLabel2.setBounds(6, 65, 89, 22);
				}
				{
					jLabel1 = new JLabel();
					pnlPrincipal.add(jLabel1);
					jLabel1.setText("Fecha Inicio:");
					jLabel1.setBounds(6, 37, 90, 18);
				}
				{
					jLabel4 = new JLabel();
					pnlPrincipal.add(jLabel4);
					jLabel4.setText("Fecha Fin:");
					jLabel4.setBounds(236, 39, 78, 18);
				}
				{
					jTextField2 = new JTextField();
					pnlPrincipal.add(jTextField2);
					jTextField2.setBounds(96, 37, 130, 23);
				}
				{
					jTextField3 = new JTextField();
					pnlPrincipal.add(jTextField3);
					jTextField3.setBounds(301, 37, 142, 23);
				}
				{
					jTextField4 = new JTextField();
					pnlPrincipal.add(jTextField4);
					jTextField4.setBounds(95, 66, 265, 23);
				}
				{
					jLabel5 = new JLabel();
					pnlPrincipal.add(jLabel5);
					jLabel5.setText("Area:");
					jLabel5.setBounds(540, 66, 39, 22);
				}
				{
					ComboBoxModel cboAreaModel = 
							new DefaultComboBoxModel(
									new String[] { "SELECCIONAR", "RRHH","LOGISTICA" });
					cboArea = new JComboBox();
					pnlPrincipal.add(cboArea);
					cboArea.setModel(cboAreaModel);
					cboArea.setBounds(591, 66, 109, 23);
				}
				{
					lblCargo = new JLabel();
					pnlPrincipal.add(lblCargo);
					lblCargo.setText("Cargo:");
					lblCargo.setBounds(365, 69, 49, 16);
				}
				{
					ComboBoxModel cboCargoModel = 
							new DefaultComboBoxModel(
									new String[] { "Seleccionar", "Jefe","Asistente" });
					cboCargo = new JComboBox();
					pnlPrincipal.add(cboCargo);
					cboCargo.setModel(cboCargoModel);
					cboCargo.setBounds(413, 66, 122, 23);
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
			if(btnBuscar==e.getSource()){ 
				Object[]  arrObj={"25/05/2013","Almacen","Antonia Del Rua","Jefe"};
				modelo2.addRow(arrObj);
			}
			
		}


		@Override
		public void mouseClicked(MouseEvent e) { }

		@Override
		public void mousePressed(MouseEvent e) {
			if(jTable1==e.getSource() && e.getClickCount()==2){
				this.setVisible(false);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) { }

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) { }

		 

}
