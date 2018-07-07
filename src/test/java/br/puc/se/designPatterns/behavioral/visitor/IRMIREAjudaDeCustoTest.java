package br.puc.se.designPatterns.behavioral.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.visitor.AjudaDeCusto;
import br.puc.se.designPatterns.behavioral.visitor.DescontoIRE;
import br.puc.se.designPatterns.behavioral.visitor.DescontoIRM;
import br.puc.se.designPatterns.behavioral.visitor.ImpostoSobre;
import br.puc.se.designPatterns.behavioral.visitor.Pagamento;

public class IRMIREAjudaDeCustoTest {
	
	// teste de ajuda de custo e impostos de modo cumulativo
	// a ajuda de custo precisa ser aplicada antes de qualquer outro desconto
	
	@Test
	public void ajudaCustoTestPFDentroDaFaixa() {
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 200.f);
		new AjudaDeCusto().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 220.f, 0.001f);
		
		new DescontoIRE().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 176.f, 0.001f);
		
		new DescontoIRM().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 176.f, 0.001f);
	}
	
	@Test
	public void ajudaCustoTestPFForaDaFaixa() {
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 1000.f);
		
		new AjudaDeCusto().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 980.f, 0.001f);
		
		new DescontoIRE().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 784.f, 0.001f);
		
		new DescontoIRM().ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 784.f, 0.001f);
		

	}
	
	@Test
	public void ajudaCustoTestPJ() {
		Pagamento pagamentoPj = new Pagamento(ImpostoSobre.PESSOA_JURIDICA, 1000.f);
		new DescontoIRM().ajustaValor(pagamentoPj);
		assertEquals(1000.f, pagamentoPj.getValor(), 0.001f);
		
		new DescontoIRE().ajustaValor(pagamentoPj);
		assertEquals(900.f, pagamentoPj.getValor(), 0.001f);
		
		new AjudaDeCusto().ajustaValor(pagamentoPj);
		assertEquals(882.f, pagamentoPj.getValor(), 0.001f);
	}
	
	@Test
	public void ajudaCustoTestOG() {
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ORGAO_GOVERNAMENTAL, 1000.f);
		new DescontoIRM().ajustaValor(pagamentoOg);
		assertEquals(800.f, pagamentoOg.getValor(), 0.001f);
		
		new DescontoIRE().ajustaValor(pagamentoOg);
		assertEquals(800.f, pagamentoOg.getValor(), 0.001f);
		
		new AjudaDeCusto().ajustaValor(pagamentoOg);
		assertEquals(784.f, pagamentoOg.getValor(), 0.001f);
	}
	
	@Test
	public void ajudaCustoTestONG() {
		Pagamento pagamentoOng = new Pagamento(ImpostoSobre.ONG, 1000.f);
		new DescontoIRM().ajustaValor(pagamentoOng);
		assertEquals(pagamentoOng.getValor(), 1000.f, 0.001f);
		
		new DescontoIRE().ajustaValor(pagamentoOng);
		assertEquals(pagamentoOng.getValor(), 1000.f, 0.001f);
		
		new AjudaDeCusto().ajustaValor(pagamentoOng);
		assertEquals(pagamentoOng.getValor(), 980.f, 0.001f);
	}


}
