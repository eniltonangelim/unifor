package br.unifor.editor.view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import br.unifor.editor.bo.ArquivoBO;
import br.unifor.editor.constants.Message;
import br.unifor.editor.entity.Arquivo;

public class Salvar extends AbstractAction implements Message {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea texto = new JTextArea();
	private ArquivoBO arquivoBO;
	
	Salvar(JTextArea texto){
		super("Salvar");
		this.texto = texto;
		this.putValue(Action.SHORT_DESCRIPTION,  shortDescriptionSalvar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		int resp = jfc.showSaveDialog(this.texto);
		if ( resp != JFileChooser.APPROVE_OPTION)
			return;
		
		this.arquivoBO = new ArquivoBO(new Arquivo(jfc.getSelectedFile(), this.texto.getText()));
		this.arquivoBO.salvarArquivo();
	}
	

}
