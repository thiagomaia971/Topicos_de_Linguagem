
package POO_AgendaDigital.Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

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

		
		isCreatePanelActive = false;
		isEditPanelActive = false;
		isHorarioEstudoPanelActive = false;
		isAllCompromissoPanelActive = false;
		isCreateCompromissoPanelActive = false;

		tbLeft = new ToolbarLeft();
		Pessoa pessoaClicked =(Pessoa) ToolbarLeft.jListPessoas.getSelectedValue();
		pnEditPessoa = new PanelEditPessoa();
		pnCreatePessoa = new PanelCreatePessoa();
		pnAllCompromisso = new PanelAllCompromisso();
		pnCreateCompromisso = new PanelCreateCompromisso();
		pnHorarioEstudo = new PanelHorarioEstudo(pessoaClicked);
		
		
		
		Services.setJFrame(this);

		tbLeft.setLeftToolbarListener(new ILeftToolbarListener() {

			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {

				//pnCreatePessoa = new PanelCreatePessoa();
				Services.SwitchPanelService(e, Pessoa);

				revalidate();
				repaint();

			}

		});

		tbLeft.setListListener(new IListListener() {

			@Override
			public void valueChange(Pessoa PessoaClickada) {
				
				pnCreatePessoa.setVisible(false);
				pnEditPessoa.setVisible(false);
				pnAllCompromisso.setVisible(false);

				isHorarioEstudoPanelActive = true;
				pnHorarioEstudo.setVisible(isHorarioEstudoPanelActive);
				pnHorarioEstudo.setBounds(250, 70, 792, 558);
				pnHorarioEstudo.setPessoaClickada(PessoaClickada);

				getContentPane().add(pnHorarioEstudo);
				revalidate();
				repaint();

			}
		});
		
		
		
		tbTop = new ToolbarTop();

		tbTop.setListListener(new ILeftToolbarListener() {
			
			@Override
			public void buttomEventCurrent(String e, Pessoa... Pessoa) {
				
				Services.SwitchPanelService(e, Pessoa);
				
				repaint();
				revalidate();
				
			}
		});
		
		tbLeft.setBounds(0, 0, 250, 595);
		tbTop.setBounds(250, 0, 802, 80);

		if(ToolbarLeft.jListPessoas.isSelectionEmpty()){
			isCreatePanelActive = true;
			
			pnCreatePessoa.setBounds(250, 80, 802, 595);
			this.getContentPane().add(pnCreatePessoa);
			
			tbLeft.btnNovo.setBackground(new Color(100, 149, 237));
			tbLeft.btnNovo.setForeground(Color.WHITE);
			
			tbTop.btnCompromisso.setBackground(Color.WHITE);
			tbTop.btnCompromisso.setForeground(new Color(100, 149, 237));
			
			tbTop.btnHorarioEstudo.setBackground(Color.WHITE);
			tbTop.btnHorarioEstudo.setForeground(new Color(100, 149, 237));
			
		}else {
			isHorarioEstudoPanelActive = true;
			pessoaClicked =(Pessoa) ToolbarLeft.jListPessoas.getSelectedValue();
			
			pnHorarioEstudo = new PanelHorarioEstudo(pessoaClicked);
			pnHorarioEstudo.setBounds(250, 80, 802, 595);
			//ToolbarTop.btnHorarioEstudo.setBackground(new Color(65, 105, 225));
			//ToolbarTop.btnHorarioEstudo.setBackground(new Color(176, 196, 222));
			ToolbarTop.btnHorarioEstudo.setBackground(new Color(100, 149, 237));
			ToolbarTop.btnHorarioEstudo.setForeground(Color.WHITE);
			
			ToolbarTop.btnCompromisso.setBackground(Color.WHITE);
			ToolbarTop.btnCompromisso.setForeground(new Color(100, 149, 237));
			
			this.getContentPane().add(pnHorarioEstudo);
			
		}
		revalidate();
		repaint();
		
		this.getContentPane().add(tbLeft);
		this.getContentPane().add(tbTop);

		this.revalidate();
		this.repaint();

		tbLeft.setLayout(null);
	}
}
