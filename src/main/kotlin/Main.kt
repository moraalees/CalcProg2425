package es.prog2425.calc2425

import es.prog2425.calc2425.ui.Consola
import es.prog2425.calc2425.app.Calculadora
import java.io.File

/*
model: Logica del negocio (Seguros, Usuarios, etc)
data: Repositorios del model
ui: (Consola, IEntradaSalida)
app: (GestorMenu, Implementa UI (private val ui: IEntradaSalida, no Consola))
 */


fun main() {
    val rutaLog = "src/main/kotlin/log"
    val archivo = File(rutaLog)

    val estaCreado: Boolean = archivo.mkdirs()

    if (estaCreado){
        println("$rutaLog se ha creado.")
    } else {
        println("$rutaLog ya estaba creada.")
    }

    Calculadora(Consola()).iniciar()
}
