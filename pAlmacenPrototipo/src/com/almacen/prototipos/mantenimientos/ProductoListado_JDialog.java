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
public class ProductoListado_JDialog extends JDialog implements  ActionListener, MouseListener {
	MenuPrincipal objMenuP;
	private JLabel jLabel1;
	private JComboBox cboMarca;
	ProductoNuevo_JDialog productoNuevo;
	
	private JPanel pnlPrincipal;
	private JComboBox jComboBox1;
	private JLabel jLabel2;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JButton btnBuscar;
	private JScrollPane scrLista;
	private JButton btnIngreso;

	String cod_mar,nom_mar;
	private JTable jTable1;
	String titulo2[]={"COD","PRODUCTO","MARCA","UMEDIDA"};
//	String titulo2[]={"COD","PRODUCTO","TIPO","NUMERO","RESPONSABLE","TELEFONO","DIRECCION","CORREO","[E]","[M]"};
//	String titulo2[]={"CODIGO","MARCA","ELIMINAR","MODIFICAR"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public ProductoListado_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(785, 318));
			this.setBounds(0, 0, 785, 318);
			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					btnIngreso = new JButton();
					pnlPrincipal.add(btnIngreso);
					btnIngreso.setText("Nueva Producto");
					btnIngreso.setBounds(287, 33, 180, 21);
					btnIngreso.addActionListener(this);
				}
				{
					scrLista = new JScrollPane();
					pnlPrincipal.add(scrLista);
					scrLista.setBounds(6, 90, 758, 186);
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
					btnBuscar.setBounds(287, 62, 93, 21);
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
				}
				{
					ComboBoxModel cboMarcaModel = 
							new DefaultComboBoxModel(
									new String[] {"SELECCIONAR", "3M","PEPITO","MICROSOFT"  });
					cboMarca = new JComboBox();
					pnlPrincipal.add(cboMarca);
					cboMarca.setModel(cboMarcaModel);
					cboMarca.setBounds(84, 32, 191, 23);
				}
				{
					jLabel1 = new JLabel();
					pnlPrincipal.add(jLabel1);
					jLabel1.setText("Marca:");
					jLabel1.setBounds(6, 37, 74, 18);
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
				productoNuevo = new  ProductoNuevo_JDialog(objMenuP);
				productoNuevo.setVisible(true);
				productoNuevo.pack(); 
			}
			if(e.getSource()==btnBuscar){
				Object[]  obj={"PROD1441","Hojas","Stanford","Millar"};
				modelo2.addRow(obj);
			}
		}


		@Override
		public void mouseClicked(MouseEvent e) { 
		}
		@Override
		public void mousePressed(MouseEvent e) { 
			if(e.getSource()==jTable1 && e.getClickCount()==2){
				this.setVisible(false);
			} 
		}

		@Override
		public void mouseReleased(MouseEvent e) { 
		}
		@Override
		public void mouseEntered(MouseEvent e) { 
		}
		@Override
		public void mouseExited(MouseEvent e) { 
		}

		 

}
