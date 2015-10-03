Estimativa = Backbone.Model.extend({
	parse : function(response) {

		var caminho = [];
		if (response.malhas) {
			_.each(response.malhas, function(malha, index) {
				var valor = malha.origem;
				if (index == (response.malhas.length - 1)) {
					caminho.push(valor);
					valor = malha.destino;
				}
				caminho.push(valor);
			});
		}
		response.caminho = caminho;
		return response;
	}
})