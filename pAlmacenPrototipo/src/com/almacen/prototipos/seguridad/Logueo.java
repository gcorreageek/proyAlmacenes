package com.almacen.prototipos.seguridad;

  

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
public class Logueo extends JFrame implements ActionListener{
	MenuPrincipal  objMenu;
	
	private JPanel pnlLogeo;
	private JPanel pnlPrincipal;
	private JButton btnCancelar;
	private JButton btnIngresar;
	private JTextField txtCodUsuario;
	private JPasswordField txtClave;
	private JLabel lblClave;
	private JLabel lblTipoUsuario;
	private JButton btnAceptar;
	private JButton btnAyer;
	private JButton btnCancelarTipoCambio;
	private JTextField txtVenta;
	private JTextField txtCompra;
	private JComboBox cboMoneda;
	private JLabel lblVenta;
	private JLabel lblCompra;
	private JLabel lblMoneda;
	private JLabel lblFecha;
	private JPanel pnlDatos;
	boolean val=false;
	private JLabel lblImagen3;
	private JLabel lblImagen2;
	private JLabel lblLogeo;  
	//RemindTask objtimer;
	
	/*
	 *ClassLoader cl = this .getClass().getClassLoader(); 
	 *Icon saveIcon  = new ImageIcon(cl.getResource("images/save.gif"));
	 *
	 *
	 *
	 */

	ClassLoader cl = this .getClass().getClassLoader();
	URL cad=cl.getResource("Images/logeo.jpg");
	
	Icon imagen  = new ImageIcon(cad);
	
//	Icon imagen  = new ImageIcon(cl.getResource("Images/logeo.jpg"));
	Icon imagen2  = new ImageIcon(cl.getResource("Images/tipo.jpg"));
//	Icon imagen3  = new ImageIcon(cl.getResource("Images/iniciocel.gif"));

	//ImageIcon imagen = new ImageIcon("Images/logeo.jpg");
	//ImageIcon imagen2 = new ImageIcon("Images/tipo.jpg");
	//ImageIcon imagen3 = new ImageIcon("Images/iniciocel.gif");
	
	 
	Timer timer;
	int segundos,segundos2;//manejar el valor del contador
	boolean frozen;
	
	String fec,codi_ven,fecha,fec2;
	int cod_vend,tiempoven,numerodeorden; 
	public static String nomvend,sexcli,nomclien,fecp,fecs,correo,refe,est_emp;
	public static String nom_vendedor,sex_clie,nom_clien,fecc_rep,correo_rep,cod_cli;
	public static String nomvendProv,sexProv,nomProv,fecpProv,fecsProv,correoProv,refeProv,codRef;
	public static String nVendedor,per_prove,sex_prove,mail_prove;
	public static String nvendeor,sexocli,ncli,mailcli,mailbcli,est_llamada;
	public static String codigocliente,vendedor,conacli,sexcliente,mail1,mail2,est_envio;
	public static int est,numorden;
	int conTareas;
	String nomcli;
	int contador;
	int orden;

