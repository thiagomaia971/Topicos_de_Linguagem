package POO_AgendaDigital.Interface;

import java.awt.Color;
import javax.swing.JPanel;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Pessoa;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PanelHorarioEstudo extends JPanel {

	private static JLabel lblNamePessoa;
	private JTable table;
	private Compromisso rowData[][];
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
		populandoTabela();

		table = new JTable(rowData, columnNames);

		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(20, 84, 750, 463);

		/*if (pessoaSelected != null) {
			lblNamePessoa.setText(_pessoaSelected.getNome());
			populandoTabela();
		}*/

		this.add(lblNamePessoa);
		this.add(table);
	}

	public static void setPessoaClickada(Pessoa _pessoaClickada) {
		lblNamePessoa.setText(_pessoaClickada.getNome());
	}

	private void populandoTabela() {
		rowData = new Compromisso[7][7];

		for (int i = 0; i < rowData.length; i++) {
			for (int j = 0; j < rowData[i].length; j++) {

				rowData[i][j] = new Compromisso();

			}
		}

		/*
		 * ArrayList<Compromisso> seg = Semana.getDiaDaSemana(2);
		 * ArrayList<Compromisso> ter = Semana.getDiaDaSemana(3);
		 * ArrayList<Compromisso> qua = Semana.getDiaDaSemana(4);
		 * ArrayList<Compromisso> qui = Semana.getDiaDaSemana(5);
		 * ArrayList<Compromisso> sex = Semana.getDiaDaSemana(6);
		 * ArrayList<Compromisso> sab = Semana.getDiaDaSemana(7);
		 * ArrayList<Compromisso> dom = Semana.getDiaDaSemana(1);
		 * 
		 * 
		 * for (int i = 0; i < rowData.length; i++) { for (int j = 0; j <
		 * rowData[i].length; j++) { switch (j) { case 0: case 7: case 14: case
		 * 21: case 28: if (seg.get(i) != null) { rowData[i][j] = seg.get(i); }
		 * break;
		 * 
		 * case 1: case 8: case 15: case 22: case 29: if (ter.get(i) != null) {
		 * rowData[i][j] = ter.get(i); } break;
		 * 
		 * case 2: case 9: case 16: case 23: case 30: if (qua.get(i) != null) {
		 * rowData[i][j] = qua.get(i); } break;
		 * 
		 * case 3: case 10: case 17: case 24: case 31: if (qui.get(i) != null)
		 * rowData[i][j] = qui.get(i); break;
		 * 
		 * case 4: case 11: case 18: case 25: case 32: if (sex.get(i) != null)
		 * rowData[i][j] = sex.get(i); break;
		 * 
		 * case 5: case 12: case 19: case 26: case 33: if (sab.get(i) != null)
		 * rowData[i][j] = sab.get(i); break;
		 * 
		 * case 6: case 13: case 20: case 27: case 34: if (dom.get(i) != null)
		 * rowData[i][j] = dom.get(i); break;
		 * 
		 * default: break; } } }
		 */

	}

}
