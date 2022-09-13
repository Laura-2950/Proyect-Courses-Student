# Práctica Circuit Breaker para manejar fallas en las solicitudes o largos períodos de espera en la recepción de las solicitudes que hacemos a nuestra API.

## Consigna
Para poder desarrollar toda la configuración de Circuit Breaker será necesario crear una API
REST que tendrá como objetivo mapear a los estudiantes de una escuela con su
correspondiente curso. Ya contamos con el microservicio de estudiantes el cual expone una
API que nos permite buscar los estudiantes. A su vez, esta API nos retorna un error en caso
de que necesitemos probar el Circuit Breaker.
### student-service
API DOC:
[GET]
Endpoint: http://localhost:8086/students/findAll
Params:
throwError (true o false)
#### Ejemplos:
[GET]
http://localhost:8086/students/findAll?throwError=false

Response:
[
{
"id": 1,
"name": "Javier",
"lastName": "Rabuch",
"identificationNumber": 155476678
},
{
"id": 2,
"name": "Aiti",
"lastName": "Torres",
"identificationNumber": 234565434
},{
"id": 3,
"name": "Tomas",
"lastName": "Pereyra",
"identificationNumber": 12345678
}
2
]

[GET]
http://localhost:8086/students/findAll?throwError=true

Response:
{
"timestamp": "2022-03-11T03:39:19.991+00:00",
"status": 500,
"error": "Internal Server Error",
"path": "/students/findAll"
}
### course-service
● Crear una API que contenga un endpoint que nos permita buscar cursos por
ID.

● Los cursos tienen la siguiente estructura:

○ Id (integer)

○ Title (string)

○ Students

■ Id

■ name

■ lastName

■ identificationNumber

● Crear una clase de servicio que nos permita buscar en un repositorio el curso y
también busque el listado de estudiantes utilizando Feign.

● Configurar el Circuit Breaker en la comunicación entre microservicios. Crear un
método alternativo que nos retorne un listado vacío de estudiantes en caso de
que el estado del Circuit Breaker sea open.