package br.puc.se.designPatterns.behavioral.visitor;

public class DescontoIRM {

	public void ajustaValor(Pagamento pagamento) {
		
		switch(pagamento.getTipoEntidade()) {
			case ONG:
				break;
			case ORGAO_GOVERNAMENTAL:
				pagamento.setValor(pagamento.getValor() - pagamento.getValor() * 0.2f);
				break;
			case PESSOA_FISICA:
				break;
			case PESSOA_JURIDICA:
				break;
			default:
				break;
		}
	}

}
