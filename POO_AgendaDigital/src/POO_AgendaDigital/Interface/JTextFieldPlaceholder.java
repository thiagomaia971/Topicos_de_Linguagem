package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.FocusManager;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextFieldPlaceholder extends JTextField{

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(this.getText().isEmpty() && !((FocusManager.getCurrentKeyboardFocusManager().getFocusOwner()) == this)){
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setBackground(Color.GRAY);
			g2.setFont(getFont().deriveFont(Font.ITALIC));
			g2.drawString("Buscar...", 5, 16);
			g2.dispose();
		}
	}
	
}
