package br.com.mauriciotsilva.malhalogistica.resource;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaRota;
import br.com.mauriciotsilva.malhalogistica.rota.RotaEstimada;
import br.com.mauriciotsilva.malhalogistica.service.RotaService;

@Path("estimativas")
public class RotaResource {

	@Inject
	private RotaService servico;

	@GET
	@Path("{mapa}")
	@Produces("application/json")
	public List<RotaEstimada> listar(@PathParam("mapa") String mapa, @QueryParam("origem") String origem,
			@QueryParam("destino") String destino, @QueryParam("combustivel") BigDecimal valor,
			@QueryParam("autonomia") @DefaultValue("1") Integer autonomia) {

		EntradaEstimativaRota entrada = new EntradaEstimativaRota();

		entrada.setNomeMapa(mapa);
		entrada.setOrigem(origem);
		entrada.setDestino(destino);
		entrada.setAutonomia(autonomia);
		entrada.setValorCombustivel(valor);

		return servico.listarEstimativas(entrada);
	}

}
