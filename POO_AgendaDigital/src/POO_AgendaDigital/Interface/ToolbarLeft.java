package POO_AgendaDigital.Interface;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Interface.Listeners.IListListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.HierarchyListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public class ToolbarLeft extends JPanel implements ActionListener{

	private JButton btnNovo;
	private JButton btnEditar;
	private JList<Pessoa> jListPessoas;
	private JTextField txtTes;
	public DefaultListModel<Pessoa> model;
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
		this.setBorder(new MatteBorder(0, 0, 0, 1, (Color) SystemColor.activeCaption));

		// EndRegion

		// Region Buttons

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(10, 11, 83, 32);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(144, 11, 89, 32);

		// EndRegion

		// Region JList

		model = new DefaultListModel<Pessoa>(); // Aqui vai receber a list pelo
												// SQL
		for (int i = 0; i < SQLite.qtdePessoasRegistradas(); i++) {
			model.add(i, SQLite.getPessoaByIndex(i));
		}
		PanelCreatePessoa.setModel(model);
		
		
		jListPessoas = new JList<Pessoa>(model);
		jListPessoas.setForeground(Color.BLACK);
		jListPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListPessoas.setSelectedIndex(0);
		jListPessoas.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 17));
		jListPessoas.setBackground(new Color(240, 240, 240));
		jListPessoas.setBounds(0, 144, 245, 545);
		
		jListPessoas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				listListener.valueChange(jListPessoas.getSelectedValue());
				
			}
		});
		jListPessoas.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				Container a = arg0.getComponent().getParent();
				//a.
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
//				Point s  = arg0.getComponent().getLocationOnScreen();
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
		

		setVisible(true);

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
			tbListener.buttomEventCurrent("Novo");
			jListPessoas.setSelectedIndex(-1);
			
		} else if (e.getSource() == btnEditar) {
			tbListener.buttomEventCurrent("Editar", (Pessoa) jListPessoas.getSelectedValue());
			//System.out.println("editar " + jListPessoas.getSelectedValue());
		}
	}

}
