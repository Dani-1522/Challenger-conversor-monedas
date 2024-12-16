
# Conversor de Monedas en Java

Este proyecto implementa un conversor de monedas en Java, que obtiene tasas de cambio de una API externa y permite realizar conversiones entre diversas monedas seleccionadas por el usuario.

---

## Características
- Realiza solicitudes HTTP a una API de tasas de cambio.
- Analiza respuestas JSON utilizando la biblioteca Gson.
- Permite convertir entre monedas específicas.
- Incluye un menú interactivo en la consola para el usuario.

---

## Requisitos Previos

1. **Java JDK 11 o superior:**
   - [Descargar Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

2. **Biblioteca Gson (v2.10.1 o superior):**
   - Disponible en el [Maven Central Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson)

3. **Postman:** (opcional, para pruebas de API)
   - [Descargar Postman](https://www.postman.com/downloads/)

4. **IDE IntelliJ IDEA** (opcional):
   - [Descargar IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

---

## Configuración del Entorno

### Paso 1: Instalar Dependencias
1. **Agregar Gson al proyecto:**
   Si usas Maven, incluye la dependencia Gson en tu archivo `pom.xml`:
   ```xml
   <dependency>
       <groupId>com.google.code.gson</groupId>
       <artifactId>gson</artifactId>
       <version>2.10.1</version>
   </dependency>
   ```
   Si usas IntelliJ sin Maven, sigue estos pasos:
   - Haz clic en `File > Project Structure > Modules > Dependencies`.
   - Añade la biblioteca `gson.jar` descargada manualmente.

2. **Configura el IDE (opcional):**
   Abre tu proyecto en IntelliJ IDEA y verifica que las dependencias estén correctamente configuradas.

---

## Uso del Conversor

1. **Obtener la API Key:**
   - Regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) u otro proveedor de tasas de cambio.
   - Obtén tu clave API personal y actualiza el código fuente:
     ```java
     private static final String API_KEY = "TU_API_KEY";
     ```

2. **Ejecutar el programa:**
   - Compila y ejecuta el archivo `CurrencyConverter.java`.

3. **Interactuar con el menú:**
   - Selecciona la moneda base.
   - Introduce la cantidad a convertir.
   - Selecciona la moneda destino para obtener el valor convertido.

---

## Estructura del Proyecto
```
|-- src/
    |-- Main.java
    |-- CurrencyConverter.java
|-- README.md
|-- pom.xml
```

### Archivos Clave
- **Main.java:** Contiene el método principal y lanza el menú interactivo.
- **CurrencyConverter.java:** Implementa las solicitudes HTTP, análisis JSON y lógica de conversión.

---

## Errores Comunes

1. **`rates` es null:**
   - Verifica que tu clave API sea válida.
   - Asegúrate de que la API esté funcionando y respondiendo con datos correctos.
   - Usa Postman para confirmar el formato de la respuesta de la API.

2. **Error de conexión:**
   - Revisa tu conexión a Internet.
   - Asegúrate de que la URL de la API sea correcta.

---

## Mejoras Futuras
- Implementar una interfaz gráfica (GUI) para mayor facilidad de uso.
- Soporte para más monedas y APIs adicionales.
- Manejo avanzado de errores y validación de entrada del usuario.

---

## Créditos
- Desarrollado por Daniel Martinez
- Inspirado en el uso de Java y Gson para consumo de APIs.

---

## Licencia
Este proyecto es de código abierto y puede ser utilizado libremente con fines educativos.

