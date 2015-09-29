package br.com.mauriciotsilva.malhalogistica.rota;

import java.math.BigDecimal;

public class Rota {

	private String inicio;
	private String termino;
	private Integer distancia;
	private BigDecimal custoCombustivel;

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getCustoCombustivel() {
		return custoCombustivel;
	}

	public void setCustoCombustivel(BigDecimal custoCombustivel) {
		this.custoCombustivel = custoCombustivel;
	}

}
