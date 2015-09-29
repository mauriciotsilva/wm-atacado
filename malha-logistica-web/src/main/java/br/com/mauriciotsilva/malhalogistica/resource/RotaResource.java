package br.com.mauriciotsilva.malhalogistica.resource;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

public class RotaResource {

	private RotaService servico;

	public void estimar() {
		servico.estimar(new EntradaEstimativaRota());
	}

}
