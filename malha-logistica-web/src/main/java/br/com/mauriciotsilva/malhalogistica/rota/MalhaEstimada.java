package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;

public class MalhaEstimada {

	private Integer autonomia;
	private Integer distancia;
	private BigDecimal custo;
	private List<Malha> malhas;
	private String origem;
	private String destino;
	private String mapa;
	private EntradaEstimativaMalha entrada;

	public MalhaEstimada(EntradaEstimativaMalha entrada) {
		this.mapa = entrada.getNomeMapa();
		this.entrada = entrada;
		this.autonomia = entrada.getAutonomia();
		this.distancia = 0;
		this.malhas = new ArrayList<>();
	}

	public void adicionar(Malha malha) {
		distancia += malha.getDistancia();

		destino = malha.getDestino();
		if (origem == null) {
			origem = malha.getOrigem();
		}

		double numero = (double) distancia / autonomia;
		custo = new BigDecimal(numero).multiply(entrada.getValorCombustivel());

		malhas.add(malha);
	}

	public boolean atende() {
		return entrada.getOrigem().equals(origem) && entrada.getDestino().equals(destino);
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

	public String getMapa() {
		return mapa;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

}
