package Interfaces;

import java.util.Random;

import javax.swing.JFrame;

import Graphic.Car;

public class ICarThread extends Thread {

	private Car Car;
	private JFrame Main;

	public ICarThread(JFrame Main, Car Car) {
		this.Car = Car;
		this.Main = Main;
	}

	public void run() {
		int cont = 0;
		Random rand = new Random();
		try {
			sleep((long)rand.nextInt(1000) + 1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 1; i < 4880; i+=1) {
			
			if(i < 500){
				Car.setBounds(100 + i, 100, 100, 100);
				
			}else if(i > 501 && i < 1000){
				if(i == 502){
					cont = 0;
					try {
						sleep((long)rand.nextInt(500) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds(600, 100 + cont, 100, 100);
				
			}else if(i > 1001 && i < 1500){
				if(i - 1 == 1001){
					cont = 0;
					try {
						sleep((long)rand.nextInt(700) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds(600 - cont, 600, 100, 100);
				
			}else if(i > 1501 && i < 2000){
				if(i == 1502){
					cont = 0;
					try {
						sleep((long)rand.nextInt(600) + 1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Car.setBounds(100, 600 - cont, 100, 100);
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
	}

}
