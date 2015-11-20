package POO_AgendaDigital.Services;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Interface.MainFrame;

public class Services {

	private static MainFrame MainFrame;
	
	public Services(){
		MainFrame = new MainFrame();
	}
	
	public static void setJFrame(MainFrame jFrame){
		MainFrame = jFrame;
	}
	
	public static void SwitchPanelService(String e, Pessoa... Pessoa){
		switch (e) {
		case "Novo":
			POO_AgendaDigital.Interface.MainFrame.isCreatePanelActive = true;
			POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa.setVisible(true);

			POO_AgendaDigital.Interface.MainFrame.isEditPanelActive = false;
			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setVisible(false);

			POO_AgendaDigital.Interface.MainFrame.isCalendarioPanelActive = false;
			POO_AgendaDigital.Interface.MainFrame.calendario.setVisible(false);

			POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa);

			break;

		case "Editar":
			
			POO_AgendaDigital.Interface.MainFrame.isCreatePanelActive = false;
			POO_AgendaDigital.Interface.MainFrame.pnCreatePessoa.setVisible(false);

			POO_AgendaDigital.Interface.MainFrame.isEditPanelActive = true;
			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setVisible(true);

			POO_AgendaDigital.Interface.MainFrame.isCalendarioPanelActive = false;
			POO_AgendaDigital.Interface.MainFrame.calendario.setVisible(false);

			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setModel(POO_AgendaDigital.Interface.MainFrame.tbLeft.model);
			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setBounds(250, 80, 802, 595);
			MainFrame.getContentPane().add(POO_AgendaDigital.Interface.MainFrame.pnEditPessoa);

			POO_AgendaDigital.Interface.MainFrame.pnEditPessoa.setPessoaClickada(Pessoa[0]);

			break;

		default:
			break;
		}
	}
	
}
