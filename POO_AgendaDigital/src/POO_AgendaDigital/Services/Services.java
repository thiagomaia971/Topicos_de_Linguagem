package POO_AgendaDigital.Services;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import POO_AgendaDigital.Core.Compromisso;
import POO_AgendaDigital.Core.Dia;
import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.MainFrame;
import POO_AgendaDigital.Interface.PanelAllCompromisso;
import POO_AgendaDigital.Interface.PanelCreateCompromisso;
import POO_AgendaDigital.Interface.ToolbarLeft;
import POO_AgendaDigital.Interface.ToolbarTop;

public class Services {

	private static MainFrame MainFrame;

	public Services() {
		MainFrame = new MainFrame();
	}

	public static void setJFrame(MainFrame jFrame) {
		MainFrame = jFrame;
	}

	@SuppressWarnings("static-access")
	public static void SwitchPanelService(String e, Pessoa... Pessoa) {
		switch (e) {
		case "NovaPessoa":

			selectPanelChange(true, false, false, false, false);

			POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa);

			break;

		case "EditarPessoa":

			selectPanelChange(false, true, false, false, false);

			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa
					.setModel(POO_AgendaDigital.Interface.MainFrame.tbLeft.model);
			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnEditPessoa);

			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setPessoaClickada(Pessoa[0]);

			break;

		case "HorarioEstudo":

			selectPanelChange(false, false, true, false, false);

			// PanelCreateCompromisso.setPessoaClickada(SQLite.getPessoa(ToolbarLeft.jListPessoas.getSelectedValue()));

			POO_AgendaDigital.Interface.PanelHorarioEstudo
					.setPessoaClickada((Pessoa) ToolbarLeft.jListPessoas.getSelectedValue());

