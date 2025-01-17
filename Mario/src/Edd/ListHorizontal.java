package Edd;

public class ListHorizontal {
	NodoMatriz primero;
	NodoMatriz ultimo;



	//clase que crea  una columna de la matriz
	public ListHorizontal() {
		this.primero = null;
		this.ultimo = null;
	}

	public void insertar(NodoMatriz insertar){
		if(vacio()){
				primero=insertar;
				ultimo=insertar;
			}else{
				if(insertar.getX2()<primero.getX2()){
					insertarFrente(insertar);
				}
				else if(insertar.getX2()>ultimo.getX2()){
					InsertarFinal(insertar);
				}else{
					InsertarMedio(insertar);
				}
			}
		}

	public boolean vacio(){
		if(primero==null ){
			return true;
		}
		else{
		return false;
		}
	}

	public void insertarFrente(NodoMatriz insertar){
		primero.setIzquierda(insertar);
		insertar.setDerecha(primero);
		primero=insertar;//el nodo agregado se vuelve el primero de la lista
	}

	public void InsertarFinal(NodoMatriz insertar){
		ultimo.setDerecha(insertar);
		insertar.setIzquierda(ultimo);
		ultimo=insertar;// el nodo ingresado se vuelve el el tultimo de la lista
	}

	public void InsertarMedio(NodoMatriz insertar){
		NodoMatriz aux1;
		NodoMatriz aux2;
		aux1=primero;
		while(aux1.getX2()<insertar.getX2()){
			aux1=aux1.getDerecha();
		}
		aux2=aux1.getIzquierda();
		aux2.setDerecha(insertar);  
		aux1.setIzquierda(insertar);
		insertar.setDerecha(aux1);
		insertar.setIzquierda(aux2);
		
				
	}

	public void recorrer(){
		if(!vacio()){
		NodoMatriz aux1=primero;
		while(aux1!=null){
		aux1=aux1.getDerecha();	
		}
	   }
	}
	
	public NodoMatriz obtenerNodox(int posicion){
	    NodoMatriz temp = primero;
	   
	    while(temp.getY()<posicion){
	        temp=temp.getAbajo();
	    }
	    
	    return temp;
	}
}
