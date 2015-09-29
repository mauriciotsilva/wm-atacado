package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;

public class EntradaEstimativaRota {

	private String destino;
	private String origem;
	private String nomeMapa;
	private Integer autonomia;
	private BigDecimal valorCombustivel;

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getNomeMapa() {
		return nomeMapa;
	}

	public void setNomeMapa(String nomeMapa) {
		this.nomeMapa = nomeMapa;
	}

	public Integer getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Integer autonomia) {
		this.autonomia = autonomia;
	}

	public BigDecimal getValorCombustivel() {
		return valorCombustivel;
	}

	public void setValorCombustivel(BigDecimal valorCombustivel) {
		this.valorCombustivel = valorCombustivel;
	}

}
