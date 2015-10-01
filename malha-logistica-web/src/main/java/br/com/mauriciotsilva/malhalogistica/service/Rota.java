package br.com.mauriciotsilva.malhalogistica.service;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;

public class Rota {

	private Malha anterior;
	private Malha atual;

	public Rota(Malha anterior, Malha atual) {
		this.anterior = anterior;
		this.atual = atual;
	}

	public Malha getAtual() {
		return atual;
	}

	public Malha getAnterior() {
		return anterior;
	}

}
