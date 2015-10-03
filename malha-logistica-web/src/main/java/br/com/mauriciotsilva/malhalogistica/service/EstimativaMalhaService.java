package br.com.mauriciotsilva.malhalogistica.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.inject.Inject;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.repositorio.MalhaRepository;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;

public class EstimativaMalhaService {

	private MalhaRepository repository;

	@Inject
	public EstimativaMalhaService(MalhaRepository repository) {
		this.repository = repository;
	}

	public List<RotaEstimada> listarEstimativas(EntradaEstimativaMalha entrada) {

		List<Malha> malhas = repository.listarMalhas();
		MapearRota estruturador = new MapearRota(malhas);

		return estruturador.listar(entrada).stream().sorted().collect(toList());
	}

}
