package Edd;

public class Personaje {
	Personaje siguiente;
	Personaje anterior;
	String nombre;
	String tipo;
	int id;
	
	Personaje(){
		this.siguiente = null;
		this.anterior = null;
	}
	Personaje(String nombre,String tipo,int id){
		this.nombre=nombre;
		this.tipo=tipo;
		this.id=id;
		this.siguiente = null;
		this.anterior = null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
