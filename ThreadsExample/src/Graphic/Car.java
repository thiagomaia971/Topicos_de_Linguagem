package Graphic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Car extends JPanel{
	private BufferedImage image;
	
	public Car(String Color){
		try {
			image = ImageIO.read(new File(Color+".png"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
}
