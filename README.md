Descripción del Proyecto

Este programa es una aplicación de consola desarrollada en Java diseñada para la ejecución de operaciones lógicas y la gestión de datos. El sistema incluye un módulo de persistencia que permite almacenar los resultados obtenidos durante la ejecución en un archivo de texto externo, facilitando el seguimiento y la auditoria de los procesos realizados.

Tecnologías y Herramientas
Lenguaje: Java (JDK 8 o superior).

Manejo de Archivos: Implementación de las clases del paquete java.io (FileWriter, PrintWriter y File).

Control de Flujo: Estructura de menú mediante switch-case y bucles de control.

Seguridad de Ejecución: Gestión de errores mediante bloques try-catch para el manejo de excepciones de entrada/salida (IOException).

Funcionalidades Destacadas
Gestión Automática de Directorios: El código verifica la existencia de la carpeta de destino al momento de guardar. En caso de no ser encontrada, el sistema utiliza el método mkdirs() para crear la estructura de carpetas necesaria sin intervención del usuario.

Escritura Incremental (Append Mode): La configuración del flujo de salida permite añadir nuevos datos al final del archivo sin sobrescribir la información existente, preservando el historial de operaciones.

Formateo de Datos: Los registros se almacenan con separadores visuales y marcas de tiempo para una lectura clara fuera del entorno de desarrollo.

Arquitectura de Carpetas
Al ejecutar la función de guardado, el programa organiza los archivos de la siguiente manera:

Raíz del Proyecto: Contiene el código fuente y los archivos de configuración.

Directorio /Archivos: Carpeta generada automáticamente donde se centralizan los archivos de salida.

resultados.txt: Archivo plano donde se registra el contenido generado por el usuario.
