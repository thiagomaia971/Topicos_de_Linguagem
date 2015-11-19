package POO_AgendaDigital.Interface;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class ToolbarTop extends JPanel {

	/**
	 * Create the panel.
	 */
	public ToolbarTop() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Calendario");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(251, 19, 143, 35);
		add(btnNewButton);
		
		JButton btnCompromisso = new JButton("Compromisso");
		btnCompromisso.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCompromisso.setBounds(391, 19, 143, 35);
		add(btnCompromisso);

	}

}
