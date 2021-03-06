package com.almacen.prototipos.principal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.almacen.prototipos.dexterna.InformeDevolucionRegistrarE_JInternalFrame;
import com.almacen.prototipos.dinterna.InformeDevolucionRegistrarI_JInternalFrame;
import com.almacen.prototipos.mantenimientos.DetalleProductoListado_JInternalFrame;
import com.almacen.prototipos.mantenimientos.MarcaListado_JInternalFrame;
import com.almacen.prototipos.mantenimientos.ProductoListado_JInternalFrame;
import com.almacen.prototipos.mantenimientos.ProveedorListado_JInternalFrame;
import com.almacen.prototipos.mantenimientos.UMedidaListado_JDialog;
import com.almacen.prototipos.mantenimientos.UMedidaListado_JInternalFrame;
import com.almacen.prototipos.recepcionmateriales.RecepcionMaterialesRegistro_JInternalFrame;
import com.almacen.prototipos.salidamateriales.SalidaMaterialesRegistrarI_JInternalFrame;
import com.almacen.prototipos.seguridad.Logueo;
import com.almacen.prototipos.spexterna.CotizacionRegistrar_JInternalFrame;
import com.almacen.prototipos.spexterna.EvaluarPedido_JInternalFrame;
import com.almacen.prototipos.spexterna.OrdenCompraRegistrar_JInternalFrame;
import com.almacen.prototipos.spinterna.RegistrarPedido_JInternalFrame;
import com.almacen.prototipos.transacciones.TranCotizacion;


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
public class MenuPrincipal extends JFrame implements ActionListener {
	private JMenuBar jMenuBar1;
	public static JDesktopPane jDesktopPane1;

	private JMenu jMenu8;
	private JMenu jMenu2;
	private JMenu jMenu1;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	private JMenuItem mniAcerca;
	private JMenuItem mniInformeRecepcion;
	private JMenuItem mniInformeSalida;
	private JMenuItem mniInformeDevolucion;
	private JMenuItem mniInformeDevolucionRegistrar;
	private JMenuItem mniImprimir;
	private JMenuItem mniEnviar;
	private JMenuItem mniNuevaCotizacion;
	private JMenuItem mniNuevaOC;
	private JMenu mnuEntradaMateriales;
	private JMenu mnuSalidaMateriales;
	private JMenu mnuDevolucionExterna;
	private JMenu mnuDevolucionInterna;
	private JMenu mnuSolicicitudPedidoExterna;
	private JMenu mnuSolicitudPedidoInterna;
	private JMenuItem mniEvaluarPedido;
	private JMenuItem mniRegistroPedido;
	private JMenuItem mniListadoUMedida;
	private JMenuItem mniNuevoUMedida;
	private JMenuItem mniNuevoProducto;
	private JButton btnCotizacionMant;
	private JButton btnCotizacion;
	private JButton btnTranProducto;
	private JButton btnMarca;
	private JButton btnProducto;
	private JMenuItem mniIrA;
	private JRadioButtonMenuItem mniLook4;
	private JRadioButtonMenuItem mniLook3;
	private JRadioButtonMenuItem mniLook2;
	private JRadioButtonMenuItem mniLook1;
	private JMenu mnuOpciones;
	private JMenuItem mniSalir;
	private JButton btnProveedor;
	private JButton btnCliente;
	private JToolBar jToolBar1;

	private UIManager.LookAndFeelInfo apariencias[];//devuleve la kntidad de apariencias q tenga la maquina
	private JMenuItem mniDetalleProducto;
	private JMenu mnuUMedida;
	private JMenuItem mniListadoProducto;
	private JMenu mnuProducto;
	private JMenuItem mniNuevoProveedor;
	private JMenuItem mniListadoProveedor;
	private JMenu mnuProveedor;
	private JMenuItem mniListadoMarca;
	private JMenuItem mniNuevaMarca;
	private JMenu mnuMarca;
	private JPanel jPanel1;
	private JRadioButtonMenuItem rbiapariencia[];
	String[] nomApariencias;
	Logueo objLog;
	public static int estado,conta,num;
	
