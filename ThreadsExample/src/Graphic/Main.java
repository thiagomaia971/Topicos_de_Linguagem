package Graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Interfaces.ICarThread;

@SuppressWarnings("serial")
public class Main extends JFrame{
	Car Red;
	Car Green;
	Car Yellow;
	Car Black;
	
	ICarThread RedThread;
	ICarThread GreenThread;
	ICarThread YellowThread;
	ICarThread BlackThread;
	
	public Main(){
		super("Car Threads");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 1, (int) ((scrnsize.width / 1.30) * 1.1), (int) (scrnsize.height / 1.15));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		
		
		Red = new Car("Red");
		Green = new Car("Green");
		Yellow = new Car("Yellow");
		Black = new Car("Black");
		
		Red.setBounds(100, 100, 100, 100);
		Green.setBounds(100, 100, 100, 100);
		Yellow.setBounds(100, 100, 100, 100);
		Black.setBounds(100, 100, 100, 100);
		
		Red.setVisible(true);
		Green.setVisible(true);
		Yellow.setVisible(true);
		Black.setVisible(true);
		
		this.add(Red);
		this.add(Green);
		this.add(Yellow);
		this.add(Black);
		
		this.repaint();
		
		RedThread = new ICarThread(this, Red);
		GreenThread = new ICarThread(this, Green);
		YellowThread = new ICarThread(this, Yellow);
		BlackThread = new ICarThread(this, Black);

		GreenThread.start();
		RedThread.start();
		YellowThread.start();
		BlackThread.start();
		
		
		
		
		
		
	}
}
