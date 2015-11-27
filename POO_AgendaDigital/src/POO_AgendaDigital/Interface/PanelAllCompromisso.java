package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelAllCompromisso extends JPanel{
	private JLabel lblTest;
	
	public PanelAllCompromisso(){
		
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);
		
		lblTest = new JLabel("Name's Here!");
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTest.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblTest.setBounds(10, 11, 772, 62);
		
		this.add(lblTest);
		
	}
	
}
