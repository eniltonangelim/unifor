package br.unifor.editor.util;

import javax.swing.JOptionPane;

public class SintaxeInvalidaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SintaxeInvalidaException(String message) {
		super(message);
		JOptionPane.showMessageDialog(null,
				message);
	}
	
}