package br.com.mauriciotsilva.malhalogistica.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.repositorio.RotaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.rota.Rota;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;

public class RotaService {

	private RotaRepository repository;

	public RotaService() {
		repository = new RotaRepository();
	}

	public RotaEstimada estimar(EntradaEstimativaRota entrada) {

		List<Malha> malhas = repository.teste();

		Map<String, List<Malha>> teste = malhas.stream()
				.collect(Collectors.groupingBy(Malha::getOrigem, Collectors.toList()));

		List<RotaEstimada> estimadas = new ArrayList<>();

		for (String origem : teste.keySet()) {

			for (Malha mal : teste.get(origem)) {
				if (entrada.getOrigem().equals(origem)) {

					RotaEstimada rotaEstimada = new RotaEstimada(entrada.getAutonomia(), entrada.getValorCombustivel());
					Rota r = new Rota();
					r.setInicio(mal.getOrigem());
					r.setTermino(mal.getDestino());
					r.setDistancia(mal.getDistancia());

					rotaEstimada.adicionar(r);

					teste: while (true) {

						List<Malha> d = teste.get(mal.getDestino());
						if (d == null)
							break;
						for (Malha a : d) {
							if (a.getDestino().equals(entrada.getDestino())) {
								Rota rota = new Rota();
								rota.setInicio(a.getOrigem());
								rota.setTermino(a.getDestino());
								rota.setDistancia(a.getDistancia());

								rotaEstimada.adicionar(rota);
								break teste;
							}
						}
					}

					estimadas.add(rotaEstimada);

				}
			}
		}

		return estimadas.stream().min((estimativa, outra) -> estimativa.getDistancia() - outra.getDistancia()).get();
	}

}
