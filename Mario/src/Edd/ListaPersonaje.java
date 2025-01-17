package Edd;

import javax.swing.JPanel;

public class ListaPersonaje {
	 public Personaje inicio;
	 public Personaje fin;
	 public Personaje moverse;
	 private int tamano;
	
	 public ListaPersonaje(){
	        this.inicio= null;
	        this.fin = null;
	        this.tamano = 0;               
	    }
	 
    public boolean vacio()
	    {
	        return(this.inicio == null);
	    }
    

	public void agregar(Personaje nuevo){
		 if(vacio())
	     {
	         inicio = nuevo;
	         fin = nuevo;
	         tamano = 1;
	         moverse=inicio;
	     }
	     else{
	         fin.siguiente= nuevo;
	         nuevo.anterior=fin;
	         fin=nuevo;
	         tamano++;
	     }
	} 
	
	public int tamano(){
	    return this.tamano;
	}
	
	public void AgregarInicio(Personaje nuevo){
        if(inicio==null){
        inicio=nuevo;
        }else{
        nuevo.siguiente=inicio;
        inicio.anterior=nuevo;
        inicio=nuevo;
        }
        }
	
	
   public Personaje cola(){
	   if(vacio())
	     {
		   return  null;
	     }
	   else{
			Personaje nuevo=inicio;
		    inicio= inicio.siguiente;
			return nuevo;
	   }

	}
   
   public Personaje eliminar(int dato)
   {
       Personaje eliminar = null;
       if(!vacio())
       {      Personaje actual = inicio;
              Personaje  anterior = inicio;
           for(int i =0;i<this.tamano;i++)
           {
               if(actual.id==dato)
               {
                   if(actual == inicio)
                   {
                       inicio = actual.siguiente;
                   }
                   if(actual == fin)
                   {
                       fin =anterior;
                       if(anterior == null)
                           fin = inicio;
                   }else{
                       anterior.siguiente = actual.siguiente;
                       
                   }
                   this.tamano--;
               }
               anterior = actual;
               actual = actual.siguiente;
           }
                           
       }
       return eliminar;
   }
   
   
   public Personaje EliminaInicio(){
		if(vacio()){
		System.out.println("No hay elementos");
		return null;
		}else if(inicio==fin){
		Personaje nuevo=inicio;
	   inicio=fin=null;
		this.tamano--;
		return nuevo;
		}
		else{
		Personaje nuevo=inicio;
		inicio=inicio.siguiente;
		this.tamano--;
		return nuevo;
		}
	}
   
   public Personaje EliminaFinal(){
       if(vacio()) {
       	System.out.println("No hay elementos");
       }
       else{
   		if(inicio==fin){
   		Personaje nuevo=inicio;
   		inicio=fin=null;
   		this.tamano--;
   		return nuevo;
   		}else{
           Personaje actual = inicio;
           Personaje anterior= inicio;
           while(actual.siguiente != null) {
               anterior=actual;
               actual =actual.siguiente;
           }
           anterior.siguiente=null;
           this.tamano--;
           return actual;
   		}
   		
     }
       return null;
   }
   
   public void modificar(String nombre,int id){
	   Personaje temp=inicio;
   	while(temp!=null){
   		if (temp.id==id){
   			temp.nombre=nombre;
   			break;
   		}
   		temp=temp.siguiente;
   	}
   }
   
   public void imprimir(JPanel panel)
   {
   	if (vacio()){
			System.out.println("la lista esta Vacia" );
		}
		else{
			Personaje Actual=inicio;
			while(Actual != null){
				System.out.print(Actual.nombre+" ");
				Actual=Actual.siguiente;
			}
			System.out.println();
		}
   }
   
	public Personaje obtener(int a){
	  Personaje actual = inicio;
	      for(int pos =0;pos<a;pos++){
	          if(actual != null){
	          actual = actual.siguiente;
	          }
	          else 
	              return null;
	      }
	    
	    return actual;
	 }
	
	public Personaje buscar(int id){
	    Personaje temp=inicio;
	    	while(temp!=null){
	    		if (temp.id==id){
	    			return temp;
	    		}
	    		temp=temp.siguiente;
	    	}
	    	return null;
	    }
}
