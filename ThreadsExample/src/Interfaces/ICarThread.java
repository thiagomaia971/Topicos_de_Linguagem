package Interfaces;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

import Graphic.MainFrame;
import Graphic.Car;

public class ICarThread extends Thread {

	private Toolkit toolkit = Toolkit.getDefaultToolkit();
	private Dimension scrnsize = toolkit.getScreenSize();
	
	private Car Car;
	private JFrame Main;
	
	private boolean chegou = false;

	private final int width = (int) ((scrnsize.width / 1.30) * 1.1);
	private final int height = (int) (scrnsize.height / 1.15);
	
	private final int _finalWidth = width - 100;
	private final int _finalHeight = height - 100;
	
	private final int _startWidth = width - (_finalWidth);
	private final int _startHeight = height - (_finalHeight);
	
	private final int rangeWidth = (_finalWidth) - (_startWidth * 2);
	private final int rangeHeight = (_finalHeight) - (_startHeight * 2);
	
	private final int _allCircuite = ((rangeWidth * 2) + (rangeHeight * 2));
	//private final int _allCircuite = (_final - _start) * 4;
	
	public ICarThread(JFrame Main, Car Car) {
		this.Car = Car;
		this.Main = Main;
	}

	public void run() {
		int cont = 0;
		Random rand = new Random();
		try {
			long randomNumber = rand.nextInt((rangeWidth * 2) + 1);
			sleep(randomNumber);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < (_allCircuite); i+=1) {
			
			if(i < rangeWidth){
				Car.setBounds(_startWidth + i, 100, 35, 35);
				
			}else if(i > rangeWidth && i < ((rangeHeight + rangeWidth))){
				if(i == (rangeWidth + 1)){
					cont = 1;
					try {
						sleep((long)rand.nextInt(500) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds(rangeWidth + _startWidth, _startHeight + cont, 35, 35);
				
			}else if(i > (rangeHeight + rangeWidth) && i < ((rangeHeight + rangeWidth) + rangeWidth )){
				if(i == (rangeHeight + rangeWidth) + 1){
					cont = 1;
					
					try {
						sleep((long)rand.nextInt(700) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds((rangeWidth + _startWidth) - cont, rangeHeight + _startHeight, 35, 35);
				
			}else if(i > ((rangeHeight + rangeWidth) + rangeWidth )){
				if(i == ((rangeHeight + rangeWidth) + rangeWidth ) + 1){
					cont = 1;
					try {
						sleep((long)rand.nextInt(600) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds(_startWidth, (rangeHeight + _startHeight) - cont, 35, 35);
			}
			
			cont++;
			
			Main.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Car.toString());
		
	}
}
