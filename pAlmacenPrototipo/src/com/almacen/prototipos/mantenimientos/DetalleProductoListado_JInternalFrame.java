package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class DetalleProductoListado_JInternalFrame extends JInternalFrame implements  ActionListener {
	MenuPrincipal objMenuP;
	private JButton btnNuevoDetalleProducto;
	private JComboBox jComboBox2;
	private JLabel jLabel3;
	private JLabel jLabel1;
	private JComboBox cboMarca;
	ProductoNuevo_JDialog productoNuevo;
	ProveedorNuevo_JDialog proveedorNuevo;
	
	private JPanel pnlPrincipal;
	private JComboBox jComboBox1;
	private JLabel jLabel2;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JButton btnBuscar;
	private JScrollPane scrLista;

	String cod_mar,nom_mar;
	private JTable jTable1;
	String titulo2[]={"COD","PRODUCTO","MARCA","UMEDIDA","PROVEEDOR","PRECIO","[E]","[M]"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public DetalleProductoListado_JInternalFrame() { 
		 super("Listado Detalle Producto", true, true, true, true);
		 try { 
			 this.setVisible(true);
			this.setPreferredSize(new java.awt.Dimension(782, 368));
			this.setBounds(0, 0, 782, 368);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					scrLista = new JScrollPane();
					pnlPrincipal.add(scrLista);
					scrLista.setBounds(6, 138, 758, 186);
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
					btnBuscar.setBounds(6, 115, 93, 21);
					btnBuscar.addActionListener(this);
				}
				{
					txtMarca = new JTextField();
					pnlPrincipal.add(txtMarca);
					txtMarca.setBounds(84, 6, 329, 23);
				}
				{
					lblMarca = new JLabel();
					pnlPrincipal.add(lblMarca);
					lblMarca.setText("Producto:");
					lblMarca.setBounds(6, 10, 74, 14);
				}
				{
					jLabel2 = new JLabel();
					pnlPrincipal.add(jLabel2);
					jLabel2.setText("U.Medida:");
					jLabel2.setBounds(6, 62, 74, 22);
				}
				{
					ComboBoxModel jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] {  "SELECCIONAR", "UND","CAJA","DOCENA","MILLAR" });
					jComboBox1 = new JComboBox();
					pnlPrincipal.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(84, 61, 191, 23);
					jComboBox1.setEditable(true);
				}
				{
					ComboBoxModel cboMarcaModel = 
							new DefaultComboBoxModel(
									new String[] {"SELECCIONAR", "3M","PEPITO","MICROSOFT"  });
					cboMarca = new JComboBox();
					pnlPrincipal.add(cboMarca);
					cboMarca.setModel(cboMarcaModel);
					cboMarca.setBounds(84, 32, 191, 23);
					cboMarca.setEditable(true);
				}
				{
					jLabel1 = new JLabel();
					pnlPrincipal.add(jLabel1);
					jLabel1.setText("Marca:");
					jLabel1.setBounds(6, 37, 74, 18);
				}
				{
					jLabel3 = new JLabel();
					pnlPrincipal.add(jLabel3);
					jLabel3.setText("Proveedor:");
					jLabel3.setBounds(6, 90, 74, 22);
				}
				{
					ComboBoxModel jComboBox2Model = 
							new DefaultComboBoxModel(
									new String[] { "SELECCIONAR", "DELTRON","PCYA" });
					jComboBox2 = new JComboBox();
					pnlPrincipal.add(jComboBox2);
					jComboBox2.setModel(jComboBox2Model);
					jComboBox2.setBounds(84, 88, 191, 23);
					jComboBox2.setEditable(true);
				}
				{
					btnNuevoDetalleProducto = new JButton();
					pnlPrincipal.add(btnNuevoDetalleProducto);
					btnNuevoDetalleProducto.setText("Nuevo Detalle Producto");
					btnNuevoDetalleProducto.setBounds(425, 6, 196, 23);
					btnNuevoDetalleProducto.addActionListener(this);
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
			if(btnNuevoDetalleProducto==e.getSource()){
				DetalleProductoNuevo_JDialog detalleProductoNuevo = new DetalleProductoNuevo_JDialog(objMenuP);
				detalleProductoNuevo.setVisible(true);
				detalleProductoNuevo.pack(); 
			}
			

			
		}

		 

}
