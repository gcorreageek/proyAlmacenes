package com.almacen.prototipos.spexterna;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class EvaluarPedido_JInternalFrame extends JInternalFrame implements  ActionListener, MouseListener {
	MenuPrincipal objMenuP;
	private JButton btnAprobarEnviar;
	private JButton btnRegresar;
	private JButton btnRechazar;
	private JButton btnAprobar;
	private JTable tblProducto;
	private JScrollPane scrDetalleProducto;
	private JTextField txtTipoPedido;
	private JLabel jLabel8;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField1;
	private JTextField txtNroPedido2;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel1;
	private JLabel lblNroPedido2;
	private JTable jTable3;
	private JScrollPane jScrollPane1;
	private JTextField jTextField5;
	private JComboBox cboArea;
	private JComboBox cboEstado;
	private JRadioButton rdoAbastecimiento;
	private JRadioButton rdoPrestamo;
	private JLabel lblTipoPedido;
	private JButton btnBuscar;
	private JLabel jLabel5;
	private JLabel jLabel4;
	private JLabel jLabel3;
	private JTextField jTextField2;
	private JLabel jLabel2;
	private JTextField txtNroPedido;
	private JLabel lblUMedida;
	private JPanel pnlArriba;
	private JPanel pnlArriba2;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;

	String cod_mar,nom_mar;
	String titulo1[]={"Cod","Descripcion","Stock Actual","Stock Minimo"}; 
	String titulo2[]={"Nro","Area","Responsable","Fecha","Estado"}; 
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2	); 
	 DefaultTableModel modelo3 =new DefaultTableModel(null,titulo1	); 
	 public EvaluarPedido_JInternalFrame() { 
		 super("Evaluar Pedido", true, true, true, true);
		 try { 
			this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(735, 484));
			this.setBounds(0, 0, 735, 484);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(359, 255));
				{
					pnlArriba = new JPanel();
					pnlPrincipal.add(pnlArriba);
					pnlArriba.setBorder(BorderFactory.createTitledBorder("Datos de la Evaluacion"));
					pnlArriba.setLayout(null);
					pnlArriba.setBounds(0, 7, 710, 440);
					{
						lblUMedida = new JLabel();
						pnlArriba.add(lblUMedida);
						lblUMedida.setText("Nro.Pedido:");
						lblUMedida.setBounds(12, 23, 78, 14); 
						
						txtNroPedido = new JTextField();
						pnlArriba.add(txtNroPedido);
						txtNroPedido.setBounds(81, 19, 163, 21);
//						txtNroPedido.setText("E201305121234");

						jLabel2 = new JLabel();
						pnlArriba.add(jLabel2);
						jLabel2.setText("Fecha Inicio:");
						jLabel2.setBounds(267, 23, 78, 14);
					
						jTextField2 = new JTextField();
						pnlArriba.add(jTextField2);
//						jTextField2.setText("20/05/2013");
						jTextField2.setBounds(345, 20, 74, 21);
					
						jLabel3 = new JLabel();
						pnlArriba.add(jLabel3);
						jLabel3.setText("Area:");
						jLabel3.setBounds(12, 50, 69, 14);
					
						jLabel4 = new JLabel();
						pnlArriba.add(jLabel4);
						jLabel4.setText("Estado:");
						jLabel4.setBounds(262, 50, 53, 14);
					
						jScrollPane1 = new JScrollPane();
						pnlArriba.add(jScrollPane1);
						jScrollPane1.setBounds(17, 109, 663, 319);
						
							jTable3 = new JTable();
							jScrollPane1.setViewportView(jTable3);
							jTable3.setModel(modelo2);
							jTable3.addMouseListener(this);

							jTextField5 = new JTextField();
							pnlArriba.add(jTextField5);
//							jTextField5.setText("20/05/2013");
							jTextField5.setBounds(546, 19, 74, 21);

							jLabel5 = new JLabel();
							pnlArriba.add(jLabel5);
							jLabel5.setText("Fecha Fin:");
							jLabel5.setBounds(478, 22, 64, 14);
						 
							btnBuscar = new JButton();
							pnlArriba.add(btnBuscar);
							btnBuscar.setText("Buscar");
							btnBuscar.setBounds(254, 77, 165, 23);
							btnBuscar.addActionListener(this);
						 
							ComboBoxModel cboAreaModel = 
									new DefaultComboBoxModel(
											new String[] { "Seleccionar", "RRHH","CALIDAD" });
							cboArea = new JComboBox();
							pnlArriba.add(cboArea);
							cboArea.setModel(cboAreaModel);
							cboArea.setBounds(81, 46, 163, 23);
						 
							ComboBoxModel cboEstadoModel = 
									new DefaultComboBoxModel(
											new String[] { "Seleccionar", "Atendida" });
							cboEstado = new JComboBox();
							pnlArriba.add(cboEstado);
							cboEstado.setModel(cboEstadoModel);
							cboEstado.setBounds(311, 46, 140, 23);
						 
							lblTipoPedido = new JLabel();
							pnlArriba.add(lblTipoPedido);
							lblTipoPedido.setText("Tipo Pedido:");
							lblTipoPedido.setBounds(463, 49, 79, 16);
						 
							rdoPrestamo = new JRadioButton();
							pnlArriba.add(rdoPrestamo);
							rdoPrestamo.setText("Prestamo");
							rdoPrestamo.setBounds(541, 70, 124, 20);
						 
							rdoAbastecimiento = new JRadioButton();
							pnlArriba.add(rdoAbastecimiento);
							rdoAbastecimiento.setText("Abastecimiento");
							rdoAbastecimiento.setBounds(541, 49, 124, 20);
						
					} 
				}
				
				
				
				{
					pnlArriba2 = new JPanel();
					pnlPrincipal.add(pnlArriba2);
					pnlArriba2.setBorder(BorderFactory.createTitledBorder("Detalle Evaluacion"));
					pnlArriba2.setLayout(null);
					pnlArriba2.setBounds(0, 7, 710, 440);
					pnlArriba2.setVisible(false);
					{
						lblNroPedido2 = new JLabel();
						pnlArriba2.add(lblNroPedido2);
						lblNroPedido2.setText("Nro.Pedido:");
						lblNroPedido2.setBounds(26, 30, 92, 16);
					}
					{
						jLabel1 = new JLabel();
						pnlArriba2.add(jLabel1);
						jLabel1.setText("Fecha:");
						jLabel1.setBounds(351, 30, 92, 16);
					}
					{
						jLabel6 = new JLabel();
						pnlArriba2.add(jLabel6);
						jLabel6.setText("Area:");
						jLabel6.setBounds(26, 57, 92, 16);
					}
					{
						jLabel7 = new JLabel();
						pnlArriba2.add(jLabel7);
						jLabel7.setText("Tipo Pedido:");
						jLabel7.setBounds(26, 84, 92, 16);
					}
					{
						txtNroPedido2 = new JTextField();
						pnlArriba2.add(txtNroPedido2);
						txtNroPedido2.setBounds(118, 25, 201, 27);
						txtNroPedido2.setSize(201, 23);
						txtNroPedido2.setEnabled(false);
						txtNroPedido2.setText("PED20130122245");
					}
					{
						jTextField1 = new JTextField();
						pnlArriba2.add(jTextField1);
						jTextField1.setBounds(443, 25, 201, 27);
						jTextField1.setSize(201, 23);
						jTextField1.setEnabled(false);
						jTextField1.setText("22/12/2013");
					}
					{
						jTextField3 = new JTextField();
						pnlArriba2.add(jTextField3);
						jTextField3.setBounds(118, 52, 201, 27);
						jTextField3.setSize(201, 23);
						jTextField3.setEnabled(false);
						jTextField3.setText("RRHHH");
					}
					{
						jTextField4 = new JTextField();
						pnlArriba2.add(jTextField4);
						jTextField4.setBounds(443, 53, 201, 27);
						jTextField4.setSize(201, 23);
						jTextField4.setEnabled(false);
						jTextField4.setText("Desatendida");
					}
					{
						jLabel8 = new JLabel();
						pnlArriba2.add(jLabel8);
						jLabel8.setText("Estado:");
						jLabel8.setBounds(351, 56, 92, 16);
					}
					{
						txtTipoPedido = new JTextField();
						pnlArriba2.add(txtTipoPedido);
						txtTipoPedido.setBounds(118, 81, 195, 23);
						txtTipoPedido.setEnabled(false);
						txtTipoPedido.setText("Abastecimiento");
					}
					{
						scrDetalleProducto = new JScrollPane();
						pnlArriba2.add(scrDetalleProducto);
						scrDetalleProducto.setBounds(31, 156, 653, 279);
						{ 
							tblProducto = new JTable();
							scrDetalleProducto.setViewportView(tblProducto);
							Object[] obj1 = {"PROD2541401","Carpeta de 5 personas","20","5"};
							Object[] obj2 = {"PROD12401","Hojas de Color","1000","500"};
							Object[] obj3 = {"PROD541401","Pizarras Antialergicas","30","5"}; 
							modelo3.addRow(obj1); 
							modelo3.addRow(obj2);
							modelo3.addRow(obj3);
							tblProducto.setModel(modelo3);
						}
					}
					{
						btnAprobar = new JButton();
						pnlArriba2.add(btnAprobar);
						btnAprobar.setText("Aprobar");
						btnAprobar.setBounds(59, 112, 108, 23);
					}
					{
						btnRechazar = new JButton();
						pnlArriba2.add(btnRechazar);
						btnRechazar.setText("Rechazar");
						btnRechazar.setBounds(172, 112, 123, 23);
					}
					{
						btnRegresar = new JButton();
						pnlArriba2.add(btnRegresar);
						btnRegresar.setText("Regresar");
						btnRegresar.setBounds(306, 112, 127, 23);
					}
					{
						btnAprobarEnviar = new JButton();
						pnlArriba2.add(btnAprobarEnviar);
						btnAprobarEnviar.setText("Aprobar y Enviar");
						btnAprobarEnviar.setBounds(444, 112, 130, 23);
					}
				}
				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {
			if(btnBuscar==e.getSource()){ 
				Object[] obj = {"PED20130122245","RRHHH","Agusto Baltazar Chamoli","22/12/2013","Desatendida"};
				modelo2.addRow(obj);
				
			} 
		}


		@Override
		public void mouseClicked(MouseEvent e) { } 
		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource()==jTable3 && e.getClickCount()==2){ 
				pnlArriba2.setVisible(true); 
				pnlArriba.setVisible(false); 
			} 
		} 
		@Override
		public void mouseReleased(MouseEvent e) { } 
		@Override
		public void mouseEntered(MouseEvent e) { }  
		@Override
		public void mouseExited(MouseEvent e) { }

		 

}
