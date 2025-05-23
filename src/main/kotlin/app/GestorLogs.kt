package es.prog2425.calc2425.app

import es.prog2425.calc2425.data.ICreadorLog
import es.prog2425.calc2425.ui.IEntradaSalida

class GestorLogs(
    private val creadorLog: ICreadorLog,
    private val ui: IEntradaSalida
) {

    fun procesar() {
        val creado = creadorLog.crearDirectorioSiNoExiste()
        if (creado) {
            ui.mostrar("Ruta creada")
        }

        val archivo = creadorLog.obtenerArchivoReciente()
        if (archivo == null) {
            ui.mostrar("No existen ficheros de Log")
        } else {
            ui.mostrar("Abriendo archivo: ${archivo.name}")
            val contenido = creadorLog.leerContenido(archivo)
            contenido.lineSequence().forEach { ui.mostrar(it) }
        }
    }
}