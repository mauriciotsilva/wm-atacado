package br.com.mauriciotsilva.malhalogistica.repositorio;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;

@Alternative
public class MalhaJsonRepository implements MalhaRepository {

	private static List<Malha> malhas = new ArrayList<>();

	@Override
	public List<Malha> listar(EntradaEstimativaMalha entrada) {

		if (malhas.isEmpty()) {
			JsonArray array = getJsonArray();
			malhas = array.stream().map(this::criarMalha).collect(toList());
		}

		return malhas;

	}

	private JsonArray getJsonArray() {

		JsonArray array = null;

		try (InputStream input = getClass().getResourceAsStream("/malhas.json")) {
			JsonReader reader = Json.createReader(input);
			array = reader.readArray();
		} catch (IOException e) {
		}

		return array;
	}

	private Malha criarMalha(JsonValue jsonValue) {

		JsonObject json = (JsonObject) jsonValue;
		return new Malha(json.getString("mapa"), json.getString("origem"), json.getString("destino"),
				json.getInt("distancia"));
	}

}
