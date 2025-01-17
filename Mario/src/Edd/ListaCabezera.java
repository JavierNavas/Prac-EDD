package Edd;

public class ListaCabezera {
Cabezera primero;
Cabezera ultimo;
int tamanox;

ListaCabezera() {
	this.primero = null;
	this.ultimo = null;
	this.tamanox = 0; 
}

public void insertar(Cabezera insertar){
	if(vacio()){
			primero=insertar;
			ultimo=insertar;
			tamanox++;
		}else{
			if(insertar.getX()<primero.getX()){
				insertarFrente(insertar);
				tamanox++;
			}
			else if(insertar.getX()>ultimo.getX()){
				InsertarFinal(insertar);
				tamanox++;
			}else{
				InsertarMedio(insertar);
				tamanox++;
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

public void insertarFrente(Cabezera insertar){
	primero.setAnterior(insertar);
	insertar.setSiguiente(primero);
	primero=insertar;//el nodo agregado se vuelve el primero de la lista
}

public void InsertarFinal(Cabezera insertar){
	ultimo.setSiguiente(insertar);
	insertar.setAnterior(ultimo);
	ultimo=insertar;// el nodo ingresado se vuelve el el tultimo de la lista
}

public void InsertarMedio(Cabezera insertar){
	Cabezera aux1; 
	Cabezera aux2;
	aux1=primero;
	while(aux1.getX()<insertar.getX()){
		aux1=aux1.getSiguiente();
	}
	aux2=aux1.getAnterior();
	aux2.setSiguiente(insertar);  
	aux1.setAnterior(insertar);
	insertar.setSiguiente(aux1);
	insertar.setAnterior(aux2);                                                       
	
			
}

public void recorrer(){
	if(!vacio()){
	Cabezera aux1=primero;
	while(aux1!=null){
	aux1=aux1.getSiguiente();	
	}
   }
}

public Cabezera buscar(int x){
	if(existe(x)){
		Cabezera aux;
		aux=primero;
		while(aux.getX()!=x){
			aux=aux.siguiente;
		}
		return aux;
	}else{
		return(new Cabezera(-1)); 
	}
	
}

public boolean existe(int x){
	if(vacio()){
		return false;
	}
	else{
		Cabezera aux;
		aux=primero;
		while(aux!=null){
			if(aux.getX()==x){
				System.out.println("si lo encontre");
				return true;
				
			}
			else if(aux.siguiente==null){
				System.out.println("no lo encontre");
				return false;
			}
			aux=aux.siguiente;
		}
	}
	return false;
 }

}
