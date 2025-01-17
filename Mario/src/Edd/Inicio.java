package Edd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
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
	private JLabel mario,gomba,pared,eliga,uno,dos,tres,cuatro,cinco,seis,siete;
	JButton pa,table,btngoomba,btnficha,btnhongo,btnimprimir,btnsuelo,btnpared,btnkoopa,p;
	static JButton btnAgregarmario,btncastillo,ver;
	int cont=1;
	
	JPanel pnlpersonaje=new JPanel();
	 JScrollPane scroll = new JScrollPane();
	 static ListaPersonaje lista =new ListaPersonaje();
	 static jcPanel mi_panel = new jcPanel();

	
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
	        nombrepersonaje.setBounds(new Rectangle(250,50,125,25));
	        btnAgregarmario=new JButton("Registrar Mario");
	        btnAgregarmario.setBounds(new Rectangle(250,110,125,20));
	        btnAgregarmario.addActionListener(this);
	        btnpared=new JButton("Agregar Pared");
	        btnpared.setBounds(new Rectangle(250,170,125,20));
	        btnpared.addActionListener(this);
	        btnsuelo=new JButton("Agregar Suelo");
	        btnsuelo.setBounds(new Rectangle(250,230,125,20));
	        btnsuelo.addActionListener(this);
	        btnkoopa=new JButton("Agregar Koopa");
	        btnkoopa.setBounds(new Rectangle(250,290,125,20));
	        btnkoopa.addActionListener(this);
	        btngoomba=new JButton("Agregar Gomba");
	        btngoomba.setBounds(new Rectangle(250,350,125,20));
	        btngoomba.addActionListener(this);
	        btnficha=new JButton("Agregar Ficha");
	        btnficha.setBounds(new Rectangle(250,410,125,20));
	        btnficha.addActionListener(this);
	        btnhongo=new JButton("Agregar Hongo");
	        btnhongo.setBounds(new Rectangle(250,470,125,20));
	        btnhongo.addActionListener(this);
	        btncastillo=new JButton("Agregar Castillo");
	        btncastillo.setBounds(new Rectangle(250,530,125,20));
	        btncastillo.addActionListener(this);
	        btnimprimir=new JButton("imprimir");
	        btnimprimir.setBounds(new Rectangle(250,750,50,20));
	        btnimprimir.addActionListener(this);  
	        table=new JButton("Ir a Tablero");
	        table.setBounds(new Rectangle(450,150,150,20));
	        table.addActionListener(this);  
	        ver=new JButton("Ver lista en Graphviz");
	        ver.setBounds(new Rectangle(450,250,170,20));
	        ver.addActionListener(this);  
	        String path = "/mar1.jpeg";
	        URL url = this.getClass().getResource(path);  
	        ImageIcon icon = new ImageIcon(url);  
	        String path1 = "/pare.png";
	        URL url1 = this.getClass().getResource(path1);  
	        ImageIcon icon1 = new ImageIcon(url1);
	         String path2 = "/ground.gif"; 
	        URL url2 = this.getClass().getResource(path2);  
	        ImageIcon icon2 = new ImageIcon(url2);
	        String path3 = "/koop.png";
	        URL url3 = this.getClass().getResource(path3);  
	        ImageIcon icon3 = new ImageIcon(url3);
	        String path4 = "/goom.png";
	        URL url4 = this.getClass().getResource(path4);  
	        ImageIcon icon4 = new ImageIcon(url4);
	        String path5 = "/ficha.jpg";
	        URL url5 = this.getClass().getResource(path5);  
	        ImageIcon icon5 = new ImageIcon(url5);
	        String path6 = "/1up.gif";
	        URL url6 = this.getClass().getResource(path6);  
	        ImageIcon icon6 = new ImageIcon(url6);
	        String path7 = "/castillo.jpg";
	        URL url7 = this.getClass().getResource(path7);  
	        ImageIcon icon7 = new ImageIcon(url7);  
	        mario =new JLabel(); 
	        mario.setIcon(icon);  
	        mario.setBounds(new Rectangle(100,110,180,32));
	        eliga =new JLabel("Nombre del personaje"); 
	        eliga.setBounds(new Rectangle(100,50,180,25));
	        uno =new JLabel(); 
	        uno.setIcon(icon1);  
	        uno.setBounds(new Rectangle(100,170,180,32));
	        dos =new JLabel(); 
	        dos.setIcon(icon2);  
	        dos.setBounds(new Rectangle(100,230,180,32));
	        tres =new JLabel(); 
	        tres.setIcon(icon3);  
	        tres.setBounds(new Rectangle(100,290,180,40));
	        cuatro =new JLabel(); 
	        cuatro.setIcon(icon4);  
	        cuatro.setBounds(new Rectangle(100,350,180,32));
	        cinco =new JLabel(); 
	        cinco.setIcon(icon5);  
	        cinco.setBounds(new Rectangle(100,410,180,35));
	        seis =new JLabel(); 
	        seis.setIcon(icon6);  
	        seis.setBounds(new Rectangle(100,470,180,35));
	        siete =new JLabel(); 
	        siete.setIcon(icon7);  
	        siete.setBounds(new Rectangle(100,530,180,55));
	       

	        
	        //seleccion de personajes
	        pnlseleccion=new JPanel();
			pnlseleccion.setLayout(null);
			pnlseleccion.add(nombrepersonaje);
			pnlseleccion.add(btnAgregarmario);
			pnlseleccion.add(btnimprimir);
			pnlseleccion.add(mario);
			pnlseleccion.add(eliga);
			pnlseleccion.add(btnpared);
			pnlseleccion.add(btnsuelo);
			pnlseleccion.add(btnkoopa);
			pnlseleccion.add(btnhongo);
			pnlseleccion.add(btngoomba);
			pnlseleccion.add(btnficha);
			pnlseleccion.add(btncastillo);
			pnlseleccion.add(uno);
			pnlseleccion.add(dos);
			pnlseleccion.add(tres); 
			pnlseleccion.add(cuatro);
			pnlseleccion.add(cinco);
			pnlseleccion.add(seis);
			pnlseleccion.add(siete);
			pnlseleccion.add(table);
			pnlseleccion.add(ver);
			MenuJuego.addTab("Agregar Personaje",pnlseleccion);
			pnlpersonaje.setLayout(null);
			pnlpersonaje.setPreferredSize(new Dimension(1000, 1000)); 

			  p=new JButton("prueba");
		        p.setBounds(new Rectangle(350,250,125,20));
		        p.addActionListener(this);
		        pa=new JButton("pruebax");
		        pa.setBounds(new Rectangle(550,130,125,20));
		        pa.addActionListener(this);
			 pnlpersonaje.add(p);
			 pnlpersonaje.add(pa);
			 scroll.setViewportView(mi_panel);
			 MenuJuego.addTab("Personajes en Lista",scroll);
		
			// scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		      //  scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			
		
		      getContentPane().add(MenuJuego,BorderLayout.CENTER); 

			addWindowListener(new manVentana());
			
	     
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnAgregarmario) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"mario",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		    btnAgregarmario.setEnabled(false);
		}
		
		if (e.getSource()==btngoomba) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"goomba",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btnkoopa) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"koopa",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btncastillo) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"castillo",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btnficha) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"ficha",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btnpared) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"pared",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btnsuelo) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"suelo",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			actualizar();
			cont++;
		}
		
		if (e.getSource()==btnhongo) {
			Personaje nuevo= new Personaje(nombrepersonaje.getText(),"hongo",cont);
			lista.agregar(nuevo);
			nombrepersonaje.setText("");
			mi_panel.removeAll();
			actualizar();
			cont++;
		}
