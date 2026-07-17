###### Sistema de Gestión Escolar - CRUD con Spring Boot

**Edwin Alexis Esperanza Chavez**

Proyecto de gestión académica desarrollado con Spring Boot 4, Spring Data JPA y MySQL. Este sistema permite gestionar alumnos y sus escuelas de procedencia con una relación definida (ManyToOne).

## Características principales
- **Arquitectura MVC + REST**: Incluye vistas web con Thymeleaf y una API REST para integraciones externas.
- **Relaciones JPA**: Mapeo relacional entre `Alumno` y `Escuela`.
- **Persistencia**: Uso de Hibernate con actualización automática de esquemas.
- **Frontend**: Interfaz intuitiva diseñada con Bootstrap 5.

## Tecnologías
- **Java 21**
- **Spring Boot 4**
- **Spring Data JPA**
- **MySQL 8.0**
- **Thymeleaf + Bootstrap 5**


## Sistema

### 1. Entidades Relacionadas
La relación entre `Alumno` y `Escuela` está configurada mediante `@ManyToOne`.
![Relación de Entidades](https://i.postimg.cc/L5zXTkz4/Captura-de-pantalla-2026-07-17-122822.png)

### 2. CRUD: Operaciones en Acción
*   **Crear:** Formulario para registrar nuevos alumnos con selector de escuelas dinámico.
    ![Formulario](https://i.postimg.cc/4dcNfv2c/Captura-de-pantalla-2026-07-17-122935.png)
*   **Leer (Listado de Escuelas):** Se despliega el nombre de la escuela, no solo su ID.
    ![Listado](https://i.postimg.cc/d3ts2MtZ/Captura-de-pantalla-2026-07-17-124656.png)
*   **Actualizar:** Edición completa de datos.
    ![Editar](https://i.postimg.cc/bvxp4YZ5/Captura-de-pantalla-2026-07-17-124816.png)
*   **Eliminar:** Confirmación para borrar registros.
    ![Eliminar](https://i.postimg.cc/v8qMJNmT/Captura-de-pantalla-2026-07-17-124901.png)

### 3. API REST EN POSTMAN
El sistema expone endpoints en `/api/alumnos` para consumir los datos como JSON.
![API JSON](https://i.postimg.cc/PxJVY2nz/Captura-de-pantalla-2026-07-17-125351.png)
![POST](https://i.postimg.cc/xdz32hQH/Captura-de-pantalla-2026-07-17-130132.png)
![Resultado POST](https://i.postimg.cc/6psQPmH5/Captura-de-pantalla-2026-07-17-130548.png)

## Configuración y Ejecución

1. **Base de Datos:** Asegúrese de tener una base de datos creada en MySQL llamada `escuela_db`.
2. **Propiedades:** Configure `src/main/resources/application.properties`:
   
```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/escuela_db
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   spring.jpa.hibernate.ddl-auto=update