package br.com.mauriciotsilva.malhalogistica.service;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;

public class Rota implements Comparable<Rota> {

	private Rota anterior;
	private Malha atual;
	private int index;

	public Rota(Rota anterior, Malha atual) {
		this.anterior = anterior;
		this.atual = atual;
		this.index = 0;

		if (!isInicio()) {
			index = anterior.index + 1;
		}

	}

	public boolean isInicio() {
		return anterior == null;
	}

	public Rota getAnterior() {
		return anterior;
	}

	public Malha getAtual() {
		return atual;
	}

	@Override
	public int compareTo(Rota o) {
		return index - o.index;
	}

}
