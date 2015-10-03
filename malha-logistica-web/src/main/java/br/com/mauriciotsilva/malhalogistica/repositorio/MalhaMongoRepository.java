package br.com.mauriciotsilva.malhalogistica.repositorio;

import java.util.List;

import javax.inject.Inject;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;

public class MalhaMongoRepository implements MalhaRepository {

	private Datastore datastore;

	@Inject
	public MalhaMongoRepository(Datastore datastore) {
		this.datastore = datastore;

	}

	public List<Malha> listar(EntradaEstimativaMalha entrada) {

		Query<Malha> query = datastore.createQuery(Malha.class);

		query.field("mapa").equal(entrada.getNomeMapa());
		query.or(query.criteria("origem").equal(entrada.getOrigem()),
				query.criteria("destino").equal(entrada.getDestino()));

		return query.asList();
	}

}
