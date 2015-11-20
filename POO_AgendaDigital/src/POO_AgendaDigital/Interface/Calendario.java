package POO_AgendaDigital.Interface;

import java.awt.Color;
import javax.swing.JPanel;
import POO_AgendaDigital.Core.Pessoa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class Calendario extends JPanel {

	private JLabel lblTest;
	private Pessoa pessoaClickada;
	private JTable table;
	Object rowData[][];
	Object columnNames[];
			

	public Calendario() {
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);

		lblTest = new JLabel("Name's Here!");
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		lblTest.setFont(new Font("Sitka Text", Font.BOLD, 30));
		lblTest.setBounds(10, 11, 772, 62);
		
		
		rowData = new Object[][]{{ "row1-column1", "row1-column2" },
					{ "row2-column1", "row2-column2"}};
		columnNames = new Object[]{ "column one", "column two" };
		
		table = new JTable(rowData, columnNames);
		table.setBounds(20, 84, 750, 463);

		this.add(lblTest);
		this.add(table);
	}

	public void setPessoaClickada(Pessoa pessoaClickada) {
		lblTest.setText(pessoaClickada.getNome());
	}
}
