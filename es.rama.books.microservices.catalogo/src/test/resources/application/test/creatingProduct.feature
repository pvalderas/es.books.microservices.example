Feature: Crear un producto
Como usuario del microservicio Catalogo se debe ser capaz de crear un producto
Scenario: Crear un productos datos un id, un nombre, una descripcion y un precio 
    Given Uso id <id>, nombre <name>, descripcion <description> y precio <price>
    When Solicito la creaci�n de un producto 
	Then Debo obtener el c�digo de estado HTTP 201
