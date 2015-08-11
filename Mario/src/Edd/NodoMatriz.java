package Edd;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Edd.jcPanel.mouse;

public class NodoMatriz extends JLabel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private NodoMatriz arriba=null;
private NodoMatriz abajo=null;
private NodoMatriz derecha=null;
private NodoMatriz izquierda=null;
Personaje personaje;
int x,y,x2,y2;
String imagen;


public NodoMatriz(int x,int y,int x2,int y2,Personaje personaje,String imagen) {
	this.arriba = null;
	this.abajo = null;
	this.derecha = null;
	this.izquierda = null;
	this.personaje=personaje;
	this.x=x;
	this.y=y;
	this.x2=x2;
	this.y2=y2;
	this.imagen=imagen;
	String path4 = imagen;
    URL url4 = this.getClass().getResource(path4);  
    ImageIcon icon4 = new ImageIcon(url4);
    setIcon(icon4);
    this.addMouseListener(new mouse());

    
}
public NodoMatriz getArriba() {
	return arriba;
}
public void setArriba(NodoMatriz arriba) {
	this.arriba = arriba;
}
public NodoMatriz getAbajo() {
	return abajo;
}
public void setAbajo(NodoMatriz abajo) {
	this.abajo = abajo;
}
public NodoMatriz getDerecha() {
	return derecha;
}
public void setDerecha(NodoMatriz derecha) {
	this.derecha = derecha;
}
public NodoMatriz getIzquierda() {
	return izquierda;
}
public void setIzquierda(NodoMatriz izquierda) {
	this.izquierda = izquierda;
}

public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}


public int getX2() {
	return x2;
}
public void setX2(int x2) {
	this.x2 = x2;
}
public int getY2() {
	return y2;
}
public void setY2(int y2) {
	this.y2 = y2;
}
public Personaje getPersonaje() {
	return personaje;
}
public void setPersonaje(Personaje personaje) {
	this.personaje = personaje;
}

public class mouse implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
	System.out.println("hoollla");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
}
}
