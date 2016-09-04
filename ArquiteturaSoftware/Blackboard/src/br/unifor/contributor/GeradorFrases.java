package br.unifor.contributor;
import br.unifor.blackboard.Blackboard;
import br.unifor.blackboard.Solucao;


public class GeradorFrases implements Contributor {
	
	
	private void updateBlackboard(Solucao novaSolucao) {	
		Blackboard.getInstance().update(novaSolucao);
	}
	
	private Solucao geraFrase(Solucao solucao) {
		int i = 0;
		
		do {
			String palavra = solucao.getPalavras().get(i);
			solucao.getPalavras().remove(0);
			solucao.setFrase(palavra+" ");
			i++;
		} while(i < solucao.getPalavras().size());
		
		return solucao;
		
	}
	
	@Override
	public Integer execCondition() {		
		return Blackboard.getInstance().inspect(this);
	}
	

	@Override
	public void execAction() {
		Solucao solucaoAtual = Blackboard.getInstance().getSolucao();		
		Solucao novaSolucao = this.geraFrase(solucaoAtual);		
		this.updateBlackboard(novaSolucao);		
	}

}
