package br.com.mauriciotsilva.malhalogistica.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.repositorio.RotaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;

public class RotaService {

	private RotaRepository repository;

	public RotaService() {
		repository = new RotaRepository();
	}

	public List<RotaEstimada> listarEstimativas(EntradaEstimativaRota entrada) {

		List<Malha> malhas = repository.listarMalhas();
		Map<String, List<Malha>> grupoMalhas = malhas.stream().collect(groupingBy(Malha::getOrigem, toList()));

		return listarEstimativas(entrada, grupoMalhas);
	}

	private List<RotaEstimada> listarEstimativas(EntradaEstimativaRota entrada, Map<String, List<Malha>> grupo) {

		List<RotaEstimada> estimadas = new ArrayList<>();

		List<Malha> malhas = grupo.get(entrada.getOrigem());
		if(malhas == null){
			malhas = new ArrayList<>();
		}
		for (Malha malha : malhas) {

			RotaEstimada estimada = new RotaEstimada(entrada);
			estimada.adicionar(malha);

			List<Malha> rotas = grupo.get(malha.getDestino());
			if (rotas != null) {
				rotas.stream().filter(rota -> rota.getDestino().equals(entrada.getDestino())).forEach(rota -> {
					estimada.adicionar(rota);
				});
			}

			estimadas.add(estimada);
		}

		return estimadas.stream().filter(RotaEstimada::atende)
				.sorted((estimativa, outra) -> estimativa.getDistancia() - outra.getDistancia()).collect(toList());
	}

}
