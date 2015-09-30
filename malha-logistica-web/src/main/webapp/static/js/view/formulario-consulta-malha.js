Teste = Backbone.Collection.extend({
	initialize: function(options){
		this.mapa = options.mapa;
	},
	url : function(){
		return 'api/estimativas/'+ this.mapa;
	}
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

			var consulta = this.criarConsulta();
			var mapa = consulta.mapa;
			delete consulta.mapa;
			
			new Teste({mapa: mapa}).fetch({
				data: consulta
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