package es.prog2425.calc2425.data

import es.prog2425.calc2425.model.Calculo
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegistroCalculo(private val creadorLog: ICreadorLog) {
    fun guardar(entrada: Calculo, resultado: Double) {
        creadorLog.crearDirectorioSiNoExiste()

        val nombreArchivo = "log${LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))}.txt"
        val archivo = File("${entrada.ruta}/$nombreArchivo")

        val simboloPrincipal = entrada.operador.simbolos.first()
        archivo.writeText("Cálculo: ${entrada.numero1} $simboloPrincipal ${entrada.numero2} = $resultado")
    }
}