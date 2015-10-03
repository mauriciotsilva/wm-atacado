package br.com.mauriciotsilva.malhalogistica.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;

public class MapearRota {

	private final Map<String, List<Malha>> grupo;
	private List<RotaEstimada> estimativas;

	public MapearRota(Collection<Malha> malhas) {
		estimativas = new ArrayList<>();
		grupo = malhas.stream().collect(groupingBy(Malha::getOrigem, toList()));
	}

	public List<RotaEstimada> listar(EntradaEstimativaMalha entrada) {
		mapearRota(entrada, entrada.getOrigem(), null);
		return estimativas;
	}

	private void mapearRota(EntradaEstimativaMalha entrada, String origem, Rota anterior) {

		List<Malha> malhas = grupo.getOrDefault(origem, new ArrayList<>());

		for (Malha malha : malhas) {

			Rota rota = new Rota(anterior, malha);
			if (malha.getDestino().equals(entrada.getDestino())) {
				estimativas.add(new RotaEstimada(entrada, rota));
				break;
			}

			mapearRota(entrada, malha.getDestino(), rota);
		}
	}

}
