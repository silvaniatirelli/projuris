package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MyCalculoTest {

	@Test
	public void custoPorCargoTest() {
		MyCalculo myCalculo = new MyCalculo();
		List<Funcionario> listaFuncionarios = getFuncionarios();
		List<CustoCargo> custoCargoResult = myCalculo.custoPorCargo(listaFuncionarios);
		
		BigDecimal custoCargoAssistente = getCustoPorCargo("Assistente", custoCargoResult);
		Assert.assertEquals(new BigDecimal(4101.8), custoCargoAssistente);
		BigDecimal custoCargoGerente = getCustoPorCargo("Gerente", custoCargoResult);
		Assert.assertEquals(new BigDecimal(24001.2), custoCargoGerente);
		BigDecimal custoCargoDiretor = getCustoPorCargo("Diretor", custoCargoResult);
		Assert.assertEquals(new BigDecimal(34000.45), custoCargoDiretor);
		BigDecimal custoCargoEstagiario = getCustoPorCargo("Estagiário", custoCargoResult);
		Assert.assertEquals(new BigDecimal(700.4), custoCargoEstagiario);		
	}
	
	@Test
	public void custoPorDepartamentoTest() {
		MyCalculo myCalculo = new MyCalculo();
		List<Funcionario> listaFuncionarios = getFuncionarios();
		List<CustoDepartamento> custoDepartamentoResult = myCalculo.custoPorDepartamento(listaFuncionarios);
		
		BigDecimal custoDepartamentoAdministrativo = getCustoPorDepartamento("Administrativo", custoDepartamentoResult);
		Assert.assertEquals(new BigDecimal(18001.15), custoDepartamentoAdministrativo);	
		BigDecimal custoDepartamentoFinanceiro = getCustoPorDepartamento("Financeiro", custoDepartamentoResult);
		Assert.assertEquals(new BigDecimal(19800.9), custoDepartamentoFinanceiro);	
		BigDecimal custoDepartamentoJuridico = getCustoPorDepartamento("Jurídico", custoDepartamentoResult);
		Assert.assertEquals(new BigDecimal(25001.80), custoDepartamentoJuridico);	
	}
	
	private static List<Funcionario> getFuncionarios() {
		List<Funcionario> listaFuncionario = new ArrayList<>();
		listaFuncionario.add(new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0)));
		listaFuncionario.add(new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70)));
		listaFuncionario.add(new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45)));
		listaFuncionario.add(new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9)));
		listaFuncionario.add(new Funcionario("Gerente", "Financeiro", new BigDecimal(7500)));
		listaFuncionario.add(new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0)));
		listaFuncionario.add(new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4)));
		listaFuncionario.add(new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90)));
		listaFuncionario.add(new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50)));
		listaFuncionario.add(new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0)));
		return listaFuncionario;
	}
	
	public BigDecimal getCustoPorCargo(String cargo, List<CustoCargo> custoCargo){
		for (CustoCargo custoCargoItem : custoCargo) {
			if (cargo.equals(custoCargoItem.getCargo())) {
				return custoCargoItem.getCusto();
			}
		}
		return new BigDecimal(0);
	}

	public BigDecimal getCustoPorDepartamento(String departamento, List<CustoDepartamento> custoDepartamento){
		for (CustoDepartamento custoDepartamentoItem : custoDepartamento) {
			if (departamento.equals(custoDepartamentoItem.getDepartamento())) {
				return custoDepartamentoItem.getCusto();
			}
		}
		return new BigDecimal(0);
	}
}
