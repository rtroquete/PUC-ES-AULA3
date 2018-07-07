package br.puc.se.designPatterns.behavioral.visitor;

public class DescontoIRE {

	public void ajustaValor(Pagamento pagamento) {
		
		switch(pagamento.getTipoEntidade()) {
			case ONG:
				break;
			case ORGAO_GOVERNAMENTAL:
				break;
			case PESSOA_FISICA:
				pagamento.setValor(pagamento.getValor() - pagamento.getValor() * 0.2f);
				break;
			case PESSOA_JURIDICA:
				pagamento.setValor(pagamento.getValor() - pagamento.getValor() * 0.1f);
				break;
			default:
				break;
		}
	}

}
