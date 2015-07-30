package Edd;
import java.awt.Graphics;
import java.util.LinkedList;

import Edd.azulejo.Azulejo;
import Edd.azulejo.Pared;
import Edd.entity.*;
import Edd.entity.mob.Goomba;
import Edd.entity.mob.Jugador;
public class Control {
public LinkedList<Entity> entity = new LinkedList<Entity>();
public LinkedList<Azulejo> azulejo = new LinkedList<Azulejo>();

public  Control(){
	
}
public void render(Graphics g){
	  for(Entity en:entity){
		  en.render(g);
	  }
	  for(Azulejo en:azulejo){
		  en.render(g);
	  }
}

public void tick(){
	for(Entity en:entity){
		  en.tick();
	  }
	  for(Azulejo en:azulejo){
		  en.tick();
	  }
}

public void agregarEntity(Entity en){
	entity.add(en);
}
public void EliminarEntity(Entity en){
	entity.remove(en);
}
public void agregarAzulejo(Azulejo en){
	azulejo.add(en);
}
public void EliminarAzulejo(Azulejo en){
	azulejo.remove(en);
}

public void crearnivel(){
for(int i=0;i<MarioBros.ANCHO*MarioBros.ESCALA/64+1;i++){
	agregarAzulejo(new Pared(i*64,MarioBros.ALTURA*MarioBros.ESCALA-64,64,64,true,Id.Pared,this));
	}
	agregarEntity(new Jugador(300,512,64,64,false,Id.Jugador,this));
	agregarAzulejo(new Pared(200,490,64,64,true,Id.Pared,this));
	agregarAzulejo(new Pared(450,490,64,64,true,Id.Pared,this));
	agregarEntity(new Goomba(540,512,64,64,false,Id.goomba,this));
	agregarAzulejo(new Pared(690,520,64,64,true,Id.Pared,this));
	
	
		
		
	
}
}
