package br.unifor.editor.bo;

import java.util.StringTokenizer;

import br.unifor.editor.dao.ArquivoDAO;
import br.unifor.editor.entity.Arquivo;

public class ArquivoBO {
	
	private Arquivo arquivo;
	private ArquivoDAO arquivoDAO;
	
	public ArquivoBO(Arquivo arquivo){
		this.arquivo = arquivo;
		if (this.verificaChaves())
			this.arquivoDAO = new ArquivoDAO(arquivo);
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
