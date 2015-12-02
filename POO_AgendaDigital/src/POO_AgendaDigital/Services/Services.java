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
import POO_AgendaDigital.Interface.PanelHorarioEstudo;
import POO_AgendaDigital.Interface.ToolbarLeft;
import POO_AgendaDigital.Interface.ToolbarTop;

import java.util.List.*;

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

	public static String[][] populandoCompromisso(Pessoa pessoaSelected) {
		ArrayList<Compromisso> allCompromissos = SQLite.getCompromissos();
		ArrayList<Compromisso> compromissos = new ArrayList<Compromisso>();

		int c = 0;
		for (Compromisso _compromisso : allCompromissos) {
			if (_compromisso.getPessoaId() == pessoaSelected.getPessoaId()) {
				compromissos.add(_compromisso);
				c++;
			}
		}
		PanelAllCompromisso.rowData = new String [20][8];
		String[][] compromissoM = PanelAllCompromisso.rowData;

		String[] horariosArrayPosition = GerarHorarios();

		for(int i = 1; i < horariosArrayPosition.length; i++){
			//PanelAllCompromisso.rowData[i][0] = horariosArrayPosition[i];
			compromissoM[i][0] = horariosArrayPosition[i];
		}
		
		compromissoM[0][1] = "Segunda";
		compromissoM[0][2] = "Terça";
		compromissoM[0][3] = "Quarta";
		compromissoM[0][4] = "Quinta";
		compromissoM[0][5] = "Sexta";
		compromissoM[0][6] = "Sabado";
		compromissoM[0][7] = "Domingo";
		
		for (int i = 0; i < compromissos.size(); i++) {
			for (int j = 0; j < compromissos.get(i).getDias().size(); j++) {
				int posicaoDiaM = 0;

				if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Segunda")) {
					posicaoDiaM = 1;
				} else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Terça")) {
					posicaoDiaM = 2;
				}else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Quarta")) {
					posicaoDiaM = 3;
				}else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Quinta")) {
					posicaoDiaM = 4;
				}else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Sexta")) {
					posicaoDiaM = 5;
				}else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Sabado")) {
					posicaoDiaM = 6;
				}else if (compromissos.get(i).getDias().get(j).getDia_Semana().equals("Domingo")) {
					posicaoDiaM = 7;
				}
				
				
				String horarioInicial = compromissos.get(i).getDias().get(j).getHoraInicial();
				String horarioFinal = compromissos.get(i).getDias().get(j).getHoraFinal();
				
				int posI = 0;
				int posF = 0;
				
				for (int z = 1; z < horariosArrayPosition.length; z++) {
					if (horariosArrayPosition[z].equals(horarioInicial)) {
						posI = z;
					}
					
					if(horariosArrayPosition[z].equals(horarioFinal)){
						posF = z + 1;
					}
				}
				
				for(int z = posI; z < posF; z++){
					//PanelAllCompromisso.rowData[z][posicaoDiaM] = compromissos.get(i).getNomeCompromisso();
					compromissoM[z][posicaoDiaM] = compromissos.get(i).getNomeCompromisso();
				}
				

			}
		}
		return compromissoM;
	}
	
	public static String[][] gerarTabelaHorario(){
		String[][] matrizAllCompromisso = populandoCompromisso(ToolbarLeft.jListPessoas.getSelectedValue());
		String[][] matrizHorarioEstudo = PanelHorarioEstudo.rowData;

		String[] horariosArrayPosition = Services.GerarHorarios();

		for (int i = 1; i < horariosArrayPosition.length; i++) {
			matrizHorarioEstudo[i][0] = horariosArrayPosition[i];
		}

		matrizHorarioEstudo[0][1] = "Segunda";
		matrizHorarioEstudo[0][2] = "Terça";
		matrizHorarioEstudo[0][3] = "Quarta";
		matrizHorarioEstudo[0][4] = "Quinta";
		matrizHorarioEstudo[0][5] = "Sexta";
		matrizHorarioEstudo[0][6] = "Sabado";
		matrizHorarioEstudo[0][7] = "Domingo";
		
		
		int[] cont = new int[7];
		/*for(int i = 0; i < cont.length; i++){
			cont[i] = new int[]();
		}*/

		for (int i = 1; i < matrizAllCompromisso.length; i++) {
			for (int j = 1; j < matrizAllCompromisso[i].length; j++) {
				if (matrizAllCompromisso[i][j] == null) {
					if (j == 0 && cont[0] < 3) {
						cont[0]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					if (j == 1 && cont[1] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
					if (j == 2 && cont[2] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
					if (j == 3 && cont[3] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
					if (j == 4 && cont[4] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
					if (j == 5 && cont[5] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
					if (j == 6 && cont[6] < 3) {
						cont[j]++;
						matrizHorarioEstudo[i][j] = "Estudar";
					}
					
				}else{
					matrizHorarioEstudo[i][j] = "  ---------";
				}
			}
		}
		return matrizHorarioEstudo;
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
		String[] horarios = new String[20];
		horarios[0] = "Inicial/Final";
		
		
		for (int i = 1; i < horarios.length; i++) {
			horarios[i] = (i + 4) + ":30";
			
		}
		
		return horarios;
	}
	
}