if (e.getSource()==btnimprimir) {
			lista.imprimir(pnlpersonaje);
			System.out.println(""+lista.tamano());
		}
if (e.getSource()==table) {
	Tablero inicio = new Tablero();
	inicio.setVisible(true);
	inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
if (e.getSource()==ver) {
	generartxt();
	generar();
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
	public static void BorrarPersonaje(int id) {
		if(lista.buscar(id).tipo.equals("mario")){
			btnAgregarmario.setEnabled(true);
		}
		if(lista.buscar(id).tipo.equals("castillo")){
			btncastillo.setEnabled(true);
		}
		lista.eliminar(id);
		
		
	}
	public static void ModificarPersonaje(String nombre, int id) {
		lista.modificar(nombre, id);
	}
	
	public static void actualizar(){
		mi_panel.removeAll();
		for(int i=0;i<lista.tamano();i++){
			String dinujo="";
			if(lista.obtener(i).tipo.equals("mario")){
				dinujo="/mar1.jpeg";
			}
			if(lista.obtener(i).tipo.equals("goomba")){
				dinujo="/goom.png";
			}
			if(lista.obtener(i).tipo.equals("koopa")){
				dinujo="/koop.png";
			}
			if(lista.obtener(i).tipo.equals("castillo")){
				dinujo="/castillo.jpg";
			}
			if(lista.obtener(i).tipo.equals("hongo")){
				dinujo="/1up.gif";
			}
			if(lista.obtener(i).tipo.equals("ficha")){
				dinujo="/ficha.jpg";
			}
			if(lista.obtener(i).tipo.equals("pared")){
				dinujo="/pare.png";
			}
			if(lista.obtener(i).tipo.equals("suelo")){
				dinujo="/ground.gif";
			}
			mi_panel.Mi_Componente(dinujo,lista.obtener(i).id,lista.obtener(i).nombre);
		}
		mi_panel.repaint();
	}
	
	
	public void generar(){
		   try{
		       String dotPath="C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
		       String fileInputPath="C:\\Users\\MilTon navarro\\Downloads\\data\\Desktop\\lista.txt";
		       String fileOutputPath="C:\\Users\\MilTon navarro\\Downloads\\data\\Desktop\\lista.jpg";;
		       String tParam="-Tjpg";
		       String toParam="-o";
		       String[]cmd= new String[5];
		       cmd[0]=dotPath;
		       cmd[1]=tParam;
		       cmd[2]=fileInputPath;
		       cmd[3]=toParam;
		       cmd[4]= fileOutputPath; 
		       Runtime rt = Runtime.getRuntime();
		       rt.exec(cmd);
		   }catch(Exception ex){
		       ex.printStackTrace();
		   }  finally {
		 }
		}
	
	public void generartxt(){
	    String file="C:\\Users\\MilTon navarro\\Downloads\\data\\Desktop\\lista.txt";
	    try (BufferedWriter b = new BufferedWriter(new FileWriter(file));) {
	        b.write("graph G");
	         b.write("{");
	         for (int i = 0; i <lista.tamano(); i++){
	             b.write(lista.obtener(i).tipo+"_"+lista.obtener(i).nombre);
	         if(lista.obtener(i).siguiente==null){
	        	 b.write(";");
	         }
	         else{
	        	 b.write("--"); 
	         }
	         }
	         b.write("}");
	         b.close();
	     }catch(Exception e){ 
	       	JOptionPane.showMessageDialog(null,"El Archivo no fue encontrado","Error", JOptionPane.INFORMATION_MESSAGE);
	        }  
	}
}
