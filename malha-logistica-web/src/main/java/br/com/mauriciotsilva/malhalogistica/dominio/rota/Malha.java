package br.com.mauriciotsilva.malhalogistica.dominio.rota;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity(value = "malhas", noClassnameStored = true)
public class Malha {

	@Id
	private ObjectId id;
	private String mapa;
	private String origem;
	private String destino;
	private int distancia;

	protected Malha() {
	}

	public Malha(String mapa, String origem, String destino, int distancia) {
		this.mapa = mapa;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;

	}

	protected ObjectId getId() {
		return id;
	}

	protected void setId(ObjectId id) {
		this.id = id;
	}

	public String getMapa() {
		return mapa;
	}

	protected void setMapa(String mapa) {
		this.mapa = mapa;
	}

	public String getOrigem() {
		return origem;
	}

	protected void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	protected void setDestino(String destino) {
		this.destino = destino;
	}

	public int getDistancia() {
		return distancia;
	}

	protected void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((mapa == null) ? 0 : mapa.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
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
		if (mapa == null) {
			if (other.mapa != null)
				return false;
		} else if (!mapa.equals(other.mapa))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "mapa:" + mapa + " origem: " + origem + " destino: " + destino;
	}

}
