package Edd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Edd.NodoMatriz.mouse;

public class MatrixPersonaje extends JPanel{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ListaCabezera cabezera;
 ListaLateral lateral;
int filas,columnas;
 public JLabel mario;
 public MatrixPersonaje(){
	 cabezera=new ListaCabezera();//iniciando cabezera y lateral
	 lateral=new ListaLateral();
	 this.setSize(800, 600);
	 this.setLayout(null);
	 //NodoMatriz nodo = new NodoMatriz(10,100,1,1,null,"/celeste.png");
	 //nodo.setBounds(100,110,40,40);
     //add(nodo);
 }
 
 public void agregar(int x,int y,int x2,int y2,Personaje personaje,String imagen ){
	 NodoMatriz nodo = new NodoMatriz(x,y,x2,y2,personaje,imagen);
	 if(cabezera.existe(x)==false){
		 cabezera.insertar(new Cabezera(x));
	 }
	 if(lateral.existe(y)==false){
		 lateral.insertar(new Lateral(y));
	 }
	 Cabezera Ctemporal;
	 Lateral Ltemporal;
	 Ctemporal=cabezera.buscar(x2);
	 Ltemporal=lateral.buscar(y2);
	 Ctemporal.getColumna().insertar(nodo);	
	 Ltemporal.getFila().insertar(nodo);
	 nodo.setBounds(new Rectangle(x,y,40,40));
	 this.add(nodo);
	 System.out.println("se inserto"+personaje.nombre);
 }
 public void llenar(int x,int y){
	 int posx = 0;
	 int posy = 0;
	 String imagen ="/celeste.png";
	 Personaje aux = new Personaje("null","null",0);
	 for(int i=0;i<x;i++){
		 for(int j=0;j<y;j++){
			 agregar(posx,posy,i,j,aux,imagen);
			 posy+=40;
		 }
		 posx+=40;
		 posy=0;
	 }
 }
 
 public void AgregarColumna(int x,int y,int x2,int y2,Personaje personaje,String imagen){
	 
 }
 
 public void AgregarFila(){
	 
 }
 
 public NodoMatriz obtener(int x,int y){
	 if(cabezera.existe(x)==false){
		 System.out.println("no hay nodo");
		 return null;
	 }
	 else{
	 Cabezera Ctemporal;
	 Ctemporal=cabezera.buscar(x);
	 return Ctemporal.getColumna().obtenerNodoy(y);
	 }
	 
 }
 
 public void imprimir(){
	 int posx = 0;
	 int posy = 0;
	 NodoMatriz aux;
	 for(int i=0;i<cabezera.tamanox;i++){
		 for(int j=0;j<lateral.tamanoy;j++){
			  aux= obtener(i,j);
			  aux.setBounds(new Rectangle(posx,posy,40,40));
			  this.add(aux);
			  posy+=40;
		 }
		 posx+=40;
		 posy=0;
	 }
 }
 
 public void obtenertamano(){
	 System.out.println(cabezera.tamanox);
	 System.out.println(lateral.tamanoy);
 }
}
