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

public class AbrirAction extends AbstractAction implements Message {
	
	private static final long serialVersionUID = 1L;
	private ArquivoBO arquivoBO;
	private JTextArea texto;

	public AbrirAction(JTextArea texto){
		super(abrirTitle);
		this.texto=texto;
		this.putValue(Action.SHORT_DESCRIPTION,  shortDescriptionAbrir);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		JFileChooser jfc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(abrirExtensionFilter,"java");
		jfc.setFileFilter(filter);
		jfc.setAcceptAllFileFilterUsed(false);
		
		int returnIn = jfc.showOpenDialog(jfc);

		if ( returnIn	== JFileChooser.APPROVE_OPTION ){
			this.arquivoBO = new ArquivoBO(new Arquivo(jfc.getSelectedFile()));
			try {
				this.texto.read(this.arquivoBO.abrirArquivo(), null);
				this.arquivoBO.abrirArquivo().close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		
	}
}
