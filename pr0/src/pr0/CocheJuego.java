package pr0;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class CocheJuego extends Coche{
	
	private JLabelCoche img;

	public JLabelCoche getImg() {
		return img;
	}

	public void setImg(JLabelCoche img) {
		this.img = img;
	}
	
	public CocheJuego() {
		super();
		img= new JLabelCoche();
		img.setLocation(0, 0);
	}
	
	
	public void setPosX(double posX) {
		this.posX= posX;
		Point p= new Point();
		p.setLocation(posX, posY);
		img.setLocation(p);
	}
	
	public void setPosY(double posY) {
		this.posY=posY;
		Point p= new Point();
		p.setLocation(posX, posY);
		img.setLocation(p);
	}
	
	
	public void mueve(double tiempoDeMovimiento) {
		super.mueve(tiempoDeMovimiento);
		setPosX(posX);
		setPosY(posY);
	}


	
}
