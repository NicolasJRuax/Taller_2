# Tareas en Segundo Plano - Android App

## Descripción

Esta es una aplicación de Android que muestra cómo manejar tareas en segundo plano utilizando `AsyncTask`, y cómo guardar preferencias del usuario, como su nombre y el color de fondo, utilizando `SharedPreferences`. La aplicación está dividida en tres actividades principales:

1. **Pantalla de Saludo (InicioActivity)**: Muestra un saludo personalizado según la hora del día y el nombre del usuario.
2. **Pantalla Principal (MainActivity)**: Permite al usuario ingresar su nombre y simular una tarea en segundo plano.
3. **Pantalla de Configuración (ConfiguracionActivity)**: Permite al usuario seleccionar el color de fondo de la aplicación.

## Características

- Guardado de nombre de usuario y color de fondo usando `SharedPreferences`.
- Saludo personalizado basado en el nombre guardado y la hora del día.
- Simulación de una tarea en segundo plano usando `AsyncTask`.
- Cambio de color de fondo a través de la pantalla de configuración.

## Requisitos

- Android Studio 4.1 o superior.
- Min SDK: 26
- Target SDK: 33

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/usuario/tareas-en-segundo-plano.git
    ```
2. Abre el proyecto en Android Studio.
3. Sincroniza las dependencias de Gradle.
4. Ejecuta la aplicación en un dispositivo o emulador.

## Estructura del Proyecto

El proyecto está dividido en las siguientes clases:

- `MainActivity`: Pantalla principal donde el usuario ingresa su nombre y simula una tarea en segundo plano.
- `ConfiguracionActivity`: Pantalla de configuración para cambiar el color de fondo.
- `InicioActivity`: Pantalla de inicio que muestra un saludo personalizado basado en el nombre guardado y la hora del día.

## Cómo usar

1. **Pantalla de Inicio**: Al abrir la aplicación, verás un saludo personalizado que cambia según la hora del día. Presiona el botón para ir a la pantalla principal.
2. **Pantalla Principal**: Ingresa tu nombre, guárdalo, y comienza una tarea en segundo plano. Puedes ir a la configuración desde aquí.
3. **Pantalla de Configuración**: Cambia el color de fondo de la aplicación. El color se aplicará en todas las pantallas.

## Pruebas

Este proyecto incluye pruebas unitarias para verificar el correcto funcionamiento del guardado de nombre y color de fondo utilizando `SharedPreferences`.

Para ejecutar las pruebas, sigue estos pasos:

1. Abre Android Studio.
2. Dirígete a la clase `TestMainActivity.java`.
3. Haz clic derecho y selecciona "Run 'Tests in TestMainActivity'".

## Diagramas

### Diagrama de Clases

![Diagrama de Clases](class_diagram.png)

### Diagrama de Casos de Uso

![Diagrama de Casos de Uso](use_case_diagram.png)

## Licencia

Este proyecto está licenciado bajo la MIT License.
