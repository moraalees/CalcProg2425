package es.prog2425.calc2425

import es.prog2425.calc2425.ui.Consola
import es.prog2425.calc2425.app.Calculadora
import es.prog2425.calc2425.ui.IEntradaSalida
import java.io.File

/*
model: Logica del negocio (Seguros, Usuarios, etc)
data: Repositorios del model
ui: (Consola, IEntradaSalida)
app: (GestorMenu, Implementa UI (private val ui: IEntradaSalida, no Consola))
 */


fun main() {
    val ui: IEntradaSalida = Consola()
    val rutaLog = "src/main/kotlin/log"
    var entrada = readln().trim()
    val archivo = File(rutaLog)

    if (entrada.isEmpty()){
        val estaCreado: Boolean = archivo.mkdirs()

        if (estaCreado){
            println("El directorio en $rutaLog se ha creado.")
        } else {
            println("El directorio en $rutaLog ya estaba creado.")
        }

        val archivosTxt = archivo.listFiles { file -> file.name.endsWith(".txt") }

        if (archivosTxt.isNullOrEmpty()){
            println("No existen ficheros de Log.")
        } else {
            val archivoReciente = archivosTxt.first()
            println("Abriendo archivo: ${archivoReciente.name}")
            val contenido = archivoReciente.readText()
            println(contenido)
        }

    } else {
        val entradas = entrada.split(' ')

        if (entradas.size == 1) {
            println("Hola")
        } else if (entradas.size == 4) {
            println("Hola")
        } else {
            ui.mostrarError("Entrada inválida!")
        }
    }
}
