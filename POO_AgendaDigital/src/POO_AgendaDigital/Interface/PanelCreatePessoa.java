package POO_AgendaDigital.Interface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import POO_AgendaDigital.Core.Negocio;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelCreatePessoa extends JPanel {

	private JLabel lblCadastrar;
	private JLabel lblNome;
	private JLabel lblIdade;
	private JLabel lblDataDeNascimento;

	private JTextField inputNome;
	private JTextField inputIdade;
	private JTextField inputDataNascimento;
	
	private JButton btnNovo;
	
	public DefaultListModel<Pessoa> model;

	/**
	 * Create the panel.
	 */
	public PanelCreatePessoa() {
		setLayout(null);

		lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setFont(new Font("Cambria", Font.BOLD, 26));
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setBounds(0, 11, 802, 43);

		lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(291, 117, 223, 26);

		inputNome = new JTextField();
		inputNome.setBounds(263, 154, 293, 26);
		inputNome.setColumns(10);

		inputIdade = new JTextField();
		inputIdade.setColumns(10);
		inputIdade.setBounds(263, 228, 293, 26);

		lblIdade = new JLabel("Idade: ");
		lblIdade.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdade.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblIdade.setBounds(291, 191, 223, 26);

		inputDataNascimento = new JTextField();
		inputDataNascimento.setColumns(10);
		inputDataNascimento.setBounds(263, 322, 293, 26);

		lblDataDeNascimento = new JLabel("Data de Nascimento: ");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeNascimento.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(291, 285, 223, 26);

		this.add(lblCadastrar);
		this.add(lblNome);
		this.add(lblIdade);
		this.add(lblDataDeNascimento);
		this.add(inputNome);
		this.add(inputIdade);
		this.add(inputDataNascimento);
		
		btnNovo = new JButton("Novo");
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeStr = inputNome.getText();
				
				if(nomeStr.length() > 0){
					if(Negocio.isString(nomeStr)){
						
						SQLite.insertPessoa(new Pessoa(0, inputNome.getText(), Integer.parseInt(inputIdade.getText()),
								inputDataNascimento.getText()));
						model.removeAllElements();
						for (int i = 0; i < SQLite.qtdePessoasRegistradas(); i++) {
							model.add(i, SQLite.getPessoaByIndex(i));
						}
						
					}else{
						JOptionPane.showMessageDialog(null, "Não é possível ter número no seu Nome");
					}
					
				}else{
					JOptionPane.showMessageDialog(null, "Informe o seu Nome");
				}
			}
		});

		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovo.setBounds(604, 493, 175, 44);
		this.add(btnNovo);

		this.setVisible(true);

		
	}
	
	public void setModel(DefaultListModel<Pessoa> model){
		this.model = model;
	}
}
