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
public class RegistrarPedido_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JButton btnGuardarEnviar;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTable jTable1;
	private JScrollPane jScrollPane2;
	private JButton jButton1;
	private JComboBox cboPrioridad;
	private JLabel jLabel7;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JTextField jTextField6;
	private JTextField jTextField5;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JTable jTable3;
	private JScrollPane jScrollPane1;
	private JButton btnAgregar;
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
	private JButton btnBuscarProductos;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JPanel pnlProducto;
	private JPanel pnlArriba;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar;
	String titulo1[]={"Item","Responsable","Comentario","Eliminar/Seleccionar"};
	String titulo2[]={"COD","PRODUCTO","MARCA","UMEDIDA","PROVEEDOR","PRECIO","[E]","[M]"};
	String titulo3[]={"ITEM","COD","PRODUCTO","MARCA","UMEDIDA","CANTIDAD","PRIORIDAD","[E]",};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 DefaultTableModel modelo1 =new DefaultTableModel(null,titulo1);
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo3);
	 
	 public RegistrarPedido_JInternalFrame() { 
		 super("Registro de Pedido", true, true, true, true);
		 try { 
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(668, 505));
			this.setBounds(0, 0, 668, 505);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(0, 7, 658, 297);
					{
						lblObservacionD = new JLabel();
						pnlArriba.add(lblObservacionD);
						lblObservacionD.setText("Comentario:");
						lblObservacionD.setBounds(12, 70, 73, 14);
					}
					{
						scrObservacionD = new JScrollPane();
						pnlArriba.add(scrObservacionD);
						scrObservacionD.setBounds(114, 70, 527, 45);
						{
							txtAObservacionD = new JTextArea();
							scrObservacionD.setViewportView(txtAObservacionD);
							txtAObservacionD.setText("");
							txtAObservacionD.setBounds(155, 76, 408, 45);
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
						txtNroPedido.setText("P201305121234");
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
						btnBuscarPedido = new JButton();
						pnlArriba.add(btnBuscarPedido);
						btnBuscarPedido.setText("Buscar Pedido");
						btnBuscarPedido.setBounds(487, 18, 136, 23);
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
						pnlProducto = new JPanel();
						pnlArriba.add(pnlProducto);
						pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
						pnlProducto.setLayout(null);
						pnlProducto.setBounds(17, 209, 624, 76);
						{
							lblNombre = new JLabel();
							pnlProducto.add(lblNombre);
							lblNombre.setText("Nombre:");
							lblNombre.setBounds(17, 26, 62, 14);
						}
						{
							txtNombre = new JTextField();
							pnlProducto.add(txtNombre);
							txtNombre.setBounds(79, 23, 475, 21);
							txtNombre.setEditable(false);
							//							txtNombre.addKeyListener(this);
						}
						{
							btnBuscarProductos = new JButton();
							pnlProducto.add(btnBuscarProductos);
							btnBuscarProductos.setText("Buscar");
							btnBuscarProductos.setBounds(421, 48, 138, 23);
							//							btnBuscarProductos.addKeyListener(this);
							btnBuscarProductos.addActionListener(this);
						}
						{
							jLabel5 = new JLabel();
							pnlProducto.add(jLabel5);
							jLabel5.setText("Marca:");
							jLabel5.setBounds(163, 52, 62, 14);
						}
						{
							jLabel6 = new JLabel();
							pnlProducto.add(jLabel6);
							jLabel6.setText("U.Medida:");
							jLabel6.setBounds(17, 52, 62, 14);
						}
						{
							jTextField5 = new JTextField();
							pnlProducto.add(jTextField5);
							jTextField5.setBounds(79, 49, 77, 21);
							jTextField5.setEditable(false);
						}
						{
							jTextField6 = new JTextField();
							pnlProducto.add(jTextField6);
							jTextField6.setBounds(209, 50, 200, 21);
							jTextField6.setEditable(false);
						}

						//						modelo1
						
					}
					{
						jTextField4 = new JTextField();
						pnlArriba.add(jTextField4);
						jTextField4.setText("Jefe de RRHH");
						jTextField4.setEditable(false);
						jTextField4.setBounds(390, 43, 154, 21);
					}
					{
						btnAgregar = new JButton();
						pnlArriba.add(btnAgregar);
						btnAgregar.setText("Agregar");
						btnAgregar.setBounds(12, 87, 97, 23);
					}
					{
						jScrollPane1 = new JScrollPane();
						pnlArriba.add(jScrollPane1);
						jScrollPane1.setBounds(17, 134, 619, 69);
						{ 
							jTable3 = new JTable();
							jScrollPane1.setViewportView(jTable3);
							jTable3.setModel(modelo1);
						}
						
//						jTable1 = new JTable();
//						scrLista.setViewportView(jTable1);
//						jTable1.setModel(modelo2);
					}
				}
				{
					lblCantidad = new JLabel();
					pnlPrincipal.add(lblCantidad);
					lblCantidad.setText("Cantidad:");
					lblCantidad.setBounds(38, 330, 71, 16);
				}
				{
					txtCantidad = new JTextField();
					pnlPrincipal.add(txtCantidad);
					txtCantidad.setBounds(109, 327, 132, 23);
				}
				{
					jLabel7 = new JLabel();
					pnlPrincipal.add(jLabel7);
					jLabel7.setText("Prioridad:");
					jLabel7.setBounds(262, 331, 71, 16);
				}
				{
					ComboBoxModel cboPrioridadModel = 
							new DefaultComboBoxModel(
									new String[] { "SELECCIONAR", "ALTA","MEDIA","BAJA" });
					cboPrioridad = new JComboBox();
					pnlPrincipal.add(cboPrioridad);
					cboPrioridad.setModel(cboPrioridadModel);
					cboPrioridad.setBounds(322, 328, 168, 23);
				}
				{
					jButton1 = new JButton();
					pnlPrincipal.add(jButton1);
					jButton1.setText("Agregar");
					jButton1.setBounds(514, 328, 82, 23);
				}
				{
					jScrollPane2 = new JScrollPane();
					pnlPrincipal.add(jScrollPane2);
					jScrollPane2.setBounds(22, 358, 636, 78);
					{ 
						jTable1 = new JTable();
						jScrollPane2.setViewportView(jTable1);
						jTable1.setModel(modelo3);
					}
				}
				{
					btnGuardar = new JButton();
					pnlPrincipal.add(btnGuardar);
					btnGuardar.setText("Guardar");
					btnGuardar.setBounds(82, 441, 145, 23);
				}
				{
					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(246, 441, 147, 23);
				}
				{
					btnGuardarEnviar = new JButton();
					pnlPrincipal.add(btnGuardarEnviar);
					btnGuardarEnviar.setText("Guardar y Enviar");
					btnGuardarEnviar.setBounds(414, 441, 147, 23);
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
//			if(btnNuevoDetalleProducto==e.getSource()){
//				DetalleProductoNuevo_JDialog detalleProductoNuevo = new DetalleProductoNuevo_JDialog(objMenuP);
//				detalleProductoNuevo.setVisible(true);
//				detalleProductoNuevo.pack(); 
//			}
			

			
		}

		 

}
