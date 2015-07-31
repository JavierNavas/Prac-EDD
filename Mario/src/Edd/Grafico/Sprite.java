package Edd.Grafico;

import java.awt.image.BufferedImage;

public class Sprite {
	public SpriteHoja hoja;
	int x,y;
	public BufferedImage imagen;
	

	public Sprite(SpriteHoja hoja,int x, int y){
		imagen= hoja.getSprite(x, y);
	}
	
	public Sprite(SpriteHoja hoja,int x, int y,String tortuga){
		imagen= hoja.getSprite2(x, y);
	}
	public BufferedImage getBufferedImage(){
		return imagen;
	}
}
