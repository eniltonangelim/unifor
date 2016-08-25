package br.unifor.editor.bo;

import java.util.StringTokenizer;

import br.unifor.editor.constants.Message;
import br.unifor.editor.dao.ArquivoDAO;
import br.unifor.editor.entity.Arquivo;
import br.unifor.editor.util.SintaxeInvalidaException;

public class ArquivoBO implements Message{
	
	private Arquivo arquivo;
	private ArquivoDAO arquivoDAO;
	
	public ArquivoBO(Arquivo arquivo){
		this.arquivo = arquivo;
	}
	
	public void salvarArquivo(){
		if (this.verificaChaves()){
			this.arquivoDAO = new ArquivoDAO(arquivo);
			this.arquivoDAO.saveFile();
		} else {
			new SintaxeInvalidaException(sintaxeInvalida);
		}
		
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
