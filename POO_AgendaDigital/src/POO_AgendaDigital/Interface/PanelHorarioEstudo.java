package POO_AgendaDigital.Interface;

import java.awt.Color;
import javax.swing.JPanel;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Services.Services;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelHorarioEstudo extends JPanel {

	private static JLabel lblNamePessoa;
	private JTable table;
	public static String rowData[][];
	private Object columnNames[];

	public PanelHorarioEstudo() {

		//_pessoaSelected = pessoaSelected;

		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);

		lblNamePessoa = new JLabel("estudo");
		lblNamePessoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNamePessoa.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblNamePessoa.setBounds(10, 11, 772, 62);

		columnNames = new Object[] { "SEGUNDA", "TERÇA", "QUARTA", "QUINTA", "SEXTA", "SÁBADO", "DOMINGO" };
		//populandoTabela();
		rowData = new String[20][8];
		
		table = new JTable(rowData, columnNames);

		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(59, 66, 705, 400);


		this.add(lblNamePessoa);
		this.add(table);
	}

	public static void setPessoaClickada(Pessoa _pessoaClickada) {
		lblNamePessoa.setText(_pessoaClickada.getNome());
		Services.gerarTabelaHorario();
	}

	/*private void populandoTabela() {
		rowData = new String[20][7];
		table = new JTable(rowData, columnNames);
		
	}*/

	public void setMatriz(String[][] gerarTabelaHorario) {
		this.rowData = gerarTabelaHorario;
		DefaultTableModel model = new DefaultTableModel(Services.populandoCompromisso(ToolbarLeft.jListPessoas.getSelectedValue()), columnNames );
		table.setModel(model);
		//Services.gerarTabelaHorario();
	}

}
