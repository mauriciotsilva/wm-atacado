package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RotaEstimada {

	private Integer autonomia;
	private Integer distancia;
	private BigDecimal custo;
	private List<Rota> rotas;

	public RotaEstimada(Integer autonomia, BigDecimal custo) {
		this.custo = custo;
		this.autonomia = autonomia;
		this.distancia = 0;
		this.rotas = new ArrayList<>();
	}

	public void adicionar(Rota rota) {
		distancia += rota.getDistancia();
		this.rotas.add(rota);
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public BigDecimal getValorViagem() {
		
		double numero = (double)distancia/autonomia;
		return new BigDecimal(numero).multiply(custo);
	}

}
