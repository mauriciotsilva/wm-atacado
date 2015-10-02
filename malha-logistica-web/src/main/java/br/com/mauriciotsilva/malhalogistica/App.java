package br.com.mauriciotsilva.malhalogistica;

import java.math.BigDecimal;
import java.util.List;

import br.com.mauriciotsilva.malhalogistica.repositorio.MalhaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.EstimativaMalhaService;

public class App {

	public static void main(String[] args) {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("D");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		EstimativaMalhaService rotaService = new EstimativaMalhaService(new MalhaRepository());

		List<RotaEstimada> estimativas = rotaService.listarEstimativas(entrada);

		System.out.println(estimativas.size());
		estimativas.stream().forEach(estimativa -> {
			System.out.println(estimativa.getMalhas() + " " + estimativa.getDistancia() + " " + estimativa.getCusto());
		});

	}
}
