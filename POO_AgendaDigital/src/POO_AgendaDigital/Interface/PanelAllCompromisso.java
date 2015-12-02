package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Services.Services;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class PanelAllCompromisso extends JPanel implements ActionListener {

	private static JLabel lblNamePessoa;
	private static Pessoa _pessoaSelected;
	private JButton btnNovo;
	JButton btnGerarHorarios;

	public static JTable table;
	public static String rowData[][];
	private Object columnNames[];

	private ILeftToolbarListener tbLeftListener;

	public PanelAllCompromisso() {

		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);

		if (!ToolbarLeft.jListPessoas.isSelectionEmpty()) {
			lblNamePessoa = new JLabel(ToolbarLeft.jListPessoas.getSelectedValue().getNome());
		}

		lblNamePessoa = new JLabel();
		lblNamePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePessoa.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNamePessoa.setBounds(10, 11, 772, 62);

		btnNovo = new JButton("Novo");
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setForeground(new Color(100, 149, 237));
		btnNovo.setBounds(703, 21, 79, 34);

		btnNovo.addActionListener(this);

		columnNames = new Object[] { "Horários", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo" };
		rowData = Services.populandoCompromisso(ToolbarLeft.jListPessoas.getSelectedValue());

		//Services.populandoCompromisso(ToolbarLeft.jListPessoas.getSelectedValue());

		table = new JTable(rowData, columnNames);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new CompoundBorder());
		table.setBounds(-65, 66, 897, 400);
		table.setVisible(true);

		this.add(lblNamePessoa);
		this.add(btnNovo);
		this.add(table);

		btnGerarHorarios = new JButton("Gerar Horarios");
		btnGerarHorarios.setBounds(555, 487, 189, 34);

		btnGerarHorarios.addActionListener(this);
		add(btnGerarHorarios);

	}

	public static void setPessoaClickada(Pessoa _pessoaClickada) {
		lblNamePessoa.setText(_pessoaClickada.getNome());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton buttonClicked = (JButton) e.getSource();

		if (buttonClicked == btnNovo) {
			tbLeftListener.buttomEventCurrent("NovoCompromisso", (Pessoa) _pessoaSelected);
		}
		if (buttonClicked == btnGerarHorarios) {

			Services.gerarTabelaHorario();

		}

	}

	public void setListListener(ILeftToolbarListener tbListener) {
		this.tbLeftListener = tbListener;
	}

	public void setMatriz(Pessoa PessoaSelected) {
//		this.rowData = populandoCompromisso;
		this.rowData = new String[20][8];
		rowData = Services.populandoCompromisso(PessoaSelected);
		
	}
}
