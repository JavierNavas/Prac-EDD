package Edd;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

import Edd.azulejo.Azulejo;
import Edd.azulejo.Pared;
import Edd.azulejo.Suelo;
import Edd.entity.*;
import Edd.entity.mob.Coopa;
import Edd.entity.mob.Goomba;
import Edd.entity.mob.Hongo;
import Edd.entity.mob.Jugador;
import Edd.entity.mob.Moneda;
public class Control {
public CopyOnWriteArrayList<Entity> entity = new CopyOnWriteArrayList<Entity>();
public CopyOnWriteArrayList<Azulejo> azulejo = new CopyOnWriteArrayList<Azulejo>();

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
	agregarAzulejo(new Suelo(i*64,MarioBros.ALTURA*MarioBros.ESCALA-64,64,64,true,Id.Suelo,this));
	}
	agregarEntity(new Jugador(300,512,64,64,false,Id.Jugador,this));
	agregarAzulejo(new Pared(200,490,64,64,true,Id.Pared,this));
	agregarAzulejo(new Pared(450,490,64,64,true,Id.Pared,this));
	agregarEntity(new Goomba(540,512,64,64,false,Id.goomba,this));
	agregarAzulejo(new Pared(690,520,64,64,true,Id.Pared,this));
	agregarEntity(new Coopa(700,512,64,64,false,Id.Koopa,this));
	agregarEntity(new Moneda(690,320,64,64,true,Id.Pared,this));
	
	
	
	
		
		
	
}
}