			POO_AgendaDigital.Interface.MainFrame.pnHorarioEstudo.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnHorarioEstudo);

			break;

		case "NovoCompromisso":

			selectPanelChange(false, false, false, true, false);

			// PanelCreateCompromisso.setPessoaClickada(SQLite.getPessoa(ToolbarLeft.jListPessoas.getSelectedValue()));

			POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso);

			break;

		case "TodosCompromissos":

			selectPanelChange(false, false, false, false, true);
			// PanelCreateCompromisso.setPessoaClickada(SQLite.getPessoa(ToolbarLeft.jListPessoas.getSelectedValue()));

			POO_AgendaDigital.Interface.MainFrame.pnAllCompromisso.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnAllCompromisso);

			break;

		default:
			break;
		}
	}

	private static void selectPanelChange(boolean isCreatePanelActive, boolean isEditPanelActive,
			boolean isCalendarioPanelActive, boolean isCreateCompromissoPanelActive,
			boolean isAllCompromissoPanelActive) {

		POO_AgendaDigital.Interface.MainFrame.isCreatePanelActive = isCreatePanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa.setVisible(isCreatePanelActive);

		POO_AgendaDigital.Interface.MainFrame.isEditPanelActive = isEditPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setVisible(isEditPanelActive);

		POO_AgendaDigital.Interface.MainFrame.isHorarioEstudoPanelActive = isCalendarioPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnHorarioEstudo.setVisible(isCalendarioPanelActive);

		POO_AgendaDigital.Interface.MainFrame.isCreateCompromissoPanelActive = isCreateCompromissoPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso.setVisible(isCreateCompromissoPanelActive);

		POO_AgendaDigital.Interface.MainFrame.isAllCompromissoPanelActive = isAllCompromissoPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnAllCompromisso.setVisible(isAllCompromissoPanelActive);
	}

	/*
	 * public static void buttonSelected(JButton btnSelected){
	 * btnSelected.setBackground(new Color(100, 149, 237));
	 * btnSelected.setForeground(Color.WHITE); MainFrame.revalidate();
	 * MainFrame.repaint(); }
	 * 
	 * public static void buttonDiselected(JButton btnDislected){
	 * btnDislected.setBackground(Color.WHITE); btnDislected.setForeground(new
	 * Color(100, 149, 237)); MainFrame.revalidate(); MainFrame.repaint(); }
	 */

	public static void btnNovaPessoaSelected() {
		ToolbarLeft.btnNovo.setBackground(new Color(100, 149, 237));
		ToolbarLeft.btnNovo.setForeground(Color.WHITE);

		ToolbarLeft.btnEditar.setBackground(Color.WHITE);
		ToolbarLeft.btnEditar.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
		ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnHorarioEstudo.setBackground(Color.WHITE);
		ToolbarTop.btnHorarioEstudo.setForeground(new Color(100, 149, 237));

	}

	public static void btnEditPessoaSelected() {
		ToolbarLeft.btnNovo.setBackground(Color.WHITE);
		ToolbarLeft.btnNovo.setForeground(new Color(100, 149, 237));

		ToolbarLeft.btnEditar.setBackground(new Color(100, 149, 237));
		ToolbarLeft.btnEditar.setForeground(Color.WHITE);

		ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
		ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnHorarioEstudo.setBackground(Color.WHITE);
		ToolbarTop.btnHorarioEstudo.setForeground(new Color(100, 149, 237));

	}

	public static void btnCompromissoSelected() {
		ToolbarLeft.btnNovo.setBackground(Color.WHITE);
		ToolbarLeft.btnNovo.setForeground(new Color(100, 149, 237));

		ToolbarLeft.btnEditar.setBackground(Color.WHITE);
		ToolbarLeft.btnEditar.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnCompromisso.setBackground(new Color(100, 149, 237));
		ToolbarTop.btnCompromisso.setForeground(Color.WHITE);

		ToolbarTop.btnHorarioEstudo.setBackground(Color.WHITE);
		ToolbarTop.btnHorarioEstudo.setForeground(new Color(100, 149, 237));

	}

	public static void btnHorarioEstudoSelected() {
		ToolbarLeft.btnNovo.setBackground(Color.WHITE);
		ToolbarLeft.btnNovo.setForeground(new Color(100, 149, 237));

		ToolbarLeft.btnEditar.setBackground(Color.WHITE);
		ToolbarLeft.btnEditar.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
		ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));

		ToolbarTop.btnHorarioEstudo.setBackground(new Color(100, 149, 237));
		ToolbarTop.btnHorarioEstudo.setForeground(Color.WHITE);

	}

	public static void populandoCompromisso() {
		ArrayList<Compromisso> allCompromissos = SQLite.getCompromissos();
		ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();

		for (Compromisso _compromisso : allCompromissos) {
			if (_compromisso.getPessoaId() == ToolbarLeft.jListPessoas.getSelectedValue().getPessoaId()) {
				compromissos.add(_compromisso);
			}
		}
		Compromisso[][] compromissoM = PanelAllCompromisso.rowData;

		for (int i = 0; i < compromissoM.length; i++) {
			for (int j = 0; j < compromissoM[i].length; j++) {
				if (j == 0) {
					for(int z = 0; z < compromissos.size(); z++){
						
					}
					compromissoM[i][j] = compromissos.get(i);
				}
				if (j == 1) {
					compromissoM[i][j] = compromissos.get(i);
				}

				if (j == 2) {
					compromissoM[i][j] = compromissos.get(i);
				}
				
				if( j == 3){
					compromissoM[i][j] = compromissos.get(i);
				}
				
				if( j == 4){
					compromissoM[i][j] = compromissos.get(i);
				}
				
				if( j == 5){
					compromissoM[i][j] = compromissos.get(i);
				}
				
				if( j == 6){
					compromissoM[i][j] = compromissos.get(i);
				}
				
				if( j == 7){
					compromissoM[i][j] = compromissos.get(i);
				}
			}
		}

	}

	public static KeyAdapter alphabeticOnlyAdapter() {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!Character.isAlphabetic(e.getKeyChar())) {
					e.consume();
				}
			}
		};

		return keyAdapter;
	}

	public static String[] GerarHorarios() {
		String[] horarios = new String[25];
		horarios[0] = "Inicial/Final";

		for (int i = 1; i < horarios.length; i++) {
			if (i > 4) {
				horarios[i] = (i - 1) + ":30";
			} else {
				horarios[i] = "0" + (i - 1) + ":30";
			}

		}

		return horarios;
	}

}
