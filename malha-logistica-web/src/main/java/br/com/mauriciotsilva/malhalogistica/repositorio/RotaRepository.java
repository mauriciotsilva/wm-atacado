package br.com.mauriciotsilva.malhalogistica.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.dominio.rota.Mapa;

public class RotaRepository {

	public List<Malha> teste() {

		Mapa mapa = new Mapa("SP");

		List<Malha> malhas = new ArrayList<>();

		malhas.add(new Malha(mapa, "B", "D", 15));
		malhas.add(new Malha(mapa, "A", "B", 10));
		malhas.add(new Malha(mapa, "A", "C", 20));
		malhas.add(new Malha(mapa, "C", "D", 30));

		return malhas;
	}

}
