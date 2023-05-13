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
	
	
	@Test
	void deveriaSerDezPorcentoParaFuncionarioComSalarioBase() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Enzo", LocalDate.now(), new BigDecimal("5000")));
		
		assertEquals(new BigDecimal("500.0"), bonus);
	}
	
	
	@Test
	void DeveriaSerZeroPAraFuncionarioComSalarioZero() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Enzo", LocalDate.now(), new BigDecimal("0")));
		
		assertEquals(new BigDecimal("0.0"), bonus);
	}
	
	@Test
	void DeveriaSerValorExato() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Enzo", LocalDate.now(), new BigDecimal("9750.64")));
		
		assertEquals(new BigDecimal("975.064"), bonus);
	}


}
