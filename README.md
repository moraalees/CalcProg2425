# Calculadora Básica POO

---

## Descripción

Este programa basa su funcionamiento según los parámetros de entrada que el usuario efectúe. Dicho programa (en un futuro) podrá o bien no recibir argumentos, recibir uno solo o cuatro argumentos de una sola vez. Dependiendo de dicha cantidad, el programa creará las rutas de `./log` y creará archivos `.txt` en los que aparecerán los datos de operaciones o errores encontrados.

---

## Partes

- [`Sin Argumentos`](https://github.com/moraalees/CalcProg2425/blob/4e5ad12b071caafb7c25ddf4f5bf8e111c3b9ee2/src/main/kotlin/Main.kt#L17C4-L22C10): Cuando el programa se ejecuta sin argumentos, se activa el modo interactivo de la clase `Consola`. Este:
    - Se ejecuta la calculadora por consola (Calculadora), que permite al usuario introducir manualmente los dos números y el operador.
    - El usuario puede realizar múltiples operaciones sucesivas hasta decidir salir.
    - No se genera ningún archivo de log en este modo, solo es simulado
- [`Un argumento`](https://github.com/moraalees/CalcProg2425/blob/4e5ad12b071caafb7c25ddf4f5bf8e111c3b9ee2/src/main/kotlin/Main.kt#L24C9-L29C10): El programa verifica si la ruta existe, ya dependiendo del resultado:
    - Si no existe, la crea y muestra el mensaje: `Ruta [$ruta] creada`.
    - Si la carpeta contiene archivos `.txt`, se abre el archivo más reciente y se muestra su contenido línea a línea.
    - Si no existen archivos `.txt`, se informa al usuario: `"No existen ficheros de Log"`.
- [`Cuatro argumentos`](https://github.com/moraalees/CalcProg2425/blob/4e5ad12b071caafb7c25ddf4f5bf8e111c3b9ee2/src/main/kotlin/Main.kt#L31C9-L51C10): Se interpreta como una solicitud directa de realizar un cálculo en el orden de los parámetros pasados:
    1. Ruta de log (donde guardar el resultado).
    2. Primer número.
    3. Operador (+, -, *, /, x, :).
    4. Segundo número.
  - ### El programa:
  - Valida todos los argumentos.
  - Ejecuta el cálculo si los datos son correctos.
  - Muestra el resultado.
  - Crea un archivo de log con formato `logYYYYMMDDHHMMSS.txt` dentro de la ruta especificada.
  - Escribe en el archivo la operación y su resultado.
