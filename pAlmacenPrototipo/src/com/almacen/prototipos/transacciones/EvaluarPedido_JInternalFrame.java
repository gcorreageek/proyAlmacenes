package com.almacen.prototipos.transacciones;
import java.awt.BorderLayout;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
public class EvaluarPedido_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTextField jTextField6;
	private JTextField txtPrioridad2;
	private JButton jButton1;
	private JTable jTable1;
	private JScrollPane jScrollPane2;
	private JTable jTable2;
	private JScrollPane jScrollPane4;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane3;
	private JLabel lblObservacion;
	private JLabel lblPrioridad2;
	private JTextField txtCargo2;
	private JTextField txtFecha2;
	private JLabel lblFecha;
	private JTextField txtVersion;
	private JLabel lblVersion2;
	private JLabel jLabel9;
	private JTextField jTextField5;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JTable jTable3;
	private JScrollPane jScrollPane1;
	private JTextField jTextField4;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JButton btnBuscarPedido;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JCheckBox chkNroPedido;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private JTextField txtNroPedido;
	private JLabel lblUMedida;
	private JTextArea txtAObservacionD;
	private JScrollPane scrObservacionD;
	private JLabel lblObservacionD;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JPanel pnlProducto;
	private JPanel pnlArriba;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar;
	String titulo1[]={"Version","Responsable","Comentario","Eliminar/Seleccionar"};
	String titulo2[]={"ITEM","COD","PRODUCTO","UND","MARCA","CANTIDAD","PRIORIDAD","STOCK M","STOCK","STOCK T","SALIDA","COTIZAR","PRESTAMO"};
	String titulo3[]={"ITEM","COD","PRODUCTO","UND","MARCA","CANTIDAD","PRIORIDAD","STOCK M","STOCK","STOCK T","PRESTADO","EVALUACION","ESTADO/ELIMINAR"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo1	);
	 DefaultTableModel modelo1 =new DefaultTableModel(null,titulo2);
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo3);
	 
	 public EvaluarPedido_JInternalFrame() { 
		 super("Evaluar Pedido", true, true, true, true);
		 try { 
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(1017, 599));
			this.setBounds(0, 0, 1017, 599);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					pnlProducto = new JPanel();
					pnlPrincipal.add(pnlProducto);
					pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));
					pnlProducto.setLayout(null);
					pnlProducto.setBounds(5, 206, 998, 212);
					{
						lblNombre = new JLabel();
						pnlProducto.add(lblNombre);
						lblNombre.setText("Nro.Pedido:");
						lblNombre.setBounds(17, 26, 88, 14);
					}
					{
						txtNombre = new JTextField();
						pnlProducto.add(txtNombre);
						txtNombre.setBounds(105, 23, 194, 21);
						txtNombre.setEditable(false);
						//							txtNombre.addKeyListener(this);
					}
					{
						jLabel5 = new JLabel();
						pnlProducto.add(jLabel5);
						jLabel5.setText("Cargo:");
						jLabel5.setBounds(548, 53, 53, 14);
					}
					{
						jLabel6 = new JLabel();
						pnlProducto.add(jLabel6);
						jLabel6.setText("Responsable:");
						jLabel6.setBounds(134, 53, 84, 14);
					}
					{
						jTextField5 = new JTextField();
						pnlProducto.add(jTextField5);
						jTextField5.setBounds(55, 49, 77, 21);
						jTextField5.setEditable(false);
					}
					{
						jTextField6 = new JTextField();
						pnlProducto.add(jTextField6);
						jTextField6.setBounds(218, 50, 324, 21);
						jTextField6.setEditable(false);
					}
					{
						jLabel9 = new JLabel();
						pnlProducto.add(jLabel9);
						jLabel9.setText("Area:");
						jLabel9.setBounds(17, 52, 44, 14);
					}
					{
						lblVersion2 = new JLabel();
						pnlProducto.add(lblVersion2);
						lblVersion2.setText("Version:");
						lblVersion2.setBounds(306, 28, 52, 16);
					}
					{
						txtVersion = new JTextField();
						pnlProducto.add(txtVersion);
						txtVersion.setBounds(354, 25, 36, 23);
						txtVersion.setEditable(false);
					}
					{
						lblFecha = new JLabel();
						pnlProducto.add(lblFecha);
						lblFecha.setText("Fecha:");
						lblFecha.setBounds(423, 29, 43, 16);
					}
					{
						txtFecha2 = new JTextField();
						pnlProducto.add(txtFecha2);
						txtFecha2.setBounds(474, 24, 129, 23);
						txtFecha2.setEditable(false);
					}
					{
						txtCargo2 = new JTextField();
						pnlProducto.add(txtCargo2);
						txtCargo2.setBounds(597, 49, 80, 23);
						txtCargo2.setEditable(false);
					}
					{
						lblPrioridad2 = new JLabel();
						pnlProducto.add(lblPrioridad2);
						lblPrioridad2.setText("Prioridad:");
						lblPrioridad2.setBounds(17, 78, 71, 16);
					}
					{
						txtPrioridad2 = new JTextField();
						pnlProducto.add(txtPrioridad2);
						txtPrioridad2.setBounds(78, 75, 183, 23);
						txtPrioridad2.setEditable(false);
					}
					{
						lblObservacion = new JLabel();
						pnlProducto.add(lblObservacion);
						lblObservacion.setText("Observacion:");
						lblObservacion.setBounds(17, 100, 88, 16);
					}
					{
						jScrollPane3 = new JScrollPane();
						pnlProducto.add(jScrollPane3);
						jScrollPane3.setBounds(97, 102, 573, 32);
						{
							jTextArea1 = new JTextArea();
							jScrollPane3.setViewportView(jTextArea1);
							jTextArea1.setEditable(false);
						}
					}
					{
						jScrollPane4 = new JScrollPane();
						pnlProducto.add(jScrollPane4);
						jScrollPane4.setBounds(17, 139, 964, 70);
						{ 
							jTable2 = new JTable();
							jScrollPane4.setViewportView(jTable2);
							jTable2.setModel(modelo1);
						}
					}

					//						modelo1
					
				}
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos de la Evaluacion"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(0, 7, 710, 193);
					{
						lblObservacionD = new JLabel();
						pnlArriba.add(lblObservacionD);
						lblObservacionD.setText("Comentario:");
						lblObservacionD.setBounds(12, 70, 73, 14);
					}
					{
						scrObservacionD = new JScrollPane();
						pnlArriba.add(scrObservacionD);
						scrObservacionD.setBounds(114, 70, 568, 45);
						{
							txtAObservacionD = new JTextArea();
							scrObservacionD.setViewportView(txtAObservacionD);
							txtAObservacionD.setText("");
							txtAObservacionD.setBounds(155, 76, 408, 45);
							txtAObservacionD.setPreferredSize(new java.awt.Dimension(556, 42));
							//							txtAObservacionD.addKeyListener(this);
						}
					}
					{
						lblUMedida = new JLabel();
						pnlArriba.add(lblUMedida);
						lblUMedida.setText("Nro.Pedido:");
						lblUMedida.setBounds(12, 23, 78, 14);
					}
					{
						txtNroPedido = new JTextField();
						pnlArriba.add(txtNroPedido);
						txtNroPedido.setBounds(81, 19, 163, 21);
						txtNroPedido.setText("E201305121234");
						txtNroPedido.setEditable(false);
					}
					{
						jLabel1 = new JLabel();
						pnlArriba.add(jLabel1);
						jLabel1.setText("Version:");
						jLabel1.setBounds(275, 23, 60, 14);
					}
					{
						jTextField1 = new JTextField();
						pnlArriba.add(jTextField1);
						jTextField1.setBounds(327, 19, 27, 21); 
						jTextField1.setEditable(false);
						jTextField1.setText("0");
					}
					{
						chkNroPedido = new JCheckBox();
						pnlArriba.add(chkNroPedido);
						chkNroPedido.setBounds(250, 21, 20, 17);
						chkNroPedido.setSelected(true);
					}
					{
						jLabel2 = new JLabel();
						pnlArriba.add(jLabel2);
						jLabel2.setText("Fecha:");
						jLabel2.setBounds(363, 22, 48, 14);
					}
					{
						jTextField2 = new JTextField();
						pnlArriba.add(jTextField2);
						jTextField2.setText("20/05/2013");
						jTextField2.setEditable(false);
						jTextField2.setBounds(401, 19, 74, 21);
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
						jTextField3.setEditable(false);
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
						jTextField4.setEditable(false);
						jTextField4.setBounds(390, 43, 154, 21);
					}
					{
						jScrollPane1 = new JScrollPane();
						pnlArriba.add(jScrollPane1);
						jScrollPane1.setBounds(17, 121, 665, 69);
						{ 
							jTable3 = new JTable();
							jScrollPane1.setViewportView(jTable3);
							jTable3.setModel(modelo2);
						}
						
//						jTable1 = new JTable();
//						scrLista.setViewportView(jTable1);
//						jTable1.setModel(modelo2);
					}
				}
				{
					btnGuardar = new JButton();
					pnlPrincipal.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(372, 544, 145, 23);
				}
				{
					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(535, 544, 147, 23);
				}
				{
					jScrollPane2 = new JScrollPane();
					pnlPrincipal.add(jScrollPane2);
					jScrollPane2.setBounds(12, 419, 973, 119);
					{ 
						jTable1 = new JTable();
						jScrollPane2.setViewportView(jTable1);
						jTable1.setModel(modelo3);
					}
				}
				{
					btnBuscarPedido = new JButton();
					pnlPrincipal.add(btnBuscarPedido);
					btnBuscarPedido.setText("Buscar Pedido");
					btnBuscarPedido.setBounds(782, 106, 171, 23);
					btnBuscarPedido.addActionListener(this);
				}
				{
					jButton1 = new JButton();
					pnlPrincipal.add(jButton1);
					jButton1.setText("Buscar Evaluacion");
					jButton1.setBounds(782, 60, 171, 23);
					jButton1.addActionListener(this);
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