	public  Logueo() {
		this.setVisible(true);
			try {  
				FlowLayout thisLayout = new FlowLayout();
				getContentPane().setLayout(thisLayout);

				pnlPrincipal = new JPanel();
				
				getContentPane().add(pnlPrincipal);
				pnlPrincipal.setLayout(null);
				pnlPrincipal.setPreferredSize(new java.awt.Dimension(545, 565));

				pnlDatos = new JPanel();
				//((RootPaneContainer) pnlDatos).setContentPane(new miLib.Contenedor());
				pnlPrincipal.add(pnlDatos);
				//pnlDatos.setBorder(BorderFactory.createTitledBorder("Tipo de Cambio"));
				pnlDatos.setLayout(null);
				pnlDatos.setBounds(12, 109, 525, 444);
				pnlDatos.setVisible(false);
				pnlDatos.setVisible(false);

				lblFecha = new JLabel();
				pnlDatos.add(lblFecha);
				lblFecha.setText("Fecha:");
				lblFecha.setBounds(84, 312, 44, 15);

				lblMoneda = new JLabel();
				pnlDatos.add(lblMoneda);
				lblMoneda.setText("Moneda:");
				lblMoneda.setBounds(84, 345, 47, 10);

				lblCompra = new JLabel();
				pnlDatos.add(lblCompra);
				lblCompra.setText("Compra:");
				lblCompra.setBounds(84, 374, 52, 11);

				lblVenta = new JLabel();
				pnlDatos.add(lblVenta);
				lblVenta.setText("Venta:");
				lblVenta.setBounds(84, 403, 51, 14);

				cboMoneda = new JComboBox();
				pnlDatos.add(cboMoneda);
				cboMoneda.setEnabled(false);
				cboMoneda.addItem("Dolar $");
				cboMoneda.addItem("Euro  €");
				cboMoneda.setBounds(176, 341, 163, 22);

				txtCompra = new JTextField();
				pnlDatos.add(txtCompra);
				txtCompra.setBounds(176, 369, 166, 25);

				txtVenta = new JTextField();
				pnlDatos.add(txtVenta);
				txtVenta.setBounds(176, 400, 167, 21);

				btnAyer = new JButton();
				pnlDatos.add(btnAyer);
				btnAyer.setText("Fecha Anterior");
				btnAyer.setBounds(353, 370, 95, 24);

				btnCancelarTipoCambio = new JButton();
				pnlDatos.add(btnCancelarTipoCambio);
				btnCancelarTipoCambio.setText("Cancelar");
				btnCancelarTipoCambio.setBounds(366, 472, 94, 23);

				btnAceptar = new JButton();
				pnlDatos.add(btnAceptar);
				btnAceptar.setText("Aceptar");
				btnAceptar.setBounds(351, 330, 98, 27);



				{
					pnlLogeo = new JPanel();
					pnlPrincipal.add(pnlLogeo);
					pnlLogeo.setLayout(null);
					//pnlLogeo.setBorder(BorderFactory.createTitledBorder("Tipo de Cambio"));
					pnlLogeo.setBounds(18, 117, 493, 436);

					//pnlLogeo.add(cboTipoUsuario);
					//cboTipoUsuario.addItem("Administrador");
					//cboTipoUsuario.addItem("Vendedor1");
					
					//cboTipoUsuario.addItemListener(this);
					
					lblTipoUsuario = new JLabel();
					pnlLogeo.add(lblTipoUsuario);
					lblTipoUsuario.setText("Usuario:");
					lblTipoUsuario.setBounds(88, 307, 82, 14);
					
					lblClave = new JLabel();
					pnlLogeo.add(lblClave);
					lblClave.setText("Clave:");
					lblClave.setBounds(88, 343, 82, 14);
					
					txtClave = new JPasswordField();
					pnlLogeo.add(txtClave);
					txtClave.setBounds(217, 340, 191, 21);

					txtCodUsuario = new JTextField();
					pnlLogeo.add(txtCodUsuario);
					txtCodUsuario.setBounds(217, 307, 191, 21);
					
					btnCancelar = new JButton();
					pnlLogeo.add(btnCancelar);
					btnCancelar.setText("Cancelar");
					btnCancelar.setBounds(325, 373, 89, 26);
					
					btnIngresar = new JButton();
					pnlLogeo.add(btnIngresar);
					btnIngresar.setText("Aceptar");
					btnIngresar.setBounds(88, 373, 86, 26);
					btnIngresar.addActionListener(this);
					frozen = true; //iniciamos el estado en congelado
				

					/*lblLogeo = new JLabel();
				pnlDatos.add(lblLogeo);
			//	lblLogeo.setIcon(new ImageIcon("Images/cel.gif").getImage())
				//lblLogeo.setI
				//lblLogeo.setText("Fecha:");
				//lblLogeo.setBounds(17, 27, 44, 14);*/
					lblLogeo = new JLabel(imagen);
					pnlLogeo.add(lblLogeo);
					lblLogeo.setBounds(100, 19, 294, 256);

					//lblLogeo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/INICIO.gif")));

					 
					
					pack();
					
				}

//				lblImagen3 = new JLabel(imagen3);
//				pnlPrincipal.add(lblImagen3);
//				lblImagen3.setBounds(0, 0, 545, 105);

				lblImagen2 = new JLabel(imagen2);
				pnlDatos.add(lblImagen2);
				lblImagen2.setBounds(109, 19, 319, 263);

			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnIngresar){
			metodoIngresar2();
		}
		
	}

	private void metodosIngresar() {
		pnlLogeo.setVisible(false);
		pnlDatos.setVisible(true);
		
	}
	private void metodoIngresar2(){ 
		this.setVisible(false); 
		objMenu=null;
		objMenu=new MenuPrincipal();
		objMenu.setIconImage(new ImageIcon(cl.getResource("Images/cel.gif")).getImage());
		objMenu.setTitle("Proyecto Almacen Universidad v2");
	}
	
	
					
	}


