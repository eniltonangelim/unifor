package br.unifor.editor.bo;

import java.io.BufferedReader;
import java.util.StringTokenizer;

import br.unifor.editor.constants.Message;
import br.unifor.editor.dao.ArquivoDAO;
import br.unifor.editor.entity.Arquivo;
import br.unifor.editor.util.ArquivoExtension;
import br.unifor.editor.util.SintaxeInvalidaException;

public class ArquivoBO implements Message{
	
	private Arquivo arquivo;
	private ArquivoDAO arquivoDAO;
	private String extension;
	
	public ArquivoBO(Arquivo arquivo){
		this.arquivo = arquivo;
	}
	
	public void salvarArquivo(){
		
		if (!this.verificaChaves()){
			new SintaxeInvalidaException(sintaxeInvalida);
			return;
		}
		
		if (!this.verificaExtension()){
			new SintaxeInvalidaException(extensionException);
			return;
		}
		
		this.arquivoDAO = new ArquivoDAO(this.arquivo);
		this.arquivoDAO.saveFile();
	}
	
	private boolean verificaExtension() {
		extension = ArquivoExtension.getExtension(arquivo.getArquivo());
		if ( extension != null ){
			if (extension.equals(ArquivoExtension.java)){
				return true;
			}
		}
		return false;
	}

	public BufferedReader abrirArquivo(){
		this.arquivoDAO = new ArquivoDAO(this.arquivo);
		return this.arquivoDAO.openFile();
	}
	
	private boolean verificaChaves(){
		StringTokenizer	st = new StringTokenizer(this.arquivo.getConteudo());
		int contAbertas = 0;
		int contFechadas = 0;
		
		while(st.hasMoreTokens()){
			String palavra = st.nextToken();
			if(palavra.equals("{") || palavra.contains("{"))
				++contAbertas;
			
			if(palavra.equals("}") || palavra.contains("}"))
				++contFechadas;
		}
		
		return contAbertas == contFechadas;
	}
}
