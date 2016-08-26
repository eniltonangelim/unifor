package br.unifor.editor.view;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.unifor.editor.bo.ArquivoBO;
import br.unifor.editor.constants.Message;
import br.unifor.editor.entity.Arquivo;

public class Abrir extends AbstractAction implements Message {
	
	private static final long serialVersionUID = 1L;
	private ArquivoBO arquivoBO;
	private JTextArea texto;

	public Abrir(JTextArea texto){
		super("Abrir");
		this.texto=texto;
		this.putValue(Action.SHORT_DESCRIPTION,  shortDescriptionAbrir);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Aplicação java","class","java");
		jfc.setFileFilter(filter);
		
		int returnIn = jfc.showOpenDialog(jfc);

		if ( returnIn	== JFileChooser.APPROVE_OPTION ){
			System.out.println(jfc.getSelectedFile().getAbsolutePath());
			
			this.arquivoBO = new ArquivoBO(new Arquivo(jfc.getSelectedFile()));
			try {
				this.texto.read(this.arquivoBO.abrirArquivo(), null);
				this.arquivoBO.abrirArquivo().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
}
