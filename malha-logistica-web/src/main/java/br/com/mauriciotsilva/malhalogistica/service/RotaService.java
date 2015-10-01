package br.com.mauriciotsilva.malhalogistica.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.repositorio.RotaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.MalhaEstimada;

public class RotaService {

	@Inject
	private RotaRepository repository;

	public List<MalhaEstimada> listarEstimativas(EntradaEstimativaMalha entrada) {

		List<Malha> malhas = repository.listarMalhas();
		Map<String, List<Malha>> grupoMalhas = malhas.stream().collect(groupingBy(Malha::getOrigem, toList()));

		return listarEstimativas(entrada, grupoMalhas);
	}

	private List<MalhaEstimada> listarEstimativas(EntradaEstimativaMalha entrada, Map<String, List<Malha>> grupo) {

		List<MalhaEstimada> estimadas = new ArrayList<>();

		List<Malha> malhas = grupo.get(entrada.getOrigem());
		if (malhas == null) {
			malhas = new ArrayList<>();
		}
		for (Malha malha : malhas) {

			MalhaEstimada estimada = new MalhaEstimada(entrada);
			estimada.adicionar(malha);

			List<Malha> rotas = grupo.get(malha.getDestino());
			if (rotas != null) {
				rotas.stream().filter(rota -> rota.getDestino().equals(entrada.getDestino())).forEach(rota -> {
					estimada.adicionar(rota);
				});
			}

			estimadas.add(estimada);
		}

		return estimadas.stream().filter(MalhaEstimada::atende)
				.sorted((estimativa, outra) -> estimativa.getDistancia() - outra.getDistancia()).limit(5)
				.collect(Collectors.toList());
	}

}
