package POO_AgendaDigital.Services;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Interface.MainFrame;
import POO_AgendaDigital.Interface.ToolbarLeft;

public class Services {

	private static MainFrame MainFrame;

	public Services() {
		MainFrame = new MainFrame();
	}

	public static void setJFrame(MainFrame jFrame) {
		MainFrame = jFrame;
	}

	@SuppressWarnings("static-access")
	public static void SwitchPanelService(String e, Pessoa ... Pessoa) {
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

			POO_AgendaDigital.Interface.PanelHorarioEstudo
					.setPessoaClickada((Pessoa) ToolbarLeft.jListPessoas.getSelectedValue());
			
			POO_AgendaDigital.Interface.MainFrame.pnHorarioEstudo.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnHorarioEstudo);

			break;

		case "NovoCompromisso":

			selectPanelChange(false, false, false, true, false);

			POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso);

			break;

		case "TodosCompromissos":

			selectPanelChange(false, false, false, false, true);

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

		POO_AgendaDigital.Interface.MainFrame.isCreateCompromissoPanelActive = isAllCompromissoPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnCreateCompromisso.setVisible(isCreateCompromissoPanelActive);

		POO_AgendaDigital.Interface.MainFrame.isAllCompromissoPanelActive = isCreateCompromissoPanelActive;
		POO_AgendaDigital.Interface.MainFrame.pnAllCompromisso.setVisible(isAllCompromissoPanelActive);
	}
	
	public static void buttonSelected(JButton btnSelected){
		btnSelected.setBackground(new Color(100, 149, 237));
		btnSelected.setForeground(Color.WHITE);
		MainFrame.revalidate();
		MainFrame.repaint();
	}
	
	public static void buttonDiselected(JButton btnDislected){
		btnDislected.setBackground(Color.WHITE);
		btnDislected.setForeground(new Color(100, 149, 237));
		MainFrame.revalidate();
		MainFrame.repaint();
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
	
	public static String[] GerarHorarios(){
		String[] horarios = new String [25];
		horarios[0] = "Inicial/Final";
		
		for(int i = 1; i < horarios.length; i++){
			if(i > 4){
				horarios[i] = (i - 1)+":30";
			}else{
				horarios[i] = "0"+(i - 1)+":30";
			}
			
		}
		
		return horarios;
	}

}
