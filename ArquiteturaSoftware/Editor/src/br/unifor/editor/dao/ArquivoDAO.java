package br.unifor.editor.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.unifor.editor.constants.Message;
import br.unifor.editor.entity.Arquivo;
import br.unifor.editor.util.ArquivoException;

public class ArquivoDAO implements Message{

	private Arquivo arquivo;
	
	public ArquivoDAO(Arquivo arquivo){
		this.arquivo = arquivo;
	}
	
	public void saveFile(){
		try{
			FileWriter out = new FileWriter(this.arquivo.getArquivo());
			out.write(this.arquivo.getConteudo());
			out.close();
		} catch (IOException e){
			new ArquivoException(arquivoException + e.getMessage());
		}
	}
	
	public BufferedReader openFile(){
		try{
			FileReader fr = new FileReader(this.arquivo.getArquivo());
			BufferedReader br = new BufferedReader(fr);
			return br;
		} catch (IOException e){
			new ArquivoException(arquivoException + e.getMessage());
			return null;
		}
	}
	
}
