package br.unifor.editor.view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;

import br.unifor.editor.constants.Message;

public class Abrir extends AbstractAction implements Message {
	
	private static final long serialVersionUID = 1L;

	public Abrir(){
		super("Abrir");
		this.putValue(Action.SHORT_DESCRIPTION,  shortDescriptionAbrir);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JFileChooser jfc = new JFileChooser();
		jfc.getSelectedFile();
	}

}
