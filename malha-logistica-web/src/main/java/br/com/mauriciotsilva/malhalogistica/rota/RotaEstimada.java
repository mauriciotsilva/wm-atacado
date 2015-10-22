package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.service.Rota;

public class RotaEstimada implements Comparable<RotaEstimada> {

	private String origem;
	private String destino;
	private Integer distancia;
	private BigDecimal custo;
	private List<Malha> malhas;

	public RotaEstimada(EntradaEstimativaMalha entrada, Rota rota) {

		this.distancia = 0;
		this.malhas = new ArrayList<>();

		registarMalhas(entrada, percorrer(rota));

	}

	private Queue<Rota> percorrer(Rota rota) {

		Queue<Rota> rotas = new PriorityQueue<>();
		rotas.add(rota);

		while (!rota.isInicio()) {
			rota = rota.getAnterior();
			rotas.add(rota);
		}

		return rotas;
	}

	private void registarMalhas(EntradaEstimativaMalha entrada, Queue<Rota> percorridas) {
		while (!percorridas.isEmpty()) {
			Rota rota = percorridas.poll();
			adicionar(entrada, rota.getAtual());
		}
	}

	private void adicionar(EntradaEstimativaMalha entrada, Malha malha) {

		distancia += malha.getDistancia();

		destino = malha.getDestino();
		if (origem == null) {
			origem = malha.getOrigem();
		}

		custo = calcularCusto(entrada);
		malhas.add(malha);
	}

	private BigDecimal calcularCusto(EntradaEstimativaMalha entrada) {

		BigDecimal autonomia = BigDecimal.valueOf(entrada.getAutonomia());

		BigDecimal numero = new BigDecimal(distancia).divide(autonomia, 2, RoundingMode.HALF_EVEN);
		return numero.multiply(entrada.getValorCombustivel()).setScale(2, RoundingMode.HALF_EVEN);
	}

	public List<Malha> getMalhas() {
		return malhas;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	@Override
	public int compareTo(RotaEstimada rota) {
		return distancia - rota.distancia;
	}

}
