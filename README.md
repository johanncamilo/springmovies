# Sistema Integrado de Gestión Movies
## Prueba Técnica Programador

## Importante
- El proyecto está desarrollado en Java JDK 21 y Spring Boot.
- Se utiliza Maven como gestor de dependencias.
- La base de datos es postgreSQL.
- El servidor corre en el puerto 8080 por defecto.
- La base de datos corre en el puerto 5432 por defecto.

## Advertencia: Se debe reiniciar la secuencia de la tabla movies en la base de datos para que los IDs se generen correctamente:
```sql
SELECT setval('movie_id_seq', (SELECT MAX(id) FROM movie));
```

## Se debe tener instalado:
- Java JDK 21 o superior
- Maven
- PostgreSQL
- Postman o cualquier cliente REST

## Instrucciones para correr el proyecto
1. Clonar el repositorio / descomprimir el archivo zip.
2. Configurar la conexión a la base de datos en el archivo `src/main/resources/application.properties`:
```spring.datasource.url=jdbc:postgresql://localhost:5432/moviesdb
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```
3. Abrir una terminal y navegar hasta la carpeta del proyecto.
4. Ejecutar el siguiente comando para compilar y correr la aplicación:
```bash
mvn spring-boot:run
```
5. O con un editor moderno como vsCode o Intellij abrir la carpeta del proyecto y correr la aplicación desde ahí. (opcional)
6. La aplicación debería estar corriendo en `http://localhost:8080`.

## Estructura del proyecto

```shell
movies/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── software_colombia/
│   │   │           └── movies/
│   │   │               ├── model/
│   │   │               │   └── Movie.java
│   │   │               ├── repository/
│   │   │               │   └── MovieRepository.java
│   │   │               ├── service/
│   │   │               │   ├── MovieService.java
│   │   │               │   └── impl/
│   │   │               │       └── MovieServiceImpl.java
│   │   │               └── MoviesApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── software_colombia/
│                   └── movies/
│                       ├── service/
│                       │   ├── MovieServiceTest.java
│                       │   └── impl/
│                       │       └── MovieServiceImplTest.java
│                       └── MoviesApplicationTests.java
├── pom.xml
└── ... (otros archivos)
```

## Endpoints disponibles
- `GET /api/movies/{id}`: Obtener una película por ID.
- `GET /api/movies`: Listar películas con opciones de orden y cantidad.
- `POST /api/movies`: Agregar una nueva película.


## Ejemplos de uso con Postman o curl

1. Obtener una película por ID:
```http
GET http://localhost:8080/api/movies/7
```

*Respuesta*
```shell
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 25 Aug 2025 13:36:07 GMT
Connection: close

{
  "id": 7,
  "film": "WALL-E",
  "genre": "Animation",
  "studio": "Disney",
  "score": 89,
  "year": 2008
}
```

2. Lista las películas ordenadas alfabéticamente usando las variables de consulta `order` y `total`.

```http
GET http://localhost:8080/api/movies?total=15&order=desc
```

*Respuesta*
```shell
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 25 Aug 2025 13:37:03 GMT
Connection: close

[
  {
    "id": 1,
    "film": "Zack and Miri Make a Porno",
    "genre": "Romance",
    "studio": "The Weinstein Company",
    "score": 70,
    "year": 2008
  },
  {
    "id": 2,
    "film": "Youth in Revolt",
    "genre": "Comedy",
    "studio": "The Weinstein Company",
    "score": 52,
    "year": 2010
  },
  {
    "id": 3,
    "film": "You Will Meet a Tall Dark Stranger",
    "genre": "Comedy",
    "studio": "Independent",
    "score": 35,
    "year": 2010
  },
  {
    "id": 4,
    "film": "When in Rome",
    "genre": "Comedy",
    "studio": "Disney",
    "score": 44,
    "year": 2010
  },
  {
    "id": 5,
    "film": "What Happens in Vegas",
    "genre": "Comedy",
    "studio": "Fox",
    "score": 72,
    "year": 2008
  },
  {
    "id": 6,
    "film": "Water For Elephants",
    "genre": "Drama",
    "studio": "20th Century Fox",
    "score": 72,
    "year": 2011
  },
  {
    "id": 8,
    "film": "Waitress",
    "genre": "Romance",
    "studio": "Independent",
    "score": 67,
    "year": 2007
  },
  {
    "id": 9,
    "film": "Waiting For Forever",
    "genre": "Romance",
    "studio": "Independent",
    "score": 53,
    "year": 2011
  },
  {
    "id": 7,
    "film": "WALL-E",
    "genre": "Animation",
    "studio": "Disney",
    "score": 89,
    "year": 2008
  },
  {
    "id": 10,
    "film": "Valentine's Day",
    "genre": "Comedy",
    "studio": "Warner Bros.",
    "score": 54,
    "year": 2010
  },
  {
    "id": 11,
    "film": "Tyler Perry's Why Did I get Married",
    "genre": "Romance",
    "studio": "Independent",
    "score": 47,
    "year": 2007
  },
  {
    "id": 12,
    "film": "Twilight: Breaking Dawn",
    "genre": "Romance",
    "studio": "Independent",
    "score": 68,
    "year": 2011
  },
  {
    "id": 13,
    "film": "Twilight",
    "genre": "Romance",
    "studio": "Summit",
    "score": 82,
    "year": 2008
  },
  {
    "id": 14,
    "film": "The Ugly Truth",
    "genre": "Comedy",
    "studio": "Independent",
    "score": 68,
    "year": 2009
  },
  {
    "id": 15,
    "film": "The Twilight Saga: New Moon",
    "genre": "Drama",
    "studio": "Summit",
    "score": 78,
    "year": 2009
  }
]
```


3. Agregar una película:
*Petición*
```http
POST http://localhost:8080/api/movies
Content-Type: application/json

{
  "film": "Alien the 8th Passenger",
  "genre": "Science Fiction",
  "studio": "20th Century Fox",
  "score": 8.5,
  "year": 1979
}
```

*Respuesta*
```shell
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sun, 24 Aug 2025 14:51:00 GMT
Connection: close

{
  "id": 78,
  "film": "Alien the 8th Passenger",
  "genre": "Science Fiction",
  "studio": "20th Century Fox",
  "score": 8,
  "year": 1979
}
```