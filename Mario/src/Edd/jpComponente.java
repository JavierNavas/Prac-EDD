package Edd;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jpComponente extends JPanel {
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton btn,btn2;
JTextField nombrepersonaje;
JLabel label1,label2;
	public jpComponente( int index ) {
		   //JPanel
		
		 nombrepersonaje=new JTextField();
	        nombrepersonaje.setBounds(new Rectangle(140,50,125,25));
        btn=new JButton("Eliminar");
        btn.setBounds(new Rectangle(10,10,12,20));
        btn2=new JButton("Modificar Nombre");
        btn2.setBounds(new Rectangle(10,10,12,20));
        label1 =new JLabel();   
        label1.setBounds(new Rectangle(100,530,180,55));
        label2 =new JLabel();   
        label2.setBounds(new Rectangle(150,530,180,55));
		   setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		   this.setPreferredSize(new Dimension(300, 100));
		   this.add(label1);
		   this.add(label2);
		   this.add(nombrepersonaje);
		   this.add(btn);
		   this.add(btn2);
		   
		   this.setVisible(true);
		   //se agrega un comando al boton
		   this.btn.setActionCommand("key_" + index);
		   this.btn2.setActionCommand("ley2_" + index);
		}
}
