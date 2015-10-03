package br.com.mauriciotsilva.malhalogistica.repositorio;

import java.util.List;

import br.com.mauriciotsilva.malhalogistica.dominio.rota.Malha;
import br.com.mauriciotsilva.malhalogistica.rota.EntradaEstimativaMalha;

public interface MalhaRepository {

	public List<Malha> listar(EntradaEstimativaMalha entrada);

}
