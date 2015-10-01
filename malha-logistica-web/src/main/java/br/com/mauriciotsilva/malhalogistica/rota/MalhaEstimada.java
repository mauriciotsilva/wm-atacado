package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.service.Rota;

public class MalhaEstimada implements Cloneable {

	private Integer autonomia;
	private Integer distancia;
	private BigDecimal custo;
	private LinkedList<Malha> malhas;
	private String origem;
	private String destino;
	private String mapa;
	private EntradaEstimativaMalha entrada;
	private List<Rota> rotas;

	public MalhaEstimada(EntradaEstimativaMalha entrada) {
		this.mapa = entrada.getNomeMapa();
		this.entrada = entrada;
		this.autonomia = entrada.getAutonomia();
		this.distancia = 0;
		this.malhas = new LinkedList<>();
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
	
	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}
	
	public List<Rota> getRotas() {
		return rotas;
	}

	@Override
	public MalhaEstimada clone() {
		try {
			MalhaEstimada est = (MalhaEstimada) super.clone();
			est.malhas = new LinkedList<>();

			return est;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "rotas: "+rotas.size();
	}

}
