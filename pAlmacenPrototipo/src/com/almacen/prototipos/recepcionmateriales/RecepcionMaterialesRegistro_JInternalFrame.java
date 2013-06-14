package com.almacen.prototipos.recepcionmateriales;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.almacen.prototipos.busquedas.BuscarOCListado_JDialog;
import com.almacen.prototipos.busquedas.BuscarPedidoListado_JDialog;
import com.almacen.prototipos.mantenimientos.DetalleProductoNuevo_JDialog;
import com.almacen.prototipos.mantenimientos.ProductoListado_JDialog;
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
public class RecepcionMaterialesRegistro_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JTextPane txtArea;
	private JScrollPane scrObservacion;
	private JLabel lblObservacion;
	private JTextField txtProveedor;
	private JLabel lblProveedor;
	private JButton jButton2;
	private JTextField jTextField1;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTable jTable3;
	private JScrollPane jScrollPane1;
	private JTextField jTextField4;
	private JLabel lblNropedido;
	private JButton btnCargar;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField txtNroPedido;
	private JLabel lblUMedida;
	private JPanel pnlArriba;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar;
	String titulo1[]={"Cod","Descripcion","Cantidad","Marca","UMedida"}; 
	String titulo2[]={"Cod","Descripcion","Cantidad","Marca","Observacion"}; 
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO",s"DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo1	); 
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo2	);
	 public RecepcionMaterialesRegistro_JInternalFrame() { 
		 super("Recepcion de Materiales", true, true, true, true);
		 try { 
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(727, 411));
			this.setBounds(0, 0, 727, 411);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos del OC"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(12, 37, 710, 196);
					{
						lblUMedida = new JLabel();
						pnlArriba.add(lblUMedida);
						lblUMedida.setText("Nro.OC:");
						lblUMedida.setBounds(12, 23, 78, 14);
					}
					{
						txtNroPedido = new JTextField();
						pnlArriba.add(txtNroPedido);
						txtNroPedido.setBounds(81, 19, 163, 21);
						txtNroPedido.setText("OC01305121234");
					}
					{
						jLabel2 = new JLabel();
						pnlArriba.add(jLabel2);
						jLabel2.setText("Fecha:");
						jLabel2.setBounds(256, 22, 48, 14);
					}
					{
						jTextField2 = new JTextField();
						pnlArriba.add(jTextField2);
						jTextField2.setText("20/05/2013");
						jTextField2.setBounds(304, 19, 74, 21);
					}
					{
						jLabel3 = new JLabel();
						pnlArriba.add(jLabel3);
						jLabel3.setText("Responsable:");
						jLabel3.setBounds(12, 46, 90, 14);
					}
					{
						jTextField3 = new JTextField();
						pnlArriba.add(jTextField3);
						jTextField3.setText("Aguilar Jorgue");
						jTextField3.setBounds(102, 43, 233, 21);
					}
					{
						jLabel4 = new JLabel();
						pnlArriba.add(jLabel4);
						jLabel4.setText("Cargo:");
						jLabel4.setBounds(339, 46, 53, 14);
					}
					{
						jTextField4 = new JTextField();
						pnlArriba.add(jTextField4);
						jTextField4.setText("Jefe de RRHH");
						jTextField4.setBounds(390, 43, 154, 21);
					}
					{
						jScrollPane1 = new JScrollPane();
						pnlArriba.add(jScrollPane1);
						jScrollPane1.setBounds(17, 76, 665, 114);
						{ 
							jTable3 = new JTable();
							jScrollPane1.setViewportView(jTable3);
							jTable3.setModel(modelo2);
						}
						
//						jTable1 = new JTable();
//						scrLista.setViewportView(jTable1);
//						jTable1.setModel(modelo2);
					}
					{
						btnCargar = new JButton();
						pnlArriba.add(btnCargar);
						btnCargar.setText("Cargar");
						btnCargar.setBounds(575, 44, 101, 23);
					}
					{
						lblProveedor = new JLabel();
						pnlArriba.add(lblProveedor);
						lblProveedor.setText("Proveedor:");
						lblProveedor.setBounds(390, 21, 73, 16);
					}
					{
						txtProveedor = new JTextField();
						pnlArriba.add(txtProveedor);
						txtProveedor.setBounds(463, 18, 213, 23);
						txtProveedor.setText("SODIMAC");
					}
				}
				{
					btnGuardar = new JButton();
					pnlPrincipal.add(btnGuardar);
					btnGuardar.setText("Cancelar");
					btnGuardar.setBounds(194, 358, 145, 23);
				}
				{
					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Guardar");
					btnCancelar.setBounds(396, 358, 147, 23);
				}
				{
					lblNropedido = new JLabel();
					pnlPrincipal.add(lblNropedido);
					lblNropedido.setText("Nro.OC:");
					lblNropedido.setBounds(25, 12, 62, 16);
				}
				{
					jTextField1 = new JTextField();
					pnlPrincipal.add(jTextField1);
					jTextField1.setBounds(99, 9, 175, 23);
					jTextField1.setEnabled(false);
					jTextField1.setEditable(false);
				}
				{
					jButton2 = new JButton();
					pnlPrincipal.add(jButton2);
					jButton2.setText("Buscar Orden de Compra");
					jButton2.setBounds(286, 9, 196, 23);
					jButton2.addActionListener(this);
				}
				{
					lblObservacion = new JLabel();
					pnlPrincipal.add(lblObservacion);
					lblObservacion.setText("Observacion:");
					lblObservacion.setBounds(17, 242, 91, 16);
				}
				{
					scrObservacion = new JScrollPane();
					pnlPrincipal.add(scrObservacion);
					scrObservacion.setBounds(105, 241, 582, 111);
					{
						txtArea = new JTextPane();
						scrObservacion.setViewportView(txtArea);
					}
				}
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(729, 501));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(jButton2==e.getSource()){
				BuscarOCListado_JDialog buscarOC = new BuscarOCListado_JDialog(objMenuP);
				buscarOC.setVisible(true);
				buscarOC.pack(); 
			}
//			if(btnBuscarProductos==e.getSource()){
//				ProductoListado_JDialog productoListado = new ProductoListado_JDialog(objMenuP);
//				productoListado.setVisible(true);
//				productoListado.pack(); 
//			}
//			if(btnBuscarPedido==e.getSource()){
//				BuscarPedidoListado_JDialog buscarPedido = new BuscarPedidoListado_JDialog(objMenuP);
//				buscarPedido.setVisible(true);
//				buscarPedido.pack();
//			}
			

			
		}

		 

}
