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
public class PanelAllCompromisso extends JPanel implements ActionListener{
	
	private static JLabel lblNamePessoa;
	private static Pessoa _pessoaSelected;
	private JButton btnNovo;
	
	private JTable table;
	public static Compromisso rowData[][];
	private Object columnNames[];
	
	private ILeftToolbarListener tbLeftListener;
	
	
	public PanelAllCompromisso(){
		
		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(250, 70, 792, 558);
		
		if(!ToolbarLeft.jListPessoas.isSelectionEmpty()){
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
		
		columnNames = new Object [] {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo"};
		rowData = new Compromisso [5][7];
		
		Services.populandoCompromisso();
		
		
		table = new JTable(rowData, columnNames);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new CompoundBorder());
		table.setBounds(105, 100, 628, 300);
		table.setVisible(true);
		
		this.add(lblNamePessoa);
		this.add(btnNovo);
		this.add(table);
		
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
