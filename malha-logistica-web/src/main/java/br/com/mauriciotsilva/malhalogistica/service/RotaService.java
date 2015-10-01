package br.com.mauriciotsilva.malhalogistica.service;

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

	private RotaRepository repository;

	private String destino;

	@Inject
	public RotaService(RotaRepository repository) {
		this.repository = repository;
	}

	public List<MalhaEstimada> listarEstimativas(EntradaEstimativaMalha entrada) {

		new Teste(repository.listarMalhas()).teste(entrada);
		
		return new ArrayList<>();
	}



}
