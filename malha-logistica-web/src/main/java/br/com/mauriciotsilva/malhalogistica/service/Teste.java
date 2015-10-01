package br.com.mauriciotsilva.malhalogistica.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.MalhaEstimada;

public class Teste {

	private String destino;
	private EntradaEstimativaMalha entrada;
	private Map<String, List<Malha>> grupo;

	private List<MalhaEstimada> estimativas;

	public Teste(Collection<Malha> malhas) {
		grupo = malhas.stream().collect(Collectors.groupingBy(Malha::getOrigem, Collectors.toList()));
		this.estimativas = new ArrayList<>();
	}

	public void teste(EntradaEstimativaMalha entrada) {
		this.entrada = entrada;
		this.destino = entrada.getDestino();

		ola(entrada.getOrigem(), null, new ArrayList<>());
		for(MalhaEstimada estimativa : estimativas){
			System.out.println(estimativa.getMalhas());
		}

	}

	private List<Rota> ola(String origem, Malha pai, List<Rota> rotas) {
		List<Malha> malhas = grupo.getOrDefault(origem, new ArrayList<>());
		for (Malha malha : malhas) {
			if (rotas == null) {
				rotas = new ArrayList<>();
			}
			rotas.add(new Rota(pai, malha));
			System.out.print(" " + malha + " pai " + pai + ", ");
			if (!malha.getDestino().equals(this.destino)) {
				rotas = ola(malha.getDestino(), malha, rotas);
			} else {
				MalhaEstimada estimativa = new MalhaEstimada(this.entrada);
				estimativa.setRotas(rotas);
				estimativas.add(estimativa);
				System.out.print(" rotas:" + rotas.size());
				System.out.print(" fim ");
				return new ArrayList<>();
			}

		}

		System.out.println();
		return null;
	}
}
