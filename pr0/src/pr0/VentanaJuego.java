package pr0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

import javax.swing.*;

public class VentanaJuego extends JFrame{
	private JPanel panelPrincipal;
	private JPanel botonera;
	private CocheJuego coche;

	
	
	public VentanaJuego(CocheJuego coche) {
		this.coche=coche;
		
		panelPrincipal= new JPanel();
		//panelPrincipal.setLayout(null);
		panelPrincipal.add(coche.getImg());
		botonera= new JPanel();
		botonera.setLayout(new FlowLayout());
		getContentPane().add(panelPrincipal,BorderLayout.CENTER);
		getContentPane().add(botonera, BorderLayout.SOUTH);
		panelPrincipal.setMinimumSize(new Dimension(100, 100));
		panelPrincipal.setBackground(Color.WHITE);
		
		
		JButton acelerar= new JButton("acelerar");
		botonera.add(acelerar);
		JButton frenar= new JButton("frenar");
		botonera.add(frenar);
		JButton girarIzq= new JButton("girarIzq");
		botonera.add(girarIzq);
		JButton girarDcha = new JButton("girarDcha");
		botonera.add(girarDcha);
		
		setMinimumSize(new Dimension(500, 500));
		
		
		acelerar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelerar(5);
				
			}
		});
		
		frenar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					coche.acelerar(-5);
				
			}
		});
		
		girarDcha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.girar(10);
				VentanaJuego.this.repaint();
				
			}
		});
		
		girarIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.girar(-10);
				VentanaJuego.this.repaint();

			}
		});
		
		Thread miHilo= new Thread(new Runnable() {
			
			@Override
				public void run() {
				while (true) {
					coche.mueve(60);
					if ( coche.getPosY()<0 || coche.getPosY()+100>VentanaJuego.this.getHeight()) {
						System.out.println(coche.miDireccionActual);
							coche.setMiDireccionActual(360-coche.getMiDireccionActual());
							System.out.println(coche.miDireccionActual);
						}else if(coche.getPosX()<0 || coche.getPosX()+100>VentanaJuego.this.getWidth()){
							if (coche.getMiDireccionActual()>180) {
								System.out.println(coche.miDireccionActual);
								coche.setMiDireccionActual(360-(coche.getMiDireccionActual()+180));
							}
							else if (coche.getMiDireccionActual()<=180) {
								System.out.println(coche.miDireccionActual);
								coche.setMiDireccionActual(180-coche.getMiDireccionActual());
							}
							System.out.println(coche.miDireccionActual);
						}	
					VentanaJuego.this.repaint();
					//TODO actualizar la posicion del coche mirar ejemplo del balon
					try {
						Thread.sleep(60);
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		
		
		
		miHilo.start();
		
		addWindowListener(new WindowAdapter() {
			
			
			
			@Override
			public void windowClosed(WindowEvent e) {
				miHilo.stop();
				
			}
			
			
		});
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		pack();
	//TODO calcular rebotes
		/*
		 * si se sale de x girar la direccion x
		 * si x<0 o x<ancho de ventana
		 * 		
		 * 
		 * si se sale de y girar la direccion y
		 */
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gr2= (Graphics2D)g;
		gr2.rotate(Math.toRadians(coche.getMiDireccionActual()+90),coche.getPosX()+50,coche.getPosY()+50);
		gr2.drawImage(coche.getImg().getImagen().getImage(),(int)coche.getPosX(),(int)coche.getPosY(), 100, 100, this);
		
		
		
		
	}
	
	
	public static void main(String[]args) {
		CocheJuego c= new CocheJuego();
		VentanaJuego v= new VentanaJuego(c);
		
	}
}
	
