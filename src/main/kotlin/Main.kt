package es.prog2425.calc2425

import es.prog2425.calc2425.ui.Consola
import es.prog2425.calc2425.data.CreadorLog
import es.prog2425.calc2425.ui.IEntradaSalida

/*
model: Logica del negocio (Seguros, Usuarios, etc)
data: Repositorios del model
ui: (Consola, IEntradaSalida)
app: (GestorMenu, Implementa UI (private val ui: IEntradaSalida, no Consola))
 */


fun main() {
    val ui: IEntradaSalida = Consola()
    val rutaLog = "src/main/kotlin/log"
    val entrada = readln().trim()

    if (entrada.isEmpty()) {
        val logHandler = CreadorLog(rutaLog)

        val creado = logHandler.crearDirectorioSiNoExiste()
        if (creado) {
            ui.mostrar("El directorio en $rutaLog se ha creado.")
        } else {
            ui.mostrar("El directorio en $rutaLog ya estaba creado.")
        }

        val archivo = logHandler.obtenerArchivoReciente()
        if (archivo == null) {
            ui.mostrar("No existen ficheros de Log.")
        } else {
            ui.mostrar("Abriendo archivo: ${archivo.name}")
            val contenido = logHandler.leerContenido(archivo)
            ui.mostrar(contenido)
        }

    } else {
        val entradas = entrada.split(' ')
        when (entradas.size) {
            1, 4 -> ui.mostrar("Hola")
            else -> ui.mostrarError("Entrada inválida!")
        }
    }
}