	ClassLoader cl = this .getClass().getClassLoader(); 
//	Icon imagen1  = new ImageIcon(cl.getResource("Images/clientes.jpg"));
//	Icon imagen2  = new ImageIcon(cl.getResource("Images/proveedor.jpg"));
//	Icon imagen3  = new ImageIcon(cl.getResource("Images/producto.jpg"));
//	Icon imagen4  = new ImageIcon(cl.getResource("Images/marca.jpg"));
//	Icon imagen5  = new ImageIcon(cl.getResource("Images/transacciondeproducto.gif"));
//	Icon imagen6  = new ImageIcon(cl.getResource("Images/cotizacioningreso.jpg"));
//	Icon imagen7  = new ImageIcon(cl.getResource("Images/cotizacionmatenimiento.jpg"));
	
	/*ImageIcon imagen1 = new ImageIcon("Images/clientes.jpg");
	ImageIcon imagen2 = new ImageIcon("Images/proveedor.jpg");
	ImageIcon imagen3 = new ImageIcon("Images/producto.jpg");
	ImageIcon imagen4 = new ImageIcon("Images/marca.jpg");
	ImageIcon imagen5 = new ImageIcon("Images/transacciondeproducto.gif");
	ImageIcon imagen6 = new ImageIcon("Images/cotizacioningreso.jpg");
	ImageIcon imagen7 = new ImageIcon("Images/cotizacionmatenimiento.jpg");*/
 
	TranCotizacion objTranCotizacion; 
	
	
	
	
	UMedidaListado_JInternalFrame umedidaListado;
	MarcaListado_JInternalFrame marcaListado;
	ProveedorListado_JInternalFrame proveedorListado;
	ProductoListado_JInternalFrame productoListado;
	
	DetalleProductoListado_JInternalFrame detalleProductoListado;
	RegistrarPedido_JInternalFrame registroPedido;
	EvaluarPedido_JInternalFrame evaluarPedido;
	CotizacionRegistrar_JInternalFrame cotizacionRegistrar;
	OrdenCompraRegistrar_JInternalFrame ordenCompra;
	
	InformeDevolucionRegistrarI_JInternalFrame informeDevolucionI;
	InformeDevolucionRegistrarE_JInternalFrame informeDevolucionE;
	
	SalidaMaterialesRegistrarI_JInternalFrame salidaMaterialesR;
	RecepcionMaterialesRegistro_JInternalFrame recepcionMaterialesR;
	
	
 
