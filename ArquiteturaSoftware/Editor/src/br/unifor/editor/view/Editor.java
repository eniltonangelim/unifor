package br.unifor.editor.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Editor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("Arquivo");
	private JTextArea texto = new JTextArea();
	private Action salvar = new Salvar(this.texto);
	private Action abrir = new Abrir();
	
	public Editor(){
		super("JEd");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container interno = this.getContentPane();
		this.montaMenu();
		this.montaGUI(interno);
	}
	
	private void montaMenu(){
		JMenuItem itemSalvar = new JMenuItem(this.salvar);
		JMenuItem itemAbrir  = new JMenuItem(this.abrir);
		this.menu.add(itemSalvar);
		this.menu.add(itemAbrir);
		this.menubar.add(this.menu);
		this.setJMenuBar(this.menubar);
	}
	
	private void montaGUI(Container interno) {
		interno.setLayout(new BorderLayout());
		interno.add(new JScrollPane(this.texto));
	}
	
	public static void main(String[] args) {
		Editor janela = new Editor();
		janela.setSize(640, 480);
		janela.setVisible(true);
	}
	
}
