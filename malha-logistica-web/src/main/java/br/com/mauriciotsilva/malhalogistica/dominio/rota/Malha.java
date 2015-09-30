package br.com.mauriciotsilva.malhalogistica.dominio.rota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Malha {

	@XmlTransient
	private Mapa mapa;
	private String origem;
	private String destino;
	private int distancia;

	protected Malha() {
	}

	public Malha(Mapa mapa, String origem, String destino, int distancia) {
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;

		mapa.adicionar(this);
	}

	public Mapa getMapa() {
		return mapa;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public int getDistancia() {
		return distancia;
	}

	@Override
	public String toString() {
		return "origem: " + origem + " destino: " + destino;
	}

}
