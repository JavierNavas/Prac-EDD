package Edd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Tablero extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MatrixPersonaje matriz = new MatrixPersonaje();
	JPanel pnlTablero=new JPanel();
	JScrollPane scroll = new JScrollPane();
	JButton ac,ag,ec,ef,play;
	 JLabel figura;
	Tablero(){
		Dimension d = new Dimension();
		 setLocation((int) ((d.getWidth()/2)+160), 10);
		 this.setTitle("Mario Maker Creacion de mapa");
		 this.setSize(1000,700);
		 setDefaultCloseOperation(0);//finaliza el programa cuando se da click en la X
	     setResizable(false);//quita la opcion de cambiar taman�o
	     pnlTablero.setLayout(null);
	     pnlTablero.setBounds(15,150, 900, 900);
	     ac=new JButton("Agregar Fila");
	     ac.setBounds(new Rectangle(0,10,140,30));
	     ac.addActionListener(this);
	     ag=new JButton("Agregar Columna");
	     ag.setBounds(new Rectangle(150,10,140,30));
	     ag.addActionListener(this);
	     ec=new JButton("Eliminar Columna");
	     ec.setBounds(new Rectangle(300,10,140,30));
	     ec.addActionListener(this);
	     ef=new JButton("Eliminar FIla");
	     ef.setBounds(new Rectangle(450,10,140,30));
	     ef.addActionListener(this);
	     play=new JButton("Ir a Juego");
	     play.setBounds(new Rectangle(0,45,140,30));
	     play.addActionListener(this);
	     matriz.llenar(4, 2);
	     pnlTablero.add(matriz);
	     getContentPane().setLayout(null);
	     getContentPane().add(ac);
	     getContentPane().add(ag);
	     getContentPane().add(ec);
	     getContentPane().add(ef);
	     getContentPane().add(play);
	     getContentPane().add(pnlTablero);
	     
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==ac) {
			
		}
if (e.getSource()==ag) {
			
		}
if (e.getSource()==ec) {
	
}
if (e.getSource()==ef) {
	
}
if (e.getSource()==play) {
	 MarioBros juego = new MarioBros();
	 JFrame pantalla = new JFrame("Mario Maker EDD");
	 pantalla.add(juego);
	 pantalla.pack();
	 pantalla.setResizable(false);
	 pantalla.setLocationRelativeTo(null);
	 pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 pantalla.setVisible(true);
	  pantalla.setFocusable(true);
     juego.start();
}
		
	}

}
