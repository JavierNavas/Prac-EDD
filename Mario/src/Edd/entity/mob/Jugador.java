package Edd.entity.mob;

import java.awt.Graphics;

import Edd.Control;
import Edd.Id;
import Edd.MarioBros;
import Edd.azulejo.Azulejo;
import Edd.entity.Entity;

public class Jugador extends Entity{
	private int frame=0;
	private int framedelay=0;
	
   private boolean animacion = false;
	public Jugador(int x, int y, int ancho, int altura, boolean solid, Id id, Control control) {
		super(x, y, ancho, altura, solid, id, control);
	
	}

	@Override
	public void render(Graphics g) {
		if(caras==0){
		g.drawImage(MarioBros.mario[frame].getBufferedImage(),x,y,ancho,altura,null);
  	   }
	   if(caras==1){
			g.drawImage(MarioBros.mario[frame+5].getBufferedImage(),x,y,ancho,altura,null);
	  	   }
	}

	@Override
	public void tick() {
		x+=velx;
	    y+=vely;
		if(x<=0) x=0;
		if(y<=0) y =0;
		if(x+ancho>=1000) x=1000-ancho;
		if(y+altura>=700) y=700-altura;
		if(velx!=0){
			animacion=true;
		}else{
			animacion=false;
		}
		for(Azulejo t:control.azulejo){
			if(!t.solid) break;
			if(t.isSolid()&&(t.getId()==Id.Pared|| t.getId()==Id.Suelo||t.getId()==Id.Moneda)){
				if(getLimiteArriba().intersects(t.getLimites())){
					setVely(0);
					y=t.getY()+t.altura;
					if(saltando){
						saltando=false;
						gravedad=0.0;
			            felling=true;
					}
				}
				if(getLimiteAbajo().intersects(t.getLimites())){
					setVely(0);
					y=t.getY()-t.altura;
					if(felling){
						felling=false;
					}
				}else{
					if(!felling && !saltando){
						gravedad=0.0;
						felling=true;
					}
				}
				if(getLimiteIzquierda().intersects(t.getLimites())){
					setVelx(0);
					x=t.getX()+t.ancho;
				}
				if(getLimiteDerecha().intersects(t.getLimites())){
					setVelx(0);
					x=t.getX()-t.ancho;
				}
				
				
			}
			
		}
		
		for(int i =0;i<control.entity.size();i++){
			Entity e = control.entity.get(i);
			if(e.getId()==Id.goomba){
				if(getLimiteAbajo().intersects(e.getLimiteArriba())){
					e.die();
					System.out.println("hahah");
				}
				else if (getLimites().intersects(e.getLimites())){
					die();
					System.out.println("hahahx");
				}
				
			}
			else if(e.getId()==Id.Moneda){
				if(getLimites().intersects(e.getLimites())){
					MarioBros.monedas++;
					e.die();
				}
				
			}
			else if(e.getId()==Id.Hongo){
				if(getLimites().intersects(e.getLimites())){
					e.die();
				}
		     }
		    else if(e.getId()==Id.Koopa){
				if(getLimites().intersects(e.getLimites())){
					MarioBros.monedas++;
					e.die();
				}
					
				}		
		}
		
		if(saltando){
			gravedad-=0.1;
			setVely((int)-gravedad);
			if(gravedad<=0.0){
				saltando=false;
				felling=true;
			}
		}
		if(felling){
			gravedad+=0.1;
			setVely((int)gravedad);
		}
		if(animacion){
			framedelay++;
			if(framedelay>=3){
				frame++;
				if(frame>=5){
					frame=0;
				}
				framedelay=0;
			}
		}
		
	}

}
