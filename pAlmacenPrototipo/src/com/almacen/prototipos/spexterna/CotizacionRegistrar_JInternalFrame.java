package com.almacen.prototipos.spexterna;
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
import javax.swing.JRadioButton;
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
import com.almacen.prototipos.mantenimientos.ProveedorListado_JDialog;
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
public class CotizacionRegistrar_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JTextField txtCorreo;
	private JLabel lblCorreo;
	private JButton btnBuscarProveedor;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JTable jTable1;
	private JScrollPane jScrollPane2;
	private JButton jButton1;
	private JTextField txtCantidad;
	private JLabel lblCantidad;
	private JTextField jTextField6;
	private JTextField jTextField5;
	private JLabel jLabel6;
	private JLabel jLabel5;
	private JTextField jTextField4;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JTextField txtNroPedido;
	private JLabel lblUMedida;
	private JButton btnBuscarProductos;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JPanel pnlProducto;
	private JPanel pnlArriba;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar; 
	String titulo3[]={"ITEM","COD","PRODUCTO","MARCA","UMEDIDA","[E]"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"}; 
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo3);
	 
	 public CotizacionRegistrar_JInternalFrame() { 
		 super("Nueva Cotizacion", true, true, true, true);
		 try { 
			 System.out.println("entrooo");
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(667, 427));
			this.setBounds(0, 0, 667, 427);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					pnlProducto = new JPanel();
					pnlPrincipal.add(pnlProducto);
					pnlProducto.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
					pnlProducto.setLayout(null);
					pnlProducto.setBounds(15, 137, 627, 76);
					{
						lblNombre = new JLabel();
						pnlProducto.add(lblNombre);
						lblNombre.setText("Nombre:");
						lblNombre.setBounds(17, 26, 62, 14);
					}
					{
						txtNombre = new JTextField();
						pnlProducto.add(txtNombre);
						txtNombre.setBounds(79, 23, 519, 21);
						txtNombre.setEnabled(false);
						//							txtNombre.addKeyListener(this);
					}
					{
						btnBuscarProductos = new JButton();
						pnlProducto.add(btnBuscarProductos);
						btnBuscarProductos.setText("Buscar Producto");
						btnBuscarProductos.setBounds(421, 48, 177, 23);
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
						jTextField5.setEnabled(false);
					}
					{
						jTextField6 = new JTextField();
						pnlProducto.add(jTextField6);
						jTextField6.setBounds(209, 50, 200, 21);
						jTextField6.setEnabled(false);
					}
					
					//						modelo1
					
				}
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(26, 12, 599, 113);
					{
						lblUMedida = new JLabel();
						pnlArriba.add(lblUMedida);
						lblUMedida.setText("Proveedor");
						lblUMedida.setBounds(12, 23, 78, 14);
					}
					{
						txtNroPedido = new JTextField();
						pnlArriba.add(txtNroPedido);
						txtNroPedido.setBounds(81, 19, 299, 21);
						txtNroPedido.setText("P201305121234");
						txtNroPedido.setEnabled(false);
					}
					{
						jLabel3 = new JLabel();
						pnlArriba.add(jLabel3);
						jLabel3.setText("Responsable:");
						jLabel3.setBounds(12, 52, 90, 14);
					}
					{
						jTextField3 = new JTextField();
						pnlArriba.add(jTextField3);
						jTextField3.setText("Aguilar Jorgue");
						jTextField3.setBounds(102, 49, 487, 21);
						jTextField3.setEnabled(false);
					}
					{
						jLabel4 = new JLabel();
						pnlArriba.add(jLabel4);
						jLabel4.setText("Telefono:");
						jLabel4.setBounds(12, 78, 104, 14);
					}
					{
						jTextField4 = new JTextField();
						pnlArriba.add(jTextField4);
						jTextField4.setText("Jefe de RRHH");
						jTextField4.setBounds(87, 75, 154, 21);
						jTextField4.setEnabled(false);
					}
					{
						btnBuscarProveedor = new JButton();
						pnlArriba.add(btnBuscarProveedor);
						btnBuscarProveedor.setText("Buscar Proveedor");
						btnBuscarProveedor.setBounds(395, 18, 194, 23);
						btnBuscarProveedor.addActionListener(this);
					}
					{
						lblCorreo = new JLabel();
						pnlArriba.add(lblCorreo);
						lblCorreo.setText("Correo:");
						lblCorreo.setBounds(253, 77, 67, 16);
					}
					{
						txtCorreo = new JTextField();
						pnlArriba.add(txtCorreo);
						txtCorreo.setBounds(320, 74, 269, 21);
						txtCorreo.setEnabled(false);
					}
				}
				{
					lblCantidad = new JLabel();
					pnlPrincipal.add(lblCantidad);
					lblCantidad.setText("Cantidad:");
					lblCantidad.setBounds(40, 218, 132, 25);
					lblCantidad.setVisible(false);
				}
				{
					txtCantidad = new JTextField();
					pnlPrincipal.add(txtCantidad);
					txtCantidad.setBounds(110, 218, 132, 25);
					txtCantidad.setVisible(false);
				}
				{
					jButton1 = new JButton();
					pnlPrincipal.add(jButton1);
					jButton1.setText("Agregar");
					jButton1.setBounds(262, 219, 123, 23);
					jButton1.addActionListener(this);
				}
				{
					jScrollPane2 = new JScrollPane();
					pnlPrincipal.add(jScrollPane2);
					jScrollPane2.setBounds(22, 247, 636, 113);
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
					btnGuardar.setBounds(150, 366, 145, 26);
				}
				{
					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(330, 366, 147, 25);
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
			if(btnBuscarProductos==e.getSource()){
				ProductoListado_JDialog productoListado = new ProductoListado_JDialog(objMenuP);
				productoListado.setVisible(true);
				productoListado.pack(); 
			}
			if(btnBuscarProveedor==e.getSource()){ 
				ProveedorListado_JDialog buscarProveedor = new ProveedorListado_JDialog(objMenuP);
				buscarProveedor.setVisible(true);
				buscarProveedor.pack();
			}
			if(jButton1==e.getSource()){
				System.out.println("kkk");
				Object[] obj = {"ITEM","COD","PRODUCTO","MARCA","UMEDIDA","CANTIDAD","PRIORIDAD","[E]"};
				modelo3.addRow(obj);
				
			}
//				modelo2.addRow(array);
			
		}

		 

}
