package br.com.mauriciotsilva.malhalogistica.dominio.rota;

public class Malha {

	private Mapa mapa;
	private String origem;
	private String destino;
	private int distancia;

	protected Malha() {
	}

	public Malha(Mapa mapa, String origem, String destino, int distancia) {
		this.mapa = mapa;
		mapa.adicionar(this);
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
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
