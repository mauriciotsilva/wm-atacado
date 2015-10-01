package br.com.teste.teste;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.MalhaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

public class Teste {

	@Test
	public void deveRetornarUmCaminhoComposto() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("D");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		MalhaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("6.25"), estimada.getCusto());
		Assert.assertEquals(2, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoDireto() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("C");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		MalhaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("5.0"), estimada.getCusto());
		Assert.assertEquals(1, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoX() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("B");
		entrada.setDestino("E");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		MalhaEstimada estimada = new RotaService().listarEstimativas(entrada);

		Assert.assertEquals(new BigDecimal("11.25"), estimada.getCusto());
		Assert.assertEquals(2, estimada.getMalhas().size());

	}

}
