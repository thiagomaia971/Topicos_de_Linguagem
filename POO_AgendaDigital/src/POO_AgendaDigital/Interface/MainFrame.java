
package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Dia;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Interface.Listeners.IListListener;
import POO_AgendaDigital.Services.Services;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private ToolbarTop tbTop;

	public static ToolbarLeft tbLeft;
	public static PanelCreatePessoa pnCreatePessoa;
	public static PanelEditPessoa pnEditPessoa;
	public static PanelHorarioEstudo pnHorarioEstudo;
	public static PanelAllCompromisso pnAllCompromisso;
	public static PanelCreateCompromisso pnCreateCompromisso;

	private static String pathDb;

	public static boolean isCreatePanelActive;
	public static boolean isEditPanelActive;
	public static boolean isHorarioEstudoPanelActive;
	public static boolean isAllCompromissoPanelActive;
	public static boolean isCreateCompromissoPanelActive;

	public static Pessoa pessoaClicked;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("static-access")
	public MainFrame() {

		// Region - MainFrame Config

		super("Agenda Digital");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 100, (int) (scrnsize.width / 1.30), (int) (scrnsize.height / 1.15));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().setLayout(null);
		this.setResizable(false);

		// EndRegion

		try {
			pathDb = new File("").getCanonicalPath();
			new SQLite(pathDb + "\\AgendaDigitalDb.sqlite");

		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * SQLite.insertPessoa(new Pessoa("Thiago", "26/04/1997"));
		 * ArrayList<Dia> a = new ArrayList<Dia>(); a.add(new Dia(1, 1,
		 * "Segunda", "7", "10")); a.add(new Dia(1, 1, "Terca", "7", "10"));
		 * 
		 * SQLite.insertCompromisso(new Compromisso(1, 1, "Faculdade", a));
		 * SQLite.insertDia(a.get(0)); SQLite.insertDia(a.get(1));
		 */

		isCreatePanelActive = false;
		isEditPanelActive = false;
		isHorarioEstudoPanelActive = false;
		isAllCompromissoPanelActive = false;
		isCreateCompromissoPanelActive = false;

		tbLeft = new ToolbarLeft();
		// pessoaClicked = null;

		pnEditPessoa = new PanelEditPessoa();
		pnCreatePessoa = new PanelCreatePessoa();
		pnAllCompromisso = new PanelAllCompromisso();
		pnCreateCompromisso = new PanelCreateCompromisso();
		pnHorarioEstudo = new PanelHorarioEstudo();

		Services.setJFrame(this);

		tbLeft.setLeftToolbarListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {

				// pnCreatePessoa = new PanelCreatePessoa();
				Services.SwitchPanelService(e, Pessoa);

				revalidate();
				repaint();

			}

		});

		tbLeft.setListListener(new IListListener() {

			@Override
			public void valueChange(Pessoa PessoaClickada) {

				PessoaClickada = ToolbarLeft.jListPessoas.getSelectedValue();

				pnCreatePessoa.setVisible(false);
				pnEditPessoa.setVisible(false);
				pnAllCompromisso.setVisible(false);
				pnCreateCompromisso.setVisible(false);

				isHorarioEstudoPanelActive = true;
				pnHorarioEstudo.setVisible(isHorarioEstudoPanelActive);
				pnHorarioEstudo.setBounds(250, 70, 792, 558);

				if(PessoaClickada != null){
					pnHorarioEstudo.setPessoaClickada(PessoaClickada);
					pnCreateCompromisso.setPessoaClickada(PessoaClickada);
				}


				getContentPane().add(pnHorarioEstudo);
				revalidate();
				repaint();

			}
		});

		tbTop = new ToolbarTop();

		tbTop.setListListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {

				/*
				 * if (pessoaClicked != null) { pessoaClicked =
				 * SQLite.getPessoa(Pessoa[0]); }
				 */

				Services.SwitchPanelService(e, Pessoa);

				repaint();
				revalidate();

			}
		});

		tbLeft.setBounds(0, 0, 250, 595);
		tbTop.setBounds(250, 0, 802, 80);

		if (ToolbarLeft.jListPessoas.isSelectionEmpty()) {

			isCreatePanelActive = true;

			pnCreatePessoa.setBounds(250, 80, 802, 595);
			this.getContentPane().add(pnCreatePessoa);

			Services.buttonSelected(tbLeft.btnNovo);
			Services.buttonDiselected(tbLeft.btnEditar);
			Services.buttonDiselected(tbTop.btnCompromisso);
			Services.buttonDiselected(tbTop.btnHorarioEstudo);

		} else {
			isHorarioEstudoPanelActive = true;
			pnHorarioEstudo.setBounds(250, 80, 802, 595);
			pnHorarioEstudo.setPessoaClickada(ToolbarLeft.jListPessoas.getSelectedValue());

			ToolbarTop.btnHorarioEstudo.setVisible(true);
			ToolbarTop.btnCompromisso.setVisible(true);
			
			Services.buttonSelected(ToolbarTop.btnHorarioEstudo);
			Services.buttonDiselected(ToolbarTop.btnCompromisso);

			this.getContentPane().add(pnHorarioEstudo);

		}

		pnAllCompromisso.setListListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {

				Services.SwitchPanelService(e, Pessoa);

				revalidate();
				repaint();

			}
		});

		revalidate();
		repaint();

		this.getContentPane().add(tbLeft);
		this.getContentPane().add(tbTop);

		this.revalidate();
		this.repaint();

		tbLeft.setLayout(null);
	}
}
