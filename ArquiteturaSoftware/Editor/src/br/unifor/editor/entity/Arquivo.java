package br.unifor.editor.entity;

import java.io.File;

public class Arquivo {

	private File arquivo;
	private String conteudo;
	
	public Arquivo(File arquivo, String conteudo){
		this.arquivo = arquivo;
		this.conteudo = conteudo;
		
	}

	public File getArquivo() {
		return arquivo;
	}


	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}


	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}
