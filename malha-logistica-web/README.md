Desenvolver um sistema de entregas visando sempre o menor custo. Para popular sua base de dados o sistema precisa expor um Webservices que aceite o formato de malha log�stica (exemplo abaixo) e nesta mesma requisi��o o requisitante dever� informar um nome para este mapa. � importante que os mapas sejam persistidos para evitar que a cada novo deploy todas as informa��es desapare�am. O formato de malha log�stica � bastante simples, cada linha mostra uma rota: ponto de origem, ponto de destino e dist�ncia entre os pontos em quil�metros.
A B 10
B D 15
A C 20
C D 30
B E 50
D E 30
Um exemplo de entrada seria, origem A, destino D, autonomia 10, valor do litro 2,50; a resposta seria a rota A B D com custo de 6,25.


Formulario de Consulta
	
	http://localhost:8080/malha-logistica-web/index.html

Webservice


	http://localhost:8080/malha-logistica-web/api/estimativas?mapa={nomeMapa}&origem={origem}&destino={destino}&autonomia={autonomia}&combustivel={combustivel}

Frontend
	
		HTML 5
		JavaScript
		JQuery
		Undescorejs
		Backbonejs
		Bootstrap
	
Backend

		Java 8
		Java EE 7
		JAX-RS
		CDI
	
Persistencia
		
		MongoDB
	
Teste
	
		JUnit
