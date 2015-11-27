package Graphic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class Car extends JPanel{
	private BufferedImage image;
	private String color;
	
	public Car(String Color){
		color = Color;
		setLayout(null);
		
		/*BufferedImage wPic;
		try {
			wPic = ImageIO.read(this.getClass().getResource(Color + ".png"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
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
	
	public String getColor(){
		return color;
	}
	
	public String toString(){
		return color;
	}
	
}
