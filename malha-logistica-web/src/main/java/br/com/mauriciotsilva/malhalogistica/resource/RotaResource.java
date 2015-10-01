package br.com.mauriciotsilva.malhalogistica.resource;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;
import br.com.mauriciotsilva.malhalogistica.rota.MalhaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

@Path("estimativas")
public class RotaResource {

	@Inject
	private RotaService servico;

	@GET
	@Produces("application/json")
	public List<MalhaEstimada> estimar(@QueryParam("mapa") String mapa, @QueryParam("origem") String origem,
			@QueryParam("destino") String destino, @QueryParam("combustivel") BigDecimal valor,
			@QueryParam("autonomia") @DefaultValue("1") Integer autonomia) {

		EntradaEstimativaMalha entrada = new EntradaEstimativaMalha();

		entrada.setNomeMapa(mapa);
		entrada.setOrigem(origem);
		entrada.setDestino(destino);
		entrada.setAutonomia(autonomia);
		entrada.setValorCombustivel(valor);

		return servico.listarEstimativas(entrada);
	}

}
