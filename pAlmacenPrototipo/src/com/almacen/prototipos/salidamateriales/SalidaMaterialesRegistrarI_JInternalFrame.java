package com.almacen.prototipos.salidamateriales;
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
public class SalidaMaterialesRegistrarI_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JCheckBox checkInforme;
	private JTable jTable1;
	private JScrollPane scrInformeDevolucion;
	private JTextField txtFecha;
	private JLabel lblFecha;
	private JTextField txtNroInforme;
	private JLabel lblNroInforme;
	private JButton jButton2;
	private JTextField jTextField1;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton jButton1;
	private JTable jTable3;
	private JScrollPane jScrollPane1;
	private JTextField jTextField4;
	private JLabel lblNropedido;
	private JButton btnCargar;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JLabel jLabel3;
	private JButton btnBuscarPedido;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField txtNroPedido;
	private JLabel lblUMedida;
	private JPanel pnlArriba;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar;
	String titulo1[]={"Cod","Descripcion","Cantidad","Marca","UMedida",""}; 
	String titulo2[]={"Cod","Descripcion","Cantidad","Marca","Observacion"}; 
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO",s"DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo1	); 
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo2	);
	 public SalidaMaterialesRegistrarI_JInternalFrame() { 
		 super("Salida Materiales", true, true, true, true);
		 try { 
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(727, 526));
			this.setBounds(0, 0, 727, 526);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos del Pedido"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(12, 75, 712, 194);
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
						btnCargar.setBounds(575, 42, 101, 23);
					}
				}
				{
					btnGuardar = new JButton();
					pnlPrincipal.add(btnGuardar);
					btnGuardar.setText("Enviar");
					btnGuardar.setBounds(199, 473, 145, 23);
				}
				{
					btnCancelar = new JButton();
					pnlPrincipal.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(406, 473, 147, 23);
				}
				{
					btnBuscarPedido = new JButton();
					pnlPrincipal.add(btnBuscarPedido);
					btnBuscarPedido.setText("Limpiar Informe");
					btnBuscarPedido.setBounds(360, 276, 171, 23);
					btnBuscarPedido.addActionListener(this);
				}
				{
					jButton1 = new JButton();
					pnlPrincipal.add(jButton1);
					jButton1.setText("Llenar Informe");
					jButton1.setBounds(171, 276, 173, 23);
					jButton1.addActionListener(this);
				}
				{
					lblNropedido = new JLabel();
					pnlPrincipal.add(lblNropedido);
					lblNropedido.setText("Nro.Pedida:");
					lblNropedido.setBounds(27, 49, 62, 16);
				}
				{
					jTextField1 = new JTextField();
					pnlPrincipal.add(jTextField1);
					jTextField1.setBounds(101, 46, 175, 23);
					jTextField1.setEditable(false);
					jTextField1.setEnabled(false);
				}
				{
					jButton2 = new JButton();
					pnlPrincipal.add(jButton2);
					jButton2.setText("Buscar Pedido");
					jButton2.setBounds(288, 46, 150, 23);
					jButton2.addActionListener(this);
				}
				{
					lblNroInforme = new JLabel();
					pnlPrincipal.add(lblNroInforme);
					lblNroInforme.setText("Nro.Informe:");
					lblNroInforme.setBounds(27, 12, 87, 16);
				}
				{
					txtNroInforme = new JTextField();
					pnlPrincipal.add(txtNroInforme);
					txtNroInforme.setBounds(114, 10, 216, 23);
					txtNroInforme.setEnabled(false);
					txtNroInforme.setText("INF2013052541101");
				}
				{
					lblFecha = new JLabel();
					pnlPrincipal.add(lblFecha);
					lblFecha.setText("Fecha:");
					lblFecha.setBounds(427, 13, 57, 16);
				}
				{
					txtFecha = new JTextField();
					pnlPrincipal.add(txtFecha);
					txtFecha.setBounds(491, 10, 162, 23);
					txtFecha.setEnabled(false);
					txtFecha.setText("25/05/2013");
				}
				{
					scrInformeDevolucion = new JScrollPane();
					pnlPrincipal.add(scrInformeDevolucion);
					scrInformeDevolucion.setBounds(24, 304, 685, 163);
					{ 
						jTable1 = new JTable();
						scrInformeDevolucion.setViewportView(jTable1);
						jTable1.setModel(modelo3);
					}
				}
				{
					checkInforme = new JCheckBox();
					pnlPrincipal.add(checkInforme);
					checkInforme.setSelected(true);
					checkInforme.setBounds(337, 13, 23, 17);
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
		if(jButton2==e.getSource()){
			BuscarPedidoListado_JDialog buscarPedido = new BuscarPedidoListado_JDialog(objMenuP); 
			buscarPedido.setVisible(true);
			buscarPedido.pack(); 
			
		} 

			
		}

		 

}