	public MenuPrincipal() {
		try {
			//this.setExtendedState(this.MAXIMIZED_BOTH);
			this.setPreferredSize(new java.awt.Dimension(screenSize));
		//	this.setContentPane(new miLib.Contenedor());
			//this.pa
			//this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Logo.gif")).getImage());
			this.setBounds(0, 0, 890, 685);
			this.setVisible(true);

			jMenuBar1 = new JMenuBar();
			setJMenuBar(jMenuBar1);

			jMenu1 = new JMenu();
			FlowLayout jMenu1Layout = new FlowLayout();
			jMenu1.setLayout(jMenu1Layout);
			jMenuBar1.add(jMenu1);
			jMenu1.setText("Inicio");
			jMenu1.setPreferredSize(new java.awt.Dimension(48, 21));

			mniSalir = new JMenuItem();
			jMenu1.add(mniSalir);
			mniSalir.setText("Salida");
			mniSalir.addActionListener(this);

			mniIrA = new JMenuItem();
			jMenu1.add(mniIrA);
			mniIrA.setText("Ir a....");
			mniIrA.addActionListener(this);

			 jMenu1.addSeparator();

			mnuOpciones = new JMenu();
			jMenu1.add(mnuOpciones);
			mnuOpciones.setText("Opciones");

			/*mniLook1 = new JRadioButtonMenuItem();
			mnuOpciones.add(mniLook1);
			mniLook1.setText("Look \"1\"");
			mniLook1.setOpaque(false);

			mniLook2 = new JRadioButtonMenuItem();
			mnuOpciones.add(mniLook2);
			mniLook2.setText("Look \"2\"");

			mniLook3 = new JRadioButtonMenuItem();
			mnuOpciones.add(mniLook3);
			mniLook3.setText("Look \"3\"");

			mniLook4 = new JRadioButtonMenuItem();
			mnuOpciones.add(mniLook4);
			mniLook4.setText("Look \"4\"");
			mniLook4.addActionListener(this);
			mnuOpciones.addSeparator();*/
			
			//tiene q ver con toda la pariencia
			apariencias = UIManager.getInstalledLookAndFeels();//llena con la kntidad de apariencias q tiene la maquina instalada
			rbiapariencia= new JRadioButtonMenuItem[apariencias.length];
			nomApariencias = new String[apariencias.length];
			 ButtonGroup grupo=new ButtonGroup();
			for(int i=0; i<apariencias.length; i++) {
				nomApariencias[i] = apariencias[i].getName();
			   rbiapariencia[i]=new JRadioButtonMenuItem();
			   rbiapariencia[i].addActionListener(this);
			   rbiapariencia[i].setText(nomApariencias[i]);
			   mnuOpciones.add(rbiapariencia[i]);
			   grupo.add(rbiapariencia[i]);
			}
			
			//mniLook3.addActionListener(this);

			//mniLook2.addActionListener(this);

//			mniLook1.addActionListener(this);

			jMenu2 = new JMenu();
			jMenuBar1.add(jMenu2);
			jMenu2.setMnemonic(java.awt.event.KeyEvent.VK_M);
			jMenu2.setText("Mantenimiento");
			jMenu2.setBounds(94, 0, 75, 21);
			
			//jMenuItem3.setAccelerator(KeyStroke.getKeyStroke("alt Z"));

			//jMenuItem4.setAccelerator(KeyStroke.getKeyStroke("alt X"));

			//jMenuItem5.setAccelerator(KeyStroke.getKeyStroke("alt C"));

			//jMenuItem1.setAccelerator(KeyStroke.getKeyStroke("alt D"));

			jMenu2.addSeparator();
			//mnuAlternativo.addSeparator();

			mniDetalleProducto = new JMenuItem();
			jMenu2.add(mniDetalleProducto);
			mniDetalleProducto.setText("Asignar Precio y Proveedor a Producto");
			{
				mnuUMedida = new JMenu();
				jMenu2.add(mnuUMedida);
				mnuUMedida.setText("U.Medida");
				mnuUMedida.setBounds(76, 189, 73, 21);
				{
					mniNuevoUMedida = new JMenuItem();
					mnuUMedida.add(mniNuevoUMedida);
					mniNuevoUMedida.setText("Nuevo");
					mniNuevoUMedida.addActionListener(this);
				}
				{
					mniListadoUMedida = new JMenuItem();
					mnuUMedida.add(mniListadoUMedida);
					mniListadoUMedida.setText("Listado");
					mniListadoUMedida.addActionListener(this);
				}
			}
			{
				mnuProveedor = new JMenu();
				jMenu2.add(mnuProveedor);
				mnuProveedor.setText("Proveedor");
				mnuProveedor.setBounds(68, 147, 86, 21);
				{
					mniNuevoProveedor = new JMenuItem();
					mnuProveedor.add(mniNuevoProveedor);
					mniNuevoProveedor.setText("Nuevo");
					mniNuevoProveedor.addActionListener(this);
				}
				{
					mniListadoProveedor = new JMenuItem();
					mnuProveedor.add(mniListadoProveedor);
					mniListadoProveedor.setText("Listado");
					mniListadoProveedor.addActionListener(this);
				}
			}
			{
				mnuMarca = new JMenu();
				jMenu2.add(mnuMarca);
				mnuMarca.setText("Marca");
				{
					mniNuevaMarca = new JMenuItem();
					mnuMarca.add(mniNuevaMarca);
					mniNuevaMarca.setText("Nueva");
					mniNuevaMarca.addActionListener(this);
				}
				{
					mniListadoMarca = new JMenuItem();
					mnuMarca.add(mniListadoMarca);
					mniListadoMarca.setText("Listado");
					mniListadoMarca.addActionListener(this);
				}
			}
			{
				mnuProducto = new JMenu();
				jMenu2.add(mnuProducto);
				mnuProducto.setText("Producto");
				{
					mniNuevoProducto = new JMenuItem();
					mnuProducto.add(mniNuevoProducto);
					mniNuevoProducto.setText("Nuevo");
					mniNuevoProducto.addActionListener(this);
				}
				{
					mniListadoProducto = new JMenuItem();
					mnuProducto.add(mniListadoProducto);
					mniListadoProducto.setText("Listado");
					mniListadoProducto.addActionListener(this);
				}
			}
			mniDetalleProducto.addActionListener(this);

			//jMenuItem8.setAccelerator(KeyStroke.getKeyStroke("alt F"));

			//KeyStroke ctrlP = KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK);

			//jMenuItem2.setAccelerator(KeyStroke.getKeyStroke("alt C"));

			//mnuiCotizacionAutIngreso.setAccelerator(KeyStroke.getKeyStroke("alt H"));

			{
				mnuSolicitudPedidoInterna = new JMenu();
				jMenuBar1.add(mnuSolicitudPedidoInterna);
				mnuSolicitudPedidoInterna.setText("Solicitud Pedido Interna");
				{
					mniRegistroPedido = new JMenuItem();
					mnuSolicitudPedidoInterna.add(mniRegistroPedido);
					mniRegistroPedido.setText("Registro Pedido");
					mniRegistroPedido.setBounds(-124, 23, 95, 21);
					mniRegistroPedido.addActionListener(this);
				}
			}
			{
				mnuSolicicitudPedidoExterna = new JMenu();
				jMenuBar1.add(mnuSolicicitudPedidoExterna);
				mnuSolicicitudPedidoExterna.setText("Solciitud Pedido Externa");
				{
					mniEvaluarPedido = new JMenuItem();
					mnuSolicicitudPedidoExterna.add(mniEvaluarPedido);
					mniEvaluarPedido.setText("Evaluar Pedido");
					mniEvaluarPedido.setBounds(-245, 23, 95, 21);
					mniEvaluarPedido.addActionListener(this);
				}
				{
					mniNuevaOC = new JMenuItem();
					mnuSolicicitudPedidoExterna.add(mniNuevaOC);
					mniNuevaOC.setText("Nueva OC");
					mniNuevaOC.addActionListener(this);
				}
				{
					mniNuevaCotizacion = new JMenuItem();
					mnuSolicicitudPedidoExterna.add(mniNuevaCotizacion);
					mniNuevaCotizacion.setText("Nueva Cotizacion");
					mniNuevaCotizacion.addActionListener(this);
				}
				{
					mniEnviar = new JMenuItem();
					mnuSolicicitudPedidoExterna.add(mniEnviar);
					mniEnviar.setText("Enviar");
					mniEnviar.addActionListener(this);
				}
				{
					mniImprimir = new JMenuItem();
					mnuSolicicitudPedidoExterna.add(mniImprimir);
					mniImprimir.setText("Imprimir");
					mniImprimir.addActionListener(this);
				}
			}
			{
				mnuDevolucionInterna = new JMenu();
				jMenuBar1.add(mnuDevolucionInterna);
				mnuDevolucionInterna.setText("Devolucion Interna");
				{
					mniInformeDevolucionRegistrar = new JMenuItem();
					mnuDevolucionInterna.add(mniInformeDevolucionRegistrar);
					mniInformeDevolucionRegistrar.setText("Informe Devolucion");
					mniInformeDevolucionRegistrar.addActionListener(this);
				}
			}
			{
				mnuDevolucionExterna = new JMenu();
				jMenuBar1.add(mnuDevolucionExterna);
				mnuDevolucionExterna.setText("Devolucion Externa");
				{
					mniInformeDevolucion = new JMenuItem();
					mnuDevolucionExterna.add(mniInformeDevolucion);
					mniInformeDevolucion.setText("Informe Devolucion");
					mniInformeDevolucion.addActionListener(this);
				}
			}
			{
				mnuSalidaMateriales = new JMenu();
				jMenuBar1.add(mnuSalidaMateriales);
				mnuSalidaMateriales.setText("Salida Materiales");
				{
					mniInformeSalida = new JMenuItem();
					mnuSalidaMateriales.add(mniInformeSalida);
					mniInformeSalida.setText("Informe Salida");
					mniInformeSalida.addActionListener(this);
				}
			}
			{
				mnuEntradaMateriales = new JMenu();
				jMenuBar1.add(mnuEntradaMateriales);
				mnuEntradaMateriales.setText("Entrada Materiales");
				{
					mniInformeRecepcion = new JMenuItem();
					mnuEntradaMateriales.add(mniInformeRecepcion);
					mniInformeRecepcion.setText("Informe Recepcion");
					mniInformeRecepcion.addActionListener(this);
				}
			}
			{
				jMenu8 = new JMenu();
				jMenuBar1.add(jMenu8);
				jMenu8.setText("Ayuda");
				jMenu8.setBounds(-861, -65, 10, 10);
				{
					mniAcerca = new JMenuItem();
					jMenu8.add(mniAcerca);
					mniAcerca.setText("Acerca..");
					mniAcerca.addActionListener(this);
				}
			}
			
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			setVisible(true);

			jDesktopPane1 = new JDesktopPane();
			getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
			jDesktopPane1.setLayout(null);
			jDesktopPane1.setPreferredSize(new java.awt.Dimension(857, 430));
			jDesktopPane1.setBackground(new java.awt.Color(0,0,255));
			jDesktopPane1.setFont(new java.awt.Font("Arial",1,28));
			jDesktopPane1.setForeground(new java.awt.Color(255,255,0));
			jDesktopPane1.setBorder(BorderFactory.createTitledBorder(null, "Proyecto Almacenes Universidad", TitledBorder.CENTER, TitledBorder.TOP, new java.awt.Font("Dialog",1,48), new java.awt.Color(255,255,0)));
			jDesktopPane1.setDebugGraphicsOptions(DebugGraphics.BUFFERED_OPTION);

			jToolBar1 = new JToolBar();
			getContentPane().add(jToolBar1, BorderLayout.SOUTH);
			jToolBar1.setBounds(0, -1, 884, 139);
			jToolBar1.setPreferredSize(new java.awt.Dimension(882, 30));

//			btnCliente = new JButton(imagen1);
//			jToolBar1.add(btnCliente);

//			btnProveedor = new JButton(imagen2);
//			jToolBar1.add(btnProveedor);

//			btnProducto = new JButton(imagen3);
//			jToolBar1.add(btnProducto);

//			btnMarca = new JButton(imagen4);
//			jToolBar1.add(btnMarca);

//			btnTranProducto = new JButton(imagen5);
//			jToolBar1.add(btnTranProducto);

//			btnCotizacion = new JButton(imagen6);
//			jToolBar1.add(btnCotizacion);

//			btnCotizacionMant = new JButton(imagen7);
//			jToolBar1.add(btnCotizacionMant);
//			btnCotizacionMant.addActionListener(this);

//			btnCotizacion.addActionListener(this);

//			btnTranProducto.addActionListener(this);

//			btnMarca.addActionListener(this);

//			btnProducto.addActionListener(this);

//			btnProveedor.addActionListener(this);

//			btnCliente.addActionListener(this);

			/*
			jPanel1 = new JPanel();
			jDesktopPane1.add(jPanel1);
			jPanel1.setLayout(null);*/

		//	btnCliente.setPreferredSize(new java.awt.Dimension(77, 59));

			//btnProveedor.setPreferredSize(new java.awt.Dimension(315, 111));

			pack();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		addWindowListener(new WindowAdapter() {
//	        public void windowClosing(WindowEvent e) {
//	            int n = JOptionPane.showConfirmDialog(e.getWindow(),"�Desea Cerrar el Sistema?", "Se Cerrar� el Sistema",
//	            		JOptionPane.YES_NO_OPTION);
//				switch (n){
//				case JOptionPane.YES_OPTION:
//					objLog=null;
//					objLog=new Logueo();   
//					System.exit(0);
//					break;
//				case JOptionPane.NO_OPTION:
//					break;
//				default:
//					System.out.println("CERO");
//				}           
//	        }
//		});
		
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	//	this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("BARRIO.JPG")).getImage());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mniSalir){
			System.out.println("entra mela");
			
			int n = JOptionPane.showConfirmDialog(this,"�Desea Cerrar el Sistema?", "Se Cerrar� el Sistema",
            		JOptionPane.YES_NO_OPTION);
			switch (n){
			case JOptionPane.YES_OPTION:
				objLog=null;
				objLog=new Logueo();
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				break;
			default:
				System.out.println("CERO");
			}   
					
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
		//mniIrA
		if(e.getSource()==mniIrA){
			   try {
				Runtime.getRuntime().exec("C:/Archivos de programa/Internet Explorer/iexplore.exe http://www.corporacionelectricalima.com/");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//radioButton seleccionado
		for(int i=0;i<rbiapariencia.length;i++){
			if(e.getSource()==rbiapariencia[i])
				rbiPulsado(i);
		} 
		if(e.getSource()==mniListadoMarca){
			if(marcaListado==null||marcaListado.isClosed()){
				marcaListado= new MarcaListado_JInternalFrame();
				jDesktopPane1.add(marcaListado);}
			try {marcaListado.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniListadoProveedor){
			if(proveedorListado==null||proveedorListado.isClosed()){
				proveedorListado= new ProveedorListado_JInternalFrame();
				jDesktopPane1.add(proveedorListado);}
			try {proveedorListado.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniListadoProducto){
			if(productoListado==null||productoListado.isClosed()){
				productoListado= new ProductoListado_JInternalFrame();
				jDesktopPane1.add(productoListado);}
			try {productoListado.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniListadoUMedida){
			if(umedidaListado==null||umedidaListado.isClosed()){
				umedidaListado= new UMedidaListado_JInternalFrame();
				jDesktopPane1.add(umedidaListado);}
			try {umedidaListado.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniDetalleProducto){
			if(detalleProductoListado==null||detalleProductoListado.isClosed()){
				detalleProductoListado= new DetalleProductoListado_JInternalFrame();
				jDesktopPane1.add(detalleProductoListado);}
			try {detalleProductoListado.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniRegistroPedido){
			if(registroPedido==null||registroPedido.isClosed()){
				registroPedido= new RegistrarPedido_JInternalFrame();
				jDesktopPane1.add(registroPedido);}
			try {registroPedido.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniEvaluarPedido){
			if(evaluarPedido==null||evaluarPedido.isClosed()){
				evaluarPedido= new EvaluarPedido_JInternalFrame();
				jDesktopPane1.add(evaluarPedido);}
			try {evaluarPedido.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		} 
		if(e.getSource()==mniInformeDevolucionRegistrar){
			if(informeDevolucionI==null||informeDevolucionI.isClosed()){
				informeDevolucionI= new InformeDevolucionRegistrarI_JInternalFrame();
				jDesktopPane1.add(informeDevolucionI);}
			try {informeDevolucionI.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniNuevaCotizacion){
			if(cotizacionRegistrar==null||cotizacionRegistrar.isClosed()){
				cotizacionRegistrar= new CotizacionRegistrar_JInternalFrame();
				jDesktopPane1.add(cotizacionRegistrar);}
			try {cotizacionRegistrar.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniNuevaOC){
			if(ordenCompra==null||ordenCompra.isClosed()){
				ordenCompra= new OrdenCompraRegistrar_JInternalFrame();
				jDesktopPane1.add(ordenCompra);}
			try {ordenCompra.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniInformeDevolucion){
			if(informeDevolucionE==null||informeDevolucionE.isClosed()){
				informeDevolucionE= new  InformeDevolucionRegistrarE_JInternalFrame();
				jDesktopPane1.add(informeDevolucionE);}
			try {informeDevolucionE.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniInformeSalida){
			if(salidaMaterialesR==null||salidaMaterialesR.isClosed()){
				salidaMaterialesR= new SalidaMaterialesRegistrarI_JInternalFrame();
				jDesktopPane1.add(salidaMaterialesR);}
			try {salidaMaterialesR.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniInformeRecepcion){
			if(recepcionMaterialesR==null||recepcionMaterialesR.isClosed()){
				recepcionMaterialesR= new RecepcionMaterialesRegistro_JInternalFrame();
				jDesktopPane1.add(recepcionMaterialesR);}
			try {recepcionMaterialesR.setSelected(true);
				} catch (java.beans.PropertyVetoException e2) {}
		}
		if(e.getSource()==mniAcerca){
			JOptionPane.showMessageDialog(null,"=D");
//			if(ordenCompra==null||ordenCompra.isClosed()){
//				ordenCompra= new OrdenCompraRegistrar_JInternalFrame();
//				jDesktopPane1.add(ordenCompra);}
//			try {ordenCompra.setSelected(true);
//				} catch (java.beans.PropertyVetoException e2) {}
		}
		
		
	}
	
	
	void rbiPulsado(int i){ 
	     try {
	       UIManager.setLookAndFeel(apariencias[i].getClassName());
	       SwingUtilities.updateComponentTreeUI(this);
	     }
	     catch(Exception ex) {
	       ex.printStackTrace();
	     }
	 }


}
