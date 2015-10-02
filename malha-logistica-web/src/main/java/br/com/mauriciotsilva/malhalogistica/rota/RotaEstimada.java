package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;
import java.util.LinkedList;
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
		this.malhas = new LinkedList<>();

		registarMalhas(entrada, percorrer(rota));

	}

	private Queue<Rota> percorrer(Rota rota) {

		Queue<Rota> rotas = new PriorityQueue<Rota>();
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

		BigDecimal numero = new BigDecimal(distancia).divide(new BigDecimal(entrada.getAutonomia()));
		custo = numero.multiply(entrada.getValorCombustivel());

		malhas.add(malha);
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
