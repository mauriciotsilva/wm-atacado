TabelaEstimativas = Backbone.View.extend({
	el : '#tabela-estimativas',
	template : _.template($('#template-estimativa').html()),
	initialize : function(options) {
		this.collection = options.collection;
		this.corpoTabela = this.$el.find('tbody');
	},
	render : function() {

		var that = this;
		this.corpoTabela.empty();
		this.collection.each(function(estimativa) {
			var tr = $('<tr/>');
			tr.append(that.template({
				conteudo : estimativa.toJSON()
			}));

			that.corpoTabela.append(tr);
		});

		return this;

	}
});

Teste = Backbone.Collection.extend({
	url : function() {
		return 'api/estimativas';
	},
	model : Backbone.Model.extend({
		parse : function(response) {

			var caminho = [];
			if (response.malhas) {

				_.each(response.malhas, function(malha, index) {
					var valor = malha.origem;
					if(index == (response.malhas.length-1)){
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
});

FormularioConsultaMalha = Backbone.View.extend({
	el : '.form-horizontal',
	initialize : function() {

		this.form = {
			mapa : this.$el.find('#textMapa'),
			origem : this.$el.find('#textOrigem'),
			destino : this.$el.find('#textDestino'),
			autonomia : this.$el.find('#textAutonomia'),
			combustivel : this.$el.find('#textCombustivel')
		};
	},
	events : {
		'click .btn-consulta-estivativa' : function(event) {
			event.preventDefault();

			var estimativas = new Teste();
			estimativas.fetch({
				data : this.criarConsulta(),
				success : function(estimativas) {
					$('.olaMUndo').modal();
					new TabelaEstimativas({
						collection : estimativas
					}).render();
				},
				error : function() {
					alert('Nao foi possivel Localizar Rotas');
				}
			});

		}
	},

	criarConsulta : function() {
		var consulta = {};
		for ( var campo in this.form) {
			consulta[campo] = this.form[campo].val();
		}
		return consulta;
	}
});