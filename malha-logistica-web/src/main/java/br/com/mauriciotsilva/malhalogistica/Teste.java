package br.com.mauriciotsilva.malhalogistica;

import java.math.BigDecimal;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

public class Teste {

	public static void main(String[] args) {

		EntradaEstimativaRota entrada = new EntradaEstimativaRota();
		entrada.setOrigem("A");
		entrada.setDestino("D");
		entrada.setAutonomia(10);
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaService rotaService = new RotaService();
		RotaEstimada estimada = rotaService.estimar(entrada);

		System.out.println(estimada.getValorViagem());
	}

}
