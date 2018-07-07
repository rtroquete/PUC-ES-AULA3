package br.puc.se.designPatterns.behavioral.visitor;

public class AjudaDeCusto {

	public void ajustaValor(Pagamento pagamento) {
		
		if(pagamento.getValor() < 250f) {
			pagamento.setValor(pagamento.getValor() * 1.1f);
			return;
		}
		
		pagamento.setValor(pagamento.getValor() - pagamento.getValor() * 0.02f);
	}

}
