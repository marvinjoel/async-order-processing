## Descripción del Proyecto

Este proyecto implementa un sistema de comunicación basado en RabbitMQ para la gestión de pedidos.

El sistema consta de dos componentes principales:

* **Productor (Order API Producer):** Genera y envía mensajes de pedidos a una cola de RabbitMQ. Se ejecuta en el puerto 9000.
* **Consumidor (Order API Consumer):** Recibe y procesa estos mensajes. Se ejecuta en el puerto 9001.

La comunicación asíncrona mediante RabbitMQ permite desacoplar estos componentes, mejorando la escalabilidad y la capacidad de respuesta del sistema.

## Ejecución del Proyecto

Para ejecutar el proyecto, se proporcionan un script `make.sh` y un archivo de configuración `.env`. Siga estos pasos:

1.  **Crear el archivo de configuración:**
    * Cree una copia del archivo `.env.example` y renómbrela a `.env`.
    * Edite el archivo `.env` y proporcione los valores adecuados para las siguientes variables:
        * `SPRING_DATASOURCE_URL`: La URL de la base de datos PostgreSQL. Reemplace `DB` con el nombre de su base de datos. Por ejemplo, `jdbc:postgresql://host.docker.internal:5432/nombre_de_la_base_de_datos`
        * `SPRING_DATASOURCE_USERNAME`: El nombre de usuario de la base de datos.
        * `SPRING_DATASOURCE_PASSWORD`: La contraseña de la base de datos.
        
2.  **Crear la base de datos:**
    * Asegúrese de que PostgreSQL esté en ejecución y cree una base de datos con el nombre que especificó en la variable `SPRING_DATASOURCE_URL` en el archivo `.env`.
3.  **Ejecutar el script de compilación e inicio:**
    * Ejecute el script `make.sh` para compilar el proyecto Java, construir las imágenes de Docker e iniciar los contenedores:
        ```bash
        ./make.sh
        ```
    El script `make.sh` automatiza los siguientes pasos:

    1.  **Compilar el proyecto Java:** Ejecuta el comando `mvn clean package -DskipTests` para compilar el código fuente y generar los archivos JAR.
    2.  **Construir la imagen Docker:** Ejecuta el comando `docker-compose build` para construir las imágenes de Docker para el productor y el consumidor.
    3.  **Iniciar los contenedores:** Ejecuta el comando `docker-compose up -d` para iniciar los contenedores de Docker en modo detached.

    **Importante:** El script `make.sh` debe ejecutarse en el orden especificado para asegurar que el proyecto se inicie correctamente. Primero, se debe compilar el proyecto Java, luego construir las imágenes de Docker y, finalmente, iniciar los contenedores.


![Image](https://github.com/user-attachments/assets/17e5b98c-15ab-4933-a1ca-30012e838e8c)