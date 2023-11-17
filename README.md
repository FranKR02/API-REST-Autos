# Proyecto API REST con Spring Boot

API REST construida con Spring Boot 3.1.5 que utiliza JPA para la persistencia de datos en una base de datos MySQL. La entidad principal es "Auto", y se ha simplificado el código mediante el uso de Lombok. La documentación y exposición de las operaciones CRUD se han implementado con Swagger.

## Tecnologías Utilizadas

- **Spring Boot 3.1.5**
- **Java 17**
- **JPA**
- **MySQL**
- **Lombok**
- **Swagger**
  
## Características Principales
- **Operaciones CRUD para la entidad "Auto"**
- **Uso de Lombok para simplificar el código**
- **Documentación generada automáticamente con Swagger**

## Ejemplos de Uso de las Operaciones CRUD

- **Crear un nuevo auto**
  ```xml
  POST /api/autos/save
  {
    "marca": "Toyota",
    "color": "Rojo"
  }
  ```
- **Crear un nuevos autos**
  ```xml
  POST /api/autos/saveall
  [
    {
      "marca": "Toyota",
      "color": "Rojo"
    },
    {
      "marca": "Honda",
      "color": "Azul"
    },
    {
      "marca": "Ford",
      "color": "Negro"
    }
  ]
  ```
- **Editar un auto existente**
  ```
  PUT /api/autos/edit
  {
    "id": 1,
    "marca": "Honda",
    "color": "Azul"
  }
  ```
- **Obtener todos los autos**
  ```
  GET /api/autos/
  ```
- **Obtener un auto por ID**
  ```
  GET /api/autos/auto/1
  ```
- **Obtener autos por marca**
  ```
  GET /api/autos/marca/Toyota
  ```
- **Obtener autos por color**
  ```
  GET /api/autos/color/Rojo
  ```
- **Eliminar un auto por ID**
  ```
  DELETE /api/autos/delete/1
  ```

## Documentación Swagger

Accede a la interfaz Swagger en http://localhost:8080/swagger-ui/index.html#/. Esta interfaz te proporciona documentación interactiva sobre la API, permitiéndote probar las solicitudes directamente desde el navegador.

## Dependencias
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.2.0</version>
    </dependency>
```

</dependencies>

