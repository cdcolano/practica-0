package pr0;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;



import javax.swing.*;

public class JLabelCoche extends JLabel{ 
	private ImageIcon imagen ;
	
	
	public ImageIcon redimensionImgProd(ImageIcon imageIcon) {
		
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		return imageIcon = new ImageIcon(newimg);  // transform it back
	}
	
	
	
	public ImageIcon getImagen() {
		return imagen;
	}



	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	

	public JLabelCoche() {
		imagen= new ImageIcon( JLabelCoche.class.getResource("/coche.png"));
		imagen=redimensionImgProd(imagen);
		
		//setIcon(imagen);
		
	}
		
	public static void main (String[]args) {
		JLabelCoche c= new JLabelCoche();
		c.setVisible(true);
	}
	
	
	
	
}
