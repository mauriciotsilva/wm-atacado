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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + distancia;
		result = prime * result + ((mapa == null) ? 0 : mapa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Malha other = (Malha) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (distancia != other.distancia)
			return false;
		if (mapa == null) {
			if (other.mapa != null)
				return false;
		} else if (!mapa.equals(other.mapa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "origem: " + origem + " destino: " + destino;
	}

}
