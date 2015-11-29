package POO_AgendaDigital.Interface;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Services.Services;

public class PanelCreateCompromisso extends JPanel{
	
	private static JLabel lblNamePessoa;
	private JLabel lblDescricao;
	private JLabel lblSegunda;
	private JLabel lblTerca;
	private JLabel lblQuarta;
	private JLabel lblQuinta;
	private JLabel lblSexta;
	private JLabel lblSabado;
	private JLabel lblDomingo;
	
	private JTextField inputDescricao;
	private JTextField inputSegunda;
	private JTextField inputTerca;
	private JTextField inputQuarta;
	private JTextField inputQuinta;
	private JTextField inputSexta;
	private JTextField inputSabado;
	private JTextField inputDomingo;
	
	private static Pessoa _pessoaSelected;
	
	public PanelCreateCompromisso(Pessoa pessoaSelected) {
		
		this.setLayout(null);
		
		_pessoaSelected = pessoaSelected;
		
		lblNamePessoa = new JLabel("Novo Compromisso");
		lblNamePessoa.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNamePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePessoa.setBounds(10, 11, 727, 38);
		
		lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDescricao.setBounds(64, 73, 152, 38);
		
		inputDescricao = new JTextField();
		inputDescricao.setBounds(211, 82, 293, 26);
		inputDescricao.setColumns(10);
		inputDescricao.addKeyListener(Services.alphabeticOnlyAdapter());
		
		lblSegunda = new JLabel("Segunda: ");
		lblSegunda.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegunda.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSegunda.setBounds(64, 122, 142, 38);
		
		inputSegunda = new JTextField();
		inputSegunda.setBounds(211, 131, 293, 26);
		inputSegunda.setColumns(10);
		inputSegunda.addKeyListener(Services.alphabeticOnlyAdapter());
		
		this.add(lblNamePessoa);
		this.add(lblDescricao);
		this.add(inputDescricao);
		
		this.add(lblSegunda);
		this.add(inputSegunda);
		
	}

}
