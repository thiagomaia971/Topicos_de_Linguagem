
package POO_AgendaDigital.Interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JList;

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
	public static Calendario calendario;

	private static String pathDb;

	public static boolean isCreatePanelActive;
	public static boolean isEditPanelActive;
	public static boolean isCalendarioPanelActive;

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
		
		Services.setJFrame(this);
	
		tbLeft.setLeftToolbarListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {
				
				Services.SwitchPanelService(e, Pessoa);

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
