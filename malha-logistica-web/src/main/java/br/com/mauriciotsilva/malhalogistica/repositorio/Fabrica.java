package br.com.mauriciotsilva.malhalogistica.repositorio;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class Fabrica {

	@Produces
	public Datastore criarDatastore(MongoClient client) {

		Morphia morphia = new Morphia();
		return morphia.createDatastore(client, "logistica");
	}

	@Produces
	@ApplicationScoped
	public MongoClient criarMongoClient() {
		return new MongoClient();
	}

	public void fecharMongoClient(@Disposes MongoClient client) {
		client.close();
	}

}
