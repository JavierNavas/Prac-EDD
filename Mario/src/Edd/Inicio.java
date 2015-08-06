package Edd;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Inicio extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	JPanel pnlseleccion;
	JTabbedPane MenuJuego;
	private JTextField texto,nombrepersonaje;
	private JLabel mario,gomba,pared;
	JLabel anuncio2 = new JLabel("Eliga hotel");
	JButton btnAgregarmario,btnAgregargoomba,btneliminar,btnimprimir;
	
	
	JPanel pnlpersonaje=new JPanel();
	 JScrollPane pnlmostrarLista= new JScrollPane();
	 ListaPersonaje lista =new ListaPersonaje();

	public Inicio(){
		Dimension d = new Dimension();
		 setLocation((int) ((d.getWidth()/2)+360), 20);
		this.setTitle("Mario Maker Seleccion de peronsaje");
		this.setSize(700,700);
		 setDefaultCloseOperation(0);//finaliza el programa cuando se da click en la X
	     setResizable(false);//quita la opcion de cambiar taman�o
	
	     MenuJuego= new JTabbedPane();
	        Dimension size = new Dimension(380,380);
	        MenuJuego.setMaximumSize(size);
	        MenuJuego.setPreferredSize(size);
	        MenuJuego.setMinimumSize(size);	
	        
	        
	        nombrepersonaje=new JTextField("");
	        nombrepersonaje.setBounds(new Rectangle(290,140,125,20));
	        btnAgregarmario=new JButton("Registrar");
	        btnAgregarmario.setBounds(new Rectangle(250,200,100,20));
	        btnAgregarmario.addActionListener(this);
	        btneliminar=new JButton("Eliminar");
	        btneliminar.setBounds(new Rectangle(450,200,100,20));
	        btneliminar.addActionListener(this);
	        btnimprimir=new JButton("imprimir");
	        btnimprimir.setBounds(new Rectangle(250,250,100,20));
	        btnimprimir.addActionListener(this);
	        //seleccion de personajes
	        pnlseleccion=new JPanel();
			pnlseleccion.setLayout(null);
			pnlseleccion.add(nombrepersonaje);
			pnlseleccion.add(btnAgregarmario);
			pnlseleccion.add(btneliminar);
			pnlseleccion.add(btnimprimir);
		
			MenuJuego.addTab("Agregar Personaje",pnlseleccion);
			
			
			pnlpersonaje.setLayout(null);
			 pnlmostrarLista.add(pnlpersonaje);
			 MenuJuego.addTab("Personajes en Lista",pnlmostrarLista);
			
			this.getContentPane().add(MenuJuego);
			addWindowListener(new manVentana());
	     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnAgregarmario) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText());
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			System.out.println("hola");
		}
if (e.getSource()==btnimprimir) {
			lista.imprimir();
			System.out.println(""+lista.tamano());
		}
if (e.getSource()==btneliminar) {
	System.out.println(lista.EliminaInicio()+"sssad");
//lista.eliminar(nombrepersonaje.getText());
		System.out.println(nombrepersonaje.getText()+"sss");

	
	
}
		
		
	}

	public class manVentana implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent e) {
			
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			PreguntaCerrar();
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public void PreguntaCerrar()
	{
		int Opcion;
			Opcion = JOptionPane.showConfirmDialog(this,"Desea Salir del programa","Mensaje",JOptionPane.YES_NO_OPTION);
			if (Opcion == JOptionPane.YES_OPTION) 
			{
				System.exit(0);
			}				
	}
	
}