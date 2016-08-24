package br.unifor.editor.dao;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.unifor.editor.entity.Arquivo;

public class ArquivoDAO {

	private Arquivo arquivo;
	
	public ArquivoDAO(Arquivo arquivo){
		this.arquivo = arquivo;
		this.saveFile();
	}
	
	private void saveFile(){
		try{
			FileWriter out =new FileWriter(this.arquivo.getArquivo());
			out.write(this.arquivo.getConteudo());
			out.close();
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
}
