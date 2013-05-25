package com.almacen.prototipos.mantenimientos;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class UMedidaListado_JDialog extends JDialog implements  ActionListener {
	MenuPrincipal objMenuP;
	UMedidaNueva_JDialog nuevaUMedida;
	
	private JPanel pnlPrincipal;
	private JButton btnBuscar;
	private JScrollPane scrLista;
	private JButton btnIngreso;
	private JLabel lblMarca;
	private JTextField txtMarca;

	String cod_mar,nom_mar;
	private JTable jTable1;
 
	String titulo2[]={"COD","UMEDIDA","[E]","[M]"};
	 DefaultTableModel modelo2 =new DefaultTableModel(null,titulo2);
	 public UMedidaListado_JDialog(Frame padre) { 
		 super( (Frame)padre, true);
		 try { 
			this.setPreferredSize(new java.awt.Dimension(547, 262));
			this.setBounds(0, 0, 547, 262);

			{
				pnlPrincipal = new JPanel();
				getContentPane().add(pnlPrincipal, BorderLayout.CENTER);
				{
					txtMarca = new JTextField();
					pnlPrincipal.add(txtMarca);
					txtMarca.setBounds(90, 9, 232, 21);
				}
				{
					lblMarca = new JLabel();
					pnlPrincipal.add(lblMarca);
					lblMarca.setText("U.Medida:");
					lblMarca.setBounds(12, 12, 93, 14);
				}
				{
					btnIngreso = new JButton();
					pnlPrincipal.add(btnIngreso);
					btnIngreso.setText("Nuevo U.Medida");
					btnIngreso.setBounds(409, 9, 122, 21);
					btnIngreso.addActionListener(this);
				}
				{
					scrLista = new JScrollPane();
					pnlPrincipal.add(scrLista);
					scrLista.setBounds(7, 32, 419, 179);
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
					btnBuscar.setBounds(324, 9, 80, 21);
					btnBuscar.addActionListener(this);
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
				nuevaUMedida = new  UMedidaNueva_JDialog(objMenuP);
				nuevaUMedida.setVisible(true);
				nuevaUMedida.pack(); 
			}
		}

		 

}
