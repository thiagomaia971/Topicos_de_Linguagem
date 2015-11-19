package POO_AgendaDigital.Interface;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.event.MouseInputListener;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Interface.Listeners.IMouseInputListener;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class ToolbarLeft extends JPanel implements ActionListener{

	private JButton btnNovo;
	private JButton btnEditar;
	private JList<Pessoa> jListPessoas;
	private JTextField txtTes;
	public DefaultListModel<Pessoa> model;
	private ILeftToolbarListener tbListener;
	
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

		jListPessoas = new JList(model);
		jListPessoas.setForeground(Color.BLACK);
		jListPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListPessoas.setSelectedIndex(0);
		jListPessoas.setFont(new Font("Simplified Arabic Fixed", Font.BOLD, 17));
		jListPessoas.setBackground(new Color(240, 240, 240));
		jListPessoas.setBounds(0, 144, 245, 545);

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
		jListPessoas.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					getVisiblePanel = true;
					Pessoa pessoaClicked = (Pessoa) jListPessoas.getSelectedValue();
					
					System.out.println(pessoaClicked);
				}
				
			}
		});

		add(btnNovo);
		add(btnEditar);
		add(jListPessoas);
		add(lblPessoas);
		add(txtTes);

		setVisible(true);

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
