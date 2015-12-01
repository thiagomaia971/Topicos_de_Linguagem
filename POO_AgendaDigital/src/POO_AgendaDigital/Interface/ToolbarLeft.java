package POO_AgendaDigital.Interface;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Interface.Listeners.IListListener;
import POO_AgendaDigital.Services.Services;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ToolbarLeft extends JPanel implements ActionListener{

	public static JButton btnNovo;
	public static JButton btnEditar;
	
	public static JList<Pessoa> jListPessoas;
	private JTextField txtTes;
	public static DefaultListModel<Pessoa> model;
	private ILeftToolbarListener tbListener;
	private IListListener listListener;
	public boolean getVisiblePanel;

	/**
	 * Create the panel.
	 */
	public ToolbarLeft() {

		// Region ToolbarLeft Config

		this.setBackground(new Color(240, 240, 240));
		this.setLayout(null);
		this.setBorder(new MatteBorder(0, 0, 0, 1, SystemColor.activeCaption));

		// EndRegion

		// Region Buttons

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 11, 83, 32);
		btnNovo.setBackground(Color.WHITE);
		btnNovo.setForeground(new Color(100, 149, 237));

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(144, 11, 89, 32);
		btnEditar.setBackground(Color.WHITE);
		btnEditar.setForeground(new Color(100, 149, 237));
		
		// EndRegion

		// Region JList

		model = new DefaultListModel<Pessoa>(); // Aqui vai receber a list pelo
												// SQL
		for (int i = 0; i < SQLite.qtdePessoasRegistradas(); i++) {
			model.add(i, SQLite.getPessoaByIndex(i));
		}
		
		PanelCreatePessoa.setModel(model);
		PanelEditPessoa.setModel(model);
		
		
		jListPessoas = new JList<Pessoa>(model);
		jListPessoas.setForeground(Color.BLACK);
		jListPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListPessoas.setSelectedIndex(0);
		jListPessoas.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 17));
		jListPessoas.setBackground(new Color(240, 240, 240));
		jListPessoas.setBounds(0, 144, 245, 545);
		btnEditar.setVisible(!jListPessoas.isSelectionEmpty());
		
		jListPessoas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				listListener.valueChange(jListPessoas.getSelectedValue());
				
				ToolbarTop.btnHorarioEstudo.setBackground(new Color(100, 149, 237));
				ToolbarTop.btnHorarioEstudo.setForeground(Color.WHITE);
				
				ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
				ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));
				
				btnNovo.setBackground(Color.WHITE);
				btnNovo.setForeground(new Color(100, 149, 237));
			}
		});
		
		// EndRegion

		// Region Label e Input

		JLabel lblPessoas = new JLabel(" Pessoas");
		lblPessoas.setForeground(Color.GRAY);
		lblPessoas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPessoas.setHorizontalAlignment(SwingConstants.LEFT);
		lblPessoas.setBounds(0, 101, 201, 32);

		txtTes = new JTextFieldPlaceholder();
		txtTes.setBounds(20, 54, 194, 25);
		txtTes.setColumns(10);
		// EndRegion

		btnNovo.addActionListener(this);
		btnEditar.addActionListener(this);

		this.add(btnNovo);
		this.add(btnEditar);
		this.add(jListPessoas);
		this.add(lblPessoas);
		this.add(txtTes);
		

		this.setVisible(true);

	}
	
	public void setListListener(IListListener listListener){
		this.listListener = listListener;
	}
	
	public void setLeftToolbarListener(ILeftToolbarListener tbListener){
		this.tbListener = tbListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == btnNovo) {
			tbListener.buttomEventCurrent("NovaPessoa");
			
			//PanelHorarioEstudo.
			
			jListPessoas.clearSelection();
			
			btnNovo.setBackground(new Color(100, 149, 237));
			btnNovo.setForeground(Color.WHITE);
			
			btnEditar.setBackground(Color.WHITE);
			btnEditar.setForeground(new Color(100, 149, 237));
			
			Services.buttonDiselected(ToolbarTop.btnHorarioEstudo);
			Services.buttonDiselected(ToolbarTop.btnCompromisso);
			
			
		} else if (clicked == btnEditar) {
			tbListener.buttomEventCurrent("EditarPessoa", jListPessoas.getSelectedValue());
			
			btnNovo.setBackground(Color.WHITE);
			btnNovo.setForeground(new Color(100, 149, 237));
			
			btnEditar.setBackground(new Color(100, 149, 237));
			btnEditar.setForeground(Color.WHITE);
			
			ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
			ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));
			
			ToolbarTop.btnHorarioEstudo.setBackground(Color.WHITE);
			ToolbarTop.btnHorarioEstudo.setForeground(new Color(100, 149, 237));
		}
	}

}
