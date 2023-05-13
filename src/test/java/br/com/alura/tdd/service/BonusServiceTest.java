package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void deveriaSerZeroParaFuncionarioCOmSalarioAlto() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Enzo", LocalDate.now(), new BigDecimal("25000")));
		
		assertEquals(BigDecimal.ZERO, bonus);
	}

}