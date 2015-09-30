package br.com.teste.teste;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

public class Teste {

	@Test
	public void deveRetornarUmCaminhoComposto() {

		EntradaEstimativaRota entrada = new EntradaEstimativaRota();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("D");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("6.25"), estimada.getValorViagem());
		Assert.assertEquals(2, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoDireto() {

		EntradaEstimativaRota entrada = new EntradaEstimativaRota();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("C");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("5.0"), estimada.getValorViagem());
		Assert.assertEquals(1, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoX() {

		EntradaEstimativaRota entrada = new EntradaEstimativaRota();
		entrada.setAutonomia(10);
		entrada.setOrigem("B");
		entrada.setDestino("E");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("11.25"), estimada.getValorViagem());
		Assert.assertEquals(2, estimada.getMalhas().size());

	}

}
