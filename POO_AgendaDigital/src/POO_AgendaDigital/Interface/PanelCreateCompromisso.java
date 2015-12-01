package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Dia;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Services.Services;

@SuppressWarnings("serial")
public class PanelCreateCompromisso extends JPanel implements ActionListener {

	private JButton btnSalvar;

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

	private JComboBox<String> comboSegundaInicial;
	private JComboBox<String> comboSegundaFinal;

	private JComboBox<String> comboTercaInicial;
	private JComboBox<String> comboTercaFinal;

	private JComboBox<String> comboQuartaInicial;
	private JComboBox<String> comboQuartaFinal;

	private JComboBox<String> comboQuintaInicial;
	private JComboBox<String> comboQuintaFinal;

	private JComboBox<String> comboSextaInicial;
	private JComboBox<String> comboSextaFinal;

	private JComboBox<String> comboSabadoInicial;
	private JComboBox<String> comboSabadoFinal;

	private JComboBox<String> comboDomingoInicial;
	private JComboBox<String> comboDomingoFinal;

	private static Pessoa _pessoaSelected;

	public PanelCreateCompromisso() {

		this.setLayout(null);

		//_pessoaSelected = pessoaSelected;

		lblNamePessoa = new JLabel("Novo Compromisso");
		lblNamePessoa.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNamePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePessoa.setBounds(10, 11, 727, 38);

		lblDescricao = new JLabel("Descrição: ");
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescricao.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDescricao.setBounds(64, 73, 152, 38);

		inputDescricao = new JTextField();
		inputDescricao.setBounds(211, 82, 305, 26);
		inputDescricao.setColumns(10);
		inputDescricao.addKeyListener(Services.alphabeticOnlyAdapter());

		// Segunda

		lblSegunda = new JLabel("Segunda: ");
		lblSegunda.setHorizontalAlignment(SwingConstants.CENTER);
		lblSegunda.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSegunda.setBounds(62, 115, 142, 38);

		comboSegundaInicial = new JComboBox<String>(Services.GerarHorarios());
		comboSegundaInicial.setBounds(211, 125, 150, 26);
		comboSegundaInicial.setEditable(false);

		comboSegundaFinal = new JComboBox<String>(Services.GerarHorarios());
		comboSegundaFinal.setBounds(365, 125, 150, 26);
		comboSegundaFinal.setEditable(false);

		// Terça

		lblTerca = new JLabel("Terça: ");
		lblTerca.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerca.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTerca.setBounds(50, 160, 142, 38);

		comboTercaInicial = new JComboBox<String>(Services.GerarHorarios());
		comboTercaInicial.setBounds(211, 167, 150, 26);
		comboTercaInicial.setEditable(false);

		comboTercaFinal = new JComboBox<String>(Services.GerarHorarios());
		comboTercaFinal.setBounds(365, 167, 150, 26);
		comboTercaFinal.setEditable(false);

		// Quarta

		lblQuarta = new JLabel("Quarta: ");
		lblQuarta.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuarta.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblQuarta.setBounds(54, 200, 142, 38);

		comboQuartaInicial = new JComboBox<String>(Services.GerarHorarios());
		comboQuartaInicial.setBounds(211, 205, 150, 26);
		comboQuartaInicial.setEditable(false);

		comboQuartaFinal = new JComboBox<String>(Services.GerarHorarios());
		comboQuartaFinal.setBounds(365, 205, 150, 26);
		comboQuartaFinal.setEditable(false);

		// Quinta

		lblQuinta = new JLabel("Quinta: ");
		lblQuinta.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuinta.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblQuinta.setBounds(54, 240, 142, 38);

		comboQuintaInicial = new JComboBox<String>(Services.GerarHorarios());
		comboQuintaInicial.setBounds(211, 245, 150, 26);
		comboQuintaInicial.setEditable(false);

		comboQuintaFinal = new JComboBox<String>(Services.GerarHorarios());
		comboQuintaFinal.setBounds(365, 245, 150, 26);
		comboQuintaFinal.setEditable(false);

		// Sexta

		lblSexta = new JLabel("Quinta: ");
		lblSexta.setHorizontalAlignment(SwingConstants.CENTER);
		lblSexta.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSexta.setBounds(54, 240, 142, 38);

		comboSextaInicial = new JComboBox<String>(Services.GerarHorarios());
		comboSextaInicial.setBounds(211, 245, 150, 26);
		comboSextaInicial.setEditable(false);

		comboSextaFinal = new JComboBox<String>(Services.GerarHorarios());
		comboSextaFinal.setBounds(365, 245, 150, 26);
		comboSextaFinal.setEditable(false);

		// Sabado

		lblSabado = new JLabel("Sábado: ");
		lblSabado.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabado.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblSabado.setBounds(58, 275, 142, 38);

		comboSabadoInicial = new JComboBox<String>(Services.GerarHorarios());
		comboSabadoInicial.setBounds(211, 280, 150, 26);
		comboSabadoInicial.setEditable(false);

		comboSabadoFinal = new JComboBox<String>(Services.GerarHorarios());
		comboSabadoFinal.setBounds(365, 280, 150, 26);
		comboSabadoFinal.setEditable(false);

		// Domingo

		lblDomingo = new JLabel("Domingo: ");
		lblDomingo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDomingo.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblDomingo.setBounds(63, 310, 142, 38);

		comboDomingoInicial = new JComboBox<String>(Services.GerarHorarios());
		comboDomingoInicial.setBounds(211, 320, 150, 26);
		comboDomingoInicial.setEditable(false);

		comboDomingoFinal = new JComboBox<String>(Services.GerarHorarios());
		comboDomingoFinal.setBounds(365, 320, 150, 26);
		comboDomingoFinal.setEditable(false);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setVisible(true);
		btnSalvar.setBounds(650, 450, 80, 35);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setForeground(new Color(100, 149, 237));
		// Services.buttonDiselected(btnSalvar);

		this.add(lblNamePessoa);
		this.add(lblDescricao);
		this.add(inputDescricao);

		this.add(lblSegunda);
		this.add(comboSegundaInicial);
		this.add(comboSegundaFinal);

		this.add(lblTerca);
		this.add(comboTercaInicial);
		this.add(comboTercaFinal);

		this.add(lblQuarta);
		this.add(comboQuartaInicial);
		this.add(comboQuartaFinal);

		this.add(lblQuinta);
		this.add(comboQuintaInicial);
		this.add(comboQuintaFinal);

		this.add(lblSexta);
		this.add(comboSextaInicial);
		this.add(comboSextaFinal);

		this.add(lblSabado);
		this.add(comboSabadoInicial);
		this.add(comboSabadoFinal);

		this.add(lblDomingo);
		this.add(comboDomingoInicial);
		this.add(comboDomingoFinal);

		this.add(btnSalvar);
		btnSalvar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputSegundaInicial = (String) comboSegundaInicial.getSelectedItem();
		String inputSegundaFinal = (String) comboSegundaFinal.getSelectedItem();

		String inputTercaInicial = (String) comboTercaInicial.getSelectedItem();
		String inputTercaFinal = (String) comboTercaFinal.getSelectedItem();

		String inputQuartaInicial = (String) comboQuartaInicial.getSelectedItem();
		String inputQuartaFinal = (String) comboQuartaFinal.getSelectedItem();

		String inputQuintaInicial = (String) comboQuintaInicial.getSelectedItem();
		String inputQuintaFinal = (String) comboQuintaFinal.getSelectedItem();

		String inputSextaInicial = (String) comboSextaInicial.getSelectedItem();
		String inputSextaFinal = (String) comboSextaFinal.getSelectedItem();

		String inputSabadoInicial = (String) comboSabadoInicial.getSelectedItem();
		String inputSabadoFinal = (String) comboSabadoFinal.getSelectedItem();

		String inputDomingoInicial = (String) comboDomingoInicial.getSelectedItem();
		String inputDomingoFinal = (String) comboDomingoFinal.getSelectedItem();

		ArrayList<Dia> dias = new ArrayList<Dia>();

		Compromisso compromissoAux = new Compromisso(ToolbarLeft.jListPessoas.getSelectedValue().getPessoaId(),
				inputDescricao.getText());

		SQLite.insertCompromisso(compromissoAux);

		ArrayList<Compromisso> compromissos = SQLite.getCompromissos();

		for (Compromisso compromisso : compromissos) {
			if (compromisso.getNomeCompromisso().equals(compromissoAux.getNomeCompromisso())) {
				compromissoAux.setCompromissoId(compromisso.getCompromissoId());
			}
		}

		if (comboSegundaInicial.getSelectedIndex() > 0 && comboSegundaFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Segunda", inputSegundaInicial, inputSegundaFinal));
		}

		if (comboTercaInicial.getSelectedIndex() > 0 && comboTercaFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Terça", inputTercaInicial, inputTercaFinal));
		}

		if (comboQuartaInicial.getSelectedIndex() > 0 && comboQuartaFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Quarta", inputQuartaInicial, inputQuartaFinal));
		}

		if (comboQuintaInicial.getSelectedIndex() > 0 && comboQuintaFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Quinta", inputQuintaInicial, inputQuintaFinal));
		}

		if (comboSextaInicial.getSelectedIndex() > 0 && comboSextaFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Sexta", inputSextaInicial, inputSextaFinal));
		}

		if (comboSabadoInicial.getSelectedIndex() > 0 && comboSabadoFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Sabado", inputSabadoInicial, inputSabadoFinal));
		}

		if (comboDomingoInicial.getSelectedIndex() > 0 && comboDomingoFinal.getSelectedIndex() > 0) {
			dias.add(new Dia(compromissoAux.getCompromissoId(), "Domingo", inputDomingoInicial, inputDomingoFinal));
		}

		for (int i = 0; i < dias.size(); i++) {
			SQLite.insertDia(dias.get(i));
		}
		
		this.setVisible(false);
		
		Services.SwitchPanelService("HorarioEstudo", ToolbarLeft.jListPessoas.getSelectedValue());
		
		Services.buttonSelected(ToolbarTop.btnHorarioEstudo);
		Services.buttonDiselected(ToolbarTop.btnCompromisso);

	}

	public static void setPessoaClickada(Pessoa pessoaClickada) {
		_pessoaSelected = pessoaClickada;

	}

}
