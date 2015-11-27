package POO_AgendaDigital.Interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;

@SuppressWarnings("serial")
public class PanelEditPessoa extends JPanel {

	private JLabel lblCadastrar;
	private JLabel lblNome;
	private JLabel lblDataDeNascimento;

	private JTextField inputNome;
	private JTextField inputDataNascimento;

	private JButton btnSalvar;

	private Pessoa pessoaClickada;

	private static DefaultListModel<Pessoa> _model;

	public PanelEditPessoa() {

		setLayout(null);

		lblCadastrar = new JLabel("Editar");
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

		inputDataNascimento = new JTextField();
		inputDataNascimento.setColumns(10);
		inputDataNascimento.setBounds(263, 322, 293, 26);

		lblDataDeNascimento = new JLabel("Data de Nascimento: ");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDeNascimento.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(291, 285, 223, 26);

		this.add(lblCadastrar);
		this.add(lblNome);
		this.add(lblDataDeNascimento);
		
		this.add(inputNome);
		this.add(inputDataNascimento);

		btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SQLite.updatePessoa(pessoaClickada.getPessoaId(), new Pessoa(pessoaClickada.getPessoaId(),
						inputNome.getText().toString(), inputDataNascimento.getText().toString()));
				_model.removeAllElements();
				for (int i = 0; i < SQLite.qtdePessoasRegistradas(); i++) {
					_model.add(i, SQLite.getPessoaByIndex(i));
				}

			}
		});

		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(604, 493, 175, 44);
		this.add(btnSalvar);

	}

	public void setPessoaClickada(Pessoa PessoaClickada) {

		this.pessoaClickada = PessoaClickada;

		inputNome.setText(this.pessoaClickada.getNome());
		inputDataNascimento.setText(this.pessoaClickada.getDataNascimento());
	}

	public static void setModel(DefaultListModel<Pessoa> model) {
		_model = model;
	}

}
