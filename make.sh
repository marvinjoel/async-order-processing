#!/bin/bash

PROJECT_NAME="async-order-processing" # Reemplaza con el nombre de tu proyecto

function compile_java {
    echo "⏳ Compilando proyecto Java..."
    mvn clean package -DskipTests
    if [ $? -ne 0 ]; then
        echo "❌ Error al compilar el proyecto Java."
        exit 1
    fi
    echo "✅ Proyecto Java compilado exitosamente."
}

function build_image {
    echo "🏗️ Construyendo la imagen Docker..."
    docker-compose build
    if [ $? -ne 0 ]; then
        echo "❌ Error al construir la imagen Docker."
        exit 1
    fi
    echo "✅ Imagen Docker construida exitosamente."
}

function start_containers {
    echo "🚀 Levantando servicios con Docker Compose..."
    docker-compose up -d
    if [ $? -ne 0 ]; then
        echo "❌ Error al levantar los contenedores."
        exit 1
    fi
    echo "✅ Contenedores levantados exitosamente."
}

function stop_containers {
    echo "🛑 Deteniendo los contenedores con Docker Compose..."
    docker-compose down
    if [ $? -ne 0 ]; then
        echo "❌ Error al detener los contenedores."
        exit 1
    fi
    echo "✅ Contenedores detenidos exitosamente."
}

function show_logs {
    CONTAINER_NAME=""
    read -p "Ingrese el nombre del contenedor para ver los logs (-f para seguir): " CONTAINER_NAME
    if [ -n "$CONTAINER_NAME" ]; then
        docker-compose logs -f $CONTAINER_NAME
    else
        echo "⚠️ No se especificó un nombre de contenedor."
    fi
}

function rebuild_and_start {
    echo "🔄 Reconstruyendo la imagen y levantando los contenedores..."
    docker-compose up --build -d
    if [ $? -ne 0 ]; then
        echo "❌ Error al reconstruir y levantar los contenedores."
        exit 1
    fi
    echo "✅ Imagen reconstruida y contenedores levantados exitosamente."
}

function enter_container {
    CONTAINER_NAME=""
    read -p "Ingrese el nombre del contenedor al que desea ingresar: " CONTAINER_NAME
    if [ -n "$CONTAINER_NAME" ]; then
        docker exec -it $CONTAINER_NAME /bin/bash
    else
        echo "⚠️ No se especificó un nombre de contenedor."
    fi
}

while true; do
    echo ""
    echo "🛠️ Elija una opción para el proyecto $PROJECT_NAME:"
    echo "1. ⚙️ Compilar el proyecto Java"
    echo "2. 📦 Construir la imagen Docker"
    echo "3. 🚀 Iniciar los contenedores"
    echo "4. 🛑 Detener los contenedores"
    echo "5. 📝 Mostrar logs de un contenedor"
    echo "6. 🔄 Reconstruir la imagen y reiniciar los contenedores"
    echo "7. 🚪 Entrar a un contenedor (bash)"
    echo "0. 🚪 Salir"
    echo ""

    read -n 1 -p "Ingrese el número de opción: " OPTION
    echo ""

    case $OPTION in
        1) compile_java;;
        2) build_image;;
        3) start_containers;;
        4) stop_containers;;
        5) show_logs;;
        6) rebuild_and_start;;
        7) enter_container;;
        0) break;;
        *) echo "⚠️ Opción inválida. Por favor, intente de nuevo.";;
    esac
done

echo "👋 ¡Hasta luego!"