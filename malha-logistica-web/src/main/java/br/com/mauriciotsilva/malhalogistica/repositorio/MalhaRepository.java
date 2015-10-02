package br.com.mauriciotsilva.malhalogistica.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.dominio.rota.Mapa;

public class MalhaRepository {

	public List<Malha> listarMalhas() {

		Mapa mapa = new Mapa("SP");

		List<Malha> malhas = new ArrayList<>();

		malhas.add(new Malha(mapa, "B", "D", 15));
		malhas.add(new Malha(mapa, "A", "B", 10));
		malhas.add(new Malha(mapa, "A", "C", 20));
		malhas.add(new Malha(mapa, "C", "D", 30));
		malhas.add(new Malha(mapa, "B", "E", 50));
		malhas.add(new Malha(mapa, "D", "E", 30));
		malhas.add(new Malha(mapa, "D", "F", 20));
		malhas.add(new Malha(mapa, "E", "F", 15));
		malhas.add(new Malha(mapa, "C", "E", 20));
		malhas.add(new Malha(mapa, "F", "X", 40));
		malhas.add(new Malha(mapa, "F", "H", 8));
		malhas.add(new Malha(mapa, "H", "X", 18));

		return malhas;
	}

}
