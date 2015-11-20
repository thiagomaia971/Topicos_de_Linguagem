
package POO_AgendaDigital.Interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;
import POO_AgendaDigital.Interface.Listeners.IListListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private ToolbarLeft tbLeft;
	private ToolbarTop tbTop;
	private PanelCreatePessoa pnCreatePessoa;
	private PanelEditPessoa pnEditPessoa;
	private Calendario calendario;

	private static String pathDb;

	boolean isCreatePanelActive;
	boolean isEditPanelActive;
	boolean isCalendarioPanelActive;

	/**
	 * Create the frame.
	 */
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

		isCreatePanelActive = false;
		isEditPanelActive = false;
		isCalendarioPanelActive = false;

		tbLeft = new ToolbarLeft();
		pnEditPessoa = new PanelEditPessoa();
		pnCreatePessoa = new PanelCreatePessoa();
		calendario = new Calendario();

		tbLeft.setLeftToolbarListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {
		
				switch (e) {
				case "Novo":
					isCreatePanelActive = true;
					pnCreatePessoa.setVisible(true);

					isEditPanelActive = false;
					pnEditPessoa.setVisible(false);

					isCalendarioPanelActive = false;
					calendario.setVisible(false);

					pnCreatePessoa.setBounds(250, 80, 802, 595);
					getContentPane().add(pnCreatePessoa);

					break;

				case "Editar":
					
					isCreatePanelActive = false;
					pnCreatePessoa.setVisible(false);

					isEditPanelActive = true;
					pnEditPessoa.setVisible(true);

					isCalendarioPanelActive = false;
					calendario.setVisible(false);

					pnEditPessoa.setModel(tbLeft.model);
					pnEditPessoa.setBounds(250, 80, 802, 595);
					getContentPane().add(pnEditPessoa);

					pnEditPessoa.setPessoaClickada(Pessoa[0]);

					break;

				default:
					break;
				}

				revalidate();
				repaint();

			}

		});

		tbLeft.setListListener(new IListListener() {

			@Override
			public void valueChange(Pessoa PessoaClickada) {
				if(isCreatePanelActive){
					pnCreatePessoa.setVisible(false);
				}else if(isEditPanelActive){
					pnEditPessoa.setVisible(false);
				}
				
				isCalendarioPanelActive = true;
				calendario.setVisible(isCalendarioPanelActive);
				calendario.setBounds(250, 70, 792, 558);
				calendario.setPessoaClickada(PessoaClickada);
				
				getContentPane().add(calendario);
				revalidate();
				repaint();

			}
		});
		tbTop = new ToolbarTop();

		tbLeft.setBounds(0, 0, 250, 595);
		tbTop.setBounds(250, 0, 802, 80);

		this.getContentPane().add(tbLeft);
		this.getContentPane().add(tbTop);

		this.revalidate();
		this.repaint();

		tbLeft.setLayout(null);
	}
}
