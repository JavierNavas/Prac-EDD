package Edd;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;



import Edd.Grafico.Sprite;
import Edd.Grafico.SpriteHoja;

import Edd.input.KeyInput;

public class MarioBros extends Canvas implements Runnable{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ANCHO=270;
     public static final int ALTURA= ANCHO/14*9;
     public static final int ESCALA=4;
     public static final String TITULO="Mario Maker EDD";

     private Thread hilo;
     private boolean running = false;
     public static Control control;
     public static Camara camara;
     public static SpriteHoja sheet;
     public static SpriteHoja sheet2;
     public static SpriteHoja sheet3;
     public static SpriteHoja sheet4;
     public static SpriteHoja sheet5;
     public static SpriteHoja sheet6;
     public static SpriteHoja sheet7;
     public static Sprite sprite;
     public static Sprite pared;
     public static Sprite suelo;
     public static Sprite mario[] =new Sprite[10];
     public static Sprite hongo;
     public static Sprite goomba;
     public static Sprite coopa;
     public static Sprite moneda;
     private BufferedImage image;
     public static int monedas=0;
     
     public synchronized void start(){
    	if(running) return;
    	running =true;
    	hilo = new Thread(this,"Thread");
    	hilo.start();
     }
     
    public synchronized void stop(){
    	 if(!running)return;
    	 running=false;
    	 try {
			hilo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		 
     }

     public MarioBros(){
    	 Dimension tamano= new Dimension(ANCHO*ESCALA,ALTURA*ESCALA);
    	 setPreferredSize(tamano);
    	 setMaximumSize(tamano);
    	 setMinimumSize(tamano);
     }
     
     public void init(){
    	 control= new Control();
    	 //camara = new Camara();
    	 sheet = new SpriteHoja("/mario1.gif");
    	 sheet2 = new SpriteHoja("/brick.gif");
    	 sheet3 = new SpriteHoja("/Goomba.gif");
    	 sheet4 = new SpriteHoja("/1up.gif");
    	 sheet5 = new SpriteHoja("/ground.gif");
    	 sheet6 = new SpriteHoja("/coopa3.png");
    	 sheet7 = new SpriteHoja("/coin3.gif");
    	 
    	 addKeyListener(new KeyInput());
    	 
    	 pared = new Sprite(sheet2,1,1);
    	 goomba = new Sprite(sheet3,1,1);
    	 hongo = new Sprite(sheet4,1,1);
    	 suelo = new Sprite(sheet5,1,1);
    	 coopa = new Sprite(sheet6,1,1,"totuga");
    	 moneda = new Sprite(sheet7,1,1);
    	 for(int i=0;i<mario.length;i++){
    		 mario[i] = new Sprite(sheet,1+i,1);
    	 }
    	
    	 control.crearnivel();
    	 
    	 
    	 
     }
     
     @Override
 	 public void run() {
    	 init();
    	 requestFocus();
    	 long lastTime = System.nanoTime();
    	 long tiempo = System.currentTimeMillis();
    	 double delta=0.0;
    	 double ns = 1000000000.0/60.0;
    	 int frames=0;
    	 int ticks=0;
 		while(running){
 			 long ahora= System.nanoTime();
 			 delta+=(ahora-lastTime)/ns;
 			 lastTime= ahora;
 			 while(delta>=1){
 				 tick();
 				 ticks++;
 				 delta--;
 			 }
 			render();
 			frames++;
 			if(System.currentTimeMillis()-tiempo>1000){
 				tiempo+=1000;
 				System.out.println(frames+" imagenes por segundo "+ticks+" Updates por segundo");
 				frames=0;
 				ticks=0;
 			}
 			
 		}
 		stop();
 	 }
     public void render(){
    	 BufferStrategy bs = getBufferStrategy();
    	 if(bs==null){
    		 createBufferStrategy(3);
    		 return;
    	 }
    	 Graphics g = bs.getDrawGraphics();
    	 g.setColor(Color.decode("#ADD8E6"));
    	 g.fillRect(0, 0, getWidth(), getHeight());
    	 
    	g.drawImage(MarioBros.moneda.getBufferedImage(),20, 50, 50, 50,null);
    	g.setColor(Color.white);
    	g.setFont(new Font("Courier",Font.BOLD,50));
    	g.drawString("x"+monedas, 60, 100);
    	 //g.translate(camara.getX(), camara.getY());
    	 control.render(g);
    	 g.dispose();
    	 bs.show();
    	 
     }
     public void tick(){
    	 control.tick();
    	 /*for(Edd.entity.Entity e:control.entity){
    		 if(e.getId()==Id.Jugador){
    			 camara.tick(e);
    		 }
    	 }*/
     }
     
    public int getframeAncho(){
    	return ANCHO*ESCALA;
    }
    public int getframeAltura(){
    	return ALTURA*ESCALA;
    }
    
    
     /*public static void main(String[] args){
    	 MarioBros juego = new MarioBros();
    	 JFrame pantalla = new JFrame(TITULO);
    	 pantalla.add(juego);
    	 pantalla.pack();
    	 pantalla.setResizable(false);
    	 pantalla.setLocationRelativeTo(null);
    	 pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 pantalla.setVisible(true);
    	  pantalla.setFocusable(true);
         juego.start();
     }*/

	
    
}
