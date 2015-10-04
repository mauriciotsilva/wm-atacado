package br.com.teste.teste;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.repositorio.MalhaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.EstimativaMalhaService;

public class Teste {

	private static List<Malha> malhas;

	@BeforeClass
	public static void iniciar() {
		malhas = new ArrayList<>();

		malhas.add(new Malha("SP", "A", "B", 10));
		malhas.add(new Malha("SP", "B", "D", 15));
		malhas.add(new Malha("SP", "A", "C", 20));
		malhas.add(new Malha("SP", "C", "D", 30));
		malhas.add(new Malha("SP", "B", "E", 50));
		malhas.add(new Malha("SP", "D", "E", 30));
	}
	

	@Test
	public void deveRetornarUmCaminhoComposto() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("D");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = listar(entrada).get(0);

		assertEquals(new BigDecimal("6.25"), estimada.getCusto());
		assertEquals(2, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoDireto() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setAutonomia(10);
		entrada.setOrigem("A");
		entrada.setDestino("C");
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = listar(entrada).get(0);

		assertEquals(new BigDecimal("5.00"), estimada.getCusto());
		assertEquals(1, estimada.getMalhas().size());

	}

	@Test
	public void deveRetornarUmCaminhoX() {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();
		entrada.setNomeMapa("SP");
		entrada.setOrigem("B");
		entrada.setDestino("E");
		entrada.setAutonomia(10);
		entrada.setValorCombustivel(new BigDecimal("2.5"));

		RotaEstimada estimada = listar(entrada).get(0);

		assertEquals(new BigDecimal("11.25"), estimada.getCusto());
		assertEquals(2, estimada.getMalhas().size());

	}

	private List<RotaEstimada> listar(EntradaEstimativaMalha entrada) {

		MalhaRepository repository = Mockito.mock(MalhaRepository.class);
		Mockito.when(repository.listar(entrada)).thenReturn(malhas);

		return new EstimativaMalhaService(repository).listarEstimativas(entrada);
	}

}
