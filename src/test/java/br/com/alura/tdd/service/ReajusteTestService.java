package br.com.alura.tdd.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteTestService {

	@Test
	public void reajusteDeveriaSerTresPorcentoQuandoODesempenhoFicouADesejar() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Enzo", LocalDate.now(), new BigDecimal("1000.00") );
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	public void reajusteDeveriaSerDezPorcentoQuandoDesempenhoFicouBom() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario2 = new Funcionario("Yuri", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario2, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1100.00"), funcionario2.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerVintePorcentoQuandoDesempenhoForOtimo() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario3 = new Funcionario("Vitoria", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario3, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario3.getSalario());
		
	}

}
