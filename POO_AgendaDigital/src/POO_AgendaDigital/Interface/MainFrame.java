
package POO_AgendaDigital.Interface;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import POO_AgendaDigital.Core.Pessoa;
import POO_AgendaDigital.Infraestrutura.SQLite;
import POO_AgendaDigital.Interface.Listeners.ILeftToolbarListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	private ToolbarLeft tbLeft;
	private ToolbarTop tbTop;
	private PanelCreatePessoa pnCreatePessoa;
	private PanelEditPessoa pnEditPessoa; 

	private static String pathDb;
	
	boolean pnCreatePessoaActive;
	boolean pnEditPessoaActive;
	
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
		
		//EndRegion
		
		try {
			pathDb = new File("").getCanonicalPath();
			new SQLite(pathDb + "\\AgendaDigitalDb.sqlite");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		pnCreatePessoaActive = false;
		pnEditPessoaActive = false;
		
		tbLeft = new ToolbarLeft();
		pnEditPessoa = new PanelEditPessoa();
		pnCreatePessoa = new PanelCreatePessoa();
		
		tbLeft.setLeftToolbarListener(new ILeftToolbarListener() {
			
			@Override
			public void buttomEventCurrent(String e, Pessoa Pessoa) {
				
				if(pnCreatePessoaActive){
					
					pnCreatePessoaActive = !pnCreatePessoaActive;
					pnCreatePessoa.setVisible(pnCreatePessoaActive);
					
					pnEditPessoaActive = !pnEditPessoaActive;
					pnEditPessoa.setVisible(pnEditPessoaActive);
					
					revalidate();
					repaint();
					
				}else if(!pnEditPessoaActive){
					pnEditPessoaActive = !pnEditPessoaActive;
				}
				pnEditPessoa.setModel(tbLeft.model);
				pnEditPessoa.setBounds(250, 80, 802, 595);
				getContentPane().add(pnEditPessoa);
				
				pnEditPessoa.setPessoaClickada(Pessoa);
				
				revalidate();
				repaint();
			
			}
			
			@Override
			public void buttomEventCurrent(String e) {
				
				if(pnEditPessoaActive){
					pnCreatePessoaActive = !pnCreatePessoaActive;
					pnCreatePessoa.setVisible(pnCreatePessoaActive);
					
					pnEditPessoaActive = !pnEditPessoaActive;
					pnEditPessoa.setVisible(pnEditPessoaActive);
					
					revalidate();
					repaint();
				}else if(!pnCreatePessoaActive){
					pnCreatePessoaActive = !pnCreatePessoaActive;
				}
				
				pnCreatePessoa.setBounds(250, 80, 802, 595);
				getContentPane().add(pnCreatePessoa);
				pnCreatePessoa.setModel(tbLeft.model);
			
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
