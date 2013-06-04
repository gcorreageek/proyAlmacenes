package com.almacen.prototipos.busquedas;
import java.awt.BorderLayout;
import java.awt.Frame;
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
public class BuscarPedidoListado_JDialog extends JDialog implements  ActionListener {
	MenuPrincipal objMenuP;
	private JLabel jLabel5;
	private JComboBox cboArea;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel1;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;
	private JLabel jLabel2;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JButton btnBuscar;
	private JScrollPane scrLista;

	String cod_mar,nom_mar;
	private JTable jTable1;
	String titulo2[]={"NPEDIDO","VERSION","FECHA","RESPONSABLE","AREA","PRIORIDAD","[D]","[S]"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public BuscarPedidoListado_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(778, 335));
			this.setBounds(0, 0, 778, 335);
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
					}
				}
				{
					btnBuscar = new JButton();
					pnlPrincipal.add(btnBuscar);
					btnBuscar.setText("Buscar");
					btnBuscar.setBounds(336, 8, 93, 21);
					btnBuscar.addActionListener(this);
				}
				{
					txtMarca = new JTextField();
					pnlPrincipal.add(txtMarca);
					txtMarca.setBounds(83, 6, 144, 23);
				}
				{
					lblMarca = new JLabel();
					pnlPrincipal.add(lblMarca);
					lblMarca.setText("N.Pedido:");
					lblMarca.setBounds(6, 10, 74, 14);
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
					jLabel3 = new JLabel();
					pnlPrincipal.add(jLabel3);
					jLabel3.setText("Version:");
					jLabel3.setBounds(234, 12, 56, 14);
				}
				{
					jTextField1 = new JTextField();
					pnlPrincipal.add(jTextField1);
					jTextField1.setBounds(285, 7, 39, 23);
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
					jTextField4.setBounds(95, 66, 197, 23);
				}
				{
					jLabel5 = new JLabel();
					pnlPrincipal.add(jLabel5);
					jLabel5.setText("Area:");
					jLabel5.setBounds(297, 69, 39, 22);
				}
				{
					ComboBoxModel cboAreaModel = 
							new DefaultComboBoxModel(
									new String[] { "SELECCIONAR", "RRHH","LOGISTICA" });
					cboArea = new JComboBox();
					pnlPrincipal.add(cboArea);
					cboArea.setModel(cboAreaModel);
					cboArea.setBounds(333, 69, 109, 23);
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
			}
			
		}

		 

}
