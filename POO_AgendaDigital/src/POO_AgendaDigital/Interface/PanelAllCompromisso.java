package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class PanelAllCompromisso extends JPanel implements ActionListener{
	
	private static JLabel lblNamePessoa;
	private static Pessoa _pessoaSelected;
	
	private ILeftToolbarListener tbLeftListener;
	
	JButton btnNovo;
	
	public PanelAllCompromisso(Pessoa pessoaSelected){
		
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);
		
		lblNamePessoa = new JLabel("");
		lblNamePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePessoa.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNamePessoa.setBounds(10, 11, 772, 62);
		
		
		this.add(lblNamePessoa);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setForeground(new Color(100, 149, 237));
		btnNovo.setBounds(703, 21, 79, 34);
		
		btnNovo.addActionListener(this);
		
		if(pessoaSelected != null){
			lblNamePessoa.setText(pessoaSelected.getNome());
		}
		
		add(btnNovo);
		
	}
	
	public static void setPessoaClickada(Pessoa _pessoaClickada) {
		lblNamePessoa.setText(_pessoaClickada.getNome());
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton buttonClicked = (JButton) e.getSource();
		
		if(buttonClicked == btnNovo){
			tbLeftListener.buttomEventCurrent("NovoCompromisso", (Pessoa) _pessoaSelected);
		}
		
	}
	
	public void setListListener(ILeftToolbarListener tbListener){
		this.tbLeftListener = tbListener;
	}
}
