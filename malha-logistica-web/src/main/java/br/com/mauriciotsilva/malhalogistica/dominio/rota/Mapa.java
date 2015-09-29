package br.com.mauriciotsilva.malhalogistica.dominio.rota;

import static java.util.Collections.unmodifiableSet;

import java.util.HashSet;
import java.util.Set;

public class Mapa {

	private String nome;
	private Set<Malha> malhas;

	protected Mapa() {
		this.malhas = new HashSet<>();
	}

	public Mapa(String nome) {
		this();
		this.nome = nome;
	}

	public boolean adicionar(Malha malha) {
		return malhas.add(malha);
	}

	public Set<Malha> getMalhas() {
		return unmodifiableSet(malhas);
	}

	public String getNome() {
		return nome;
	}

}
