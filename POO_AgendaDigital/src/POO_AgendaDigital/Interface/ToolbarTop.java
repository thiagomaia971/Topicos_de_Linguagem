package POO_AgendaDigital.Interface;

import javax.swing.JPanel;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Services.Services;

import java.awt.Color;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ToolbarTop extends JPanel implements ActionListener{

	public static JButton btnHorarioEstudo;
	public static JButton btnCompromisso;
	
	private ILeftToolbarListener tbLeftListener;
	
	/**
	 * Create the panel.
	 */
	public ToolbarTop() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		btnHorarioEstudo = new JButton("Estudo");
		btnHorarioEstudo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHorarioEstudo.setBackground(new Color(100, 149, 237));
		btnHorarioEstudo.setForeground(Color.WHITE);
		btnHorarioEstudo.setBounds(251, 19, 143, 35);
		btnHorarioEstudo.setVisible(false);
		
		btnCompromisso = new JButton("Compromisso");
		btnCompromisso.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCompromisso.setBackground(Color.WHITE);
		btnCompromisso.setForeground(new Color(100, 149, 237));
		btnCompromisso.setBounds(391, 19, 143, 35);
		btnCompromisso.setVisible(false);
		
		btnHorarioEstudo.addActionListener(this);
		btnCompromisso.addActionListener(this);
		
		add(btnHorarioEstudo);
		add(btnCompromisso);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonClicked = (JButton) arg0.getSource();
		
		if(buttonClicked == btnHorarioEstudo){
			Pessoa pessoaSelected = (Pessoa) ToolbarLeft.jListPessoas.getSelectedValue();
			tbLeftListener.buttomEventCurrent("HorarioEstudo", pessoaSelected);
			
			Services.btnHorarioEstudoSelected();
			
		}else if(buttonClicked == btnCompromisso){
				
			tbLeftListener.buttomEventCurrent("TodosCompromissos");
			
			Services.btnCompromissoSelected();
		}	
		
		
	}
	
	public void setListListener(ILeftToolbarListener tbListener){
		this.tbLeftListener = tbListener;
	}

}
