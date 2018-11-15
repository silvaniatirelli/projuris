package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/MyCalculo")
@RestController
public class MyCalculo implements Calculo {
	
	@RequestMapping(value = "/cargo", method = RequestMethod.POST)
	@Override
	public List<CustoCargo> custoPorCargo(@RequestBody List<Funcionario> funcionarios) {
		
		List<CustoCargo> custoCargo = new ArrayList<CustoCargo>();
		funcionarios.stream()
		.collect(Collectors.groupingBy(Funcionario::getCargo,
				Collectors.summingDouble(Funcionario::getSalarioDouble)))
		.forEach((id,sumTargetCost)->custoCargo.add(new CustoCargo(id, new BigDecimal(sumTargetCost))));
		return custoCargo;
	}

	@RequestMapping(value = "/departamento", method = RequestMethod.POST)
	@Override
	public List<CustoDepartamento> custoPorDepartamento(@RequestBody
			List<Funcionario> funcionarios) {
		List<CustoDepartamento> custoDepartamento = new ArrayList<CustoDepartamento>();
		funcionarios.stream()
		.collect(Collectors.groupingBy(Funcionario::getDepartamento,
				Collectors.summingDouble(Funcionario::getSalarioDouble)))
		.forEach((id,sumTargetCost)->custoDepartamento.add(new CustoDepartamento(id, new BigDecimal(sumTargetCost))));
		return custoDepartamento;
	}
	
}
