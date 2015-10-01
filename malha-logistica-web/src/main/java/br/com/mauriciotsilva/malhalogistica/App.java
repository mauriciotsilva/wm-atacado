package br.com.mauriciotsilva.malhalogistica;

import java.math.BigDecimal;

import br.com.mauriciotsilva.malhalogistica.repositorio.RotaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

public class App {

	public static void main(String[] args) {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("X");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaService rotaService = new RotaService(new RotaRepository());
		System.out.println(rotaService.listarEstimativas(entrada).size());
	}
}
