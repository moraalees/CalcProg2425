package es.prog2425.calc2425

import es.prog2425.calc2425.app.Calculadora
import es.prog2425.calc2425.app.GestorLogs
import es.prog2425.calc2425.ui.Consola
import es.prog2425.calc2425.data.CreadorLog
import es.prog2425.calc2425.data.ICreadorLog
import es.prog2425.calc2425.data.RegistroCalculo
import es.prog2425.calc2425.service.EjecutadorDeCalculo
import es.prog2425.calc2425.service.ValidadorCalculo
import es.prog2425.calc2425.ui.IEntradaSalida


fun main(args: Array<String>) {
    val ui: IEntradaSalida = Consola()

    when (args.size) {
        0 -> {
            //MODO DE CALCULADORA
            val calculadora = Calculadora(ui)
            calculadora.iniciar()
        }

        1 -> {
            // MODO LOGS
            val creadorLog: ICreadorLog = CreadorLog(args.first())
            val gestor = GestorLogs(creadorLog, ui)
            gestor.procesar()
        }

        4 -> {
            val validador = ValidadorCalculo()
            val entrada = validador.validar(args)

            if (entrada == null) {
                ui.mostrarError("Argumentos inválidos para el cálculo.")
                return
            }

            try {
                val resultado = EjecutadorDeCalculo().calcular(entrada)
                ui.mostrar("Resultado: $resultado")

                val creadorLog: ICreadorLog = CreadorLog(entrada.ruta)
                val registrador = RegistroCalculo(creadorLog)
                registrador.guardar(entrada, resultado)

            } catch (e: ArithmeticException) {
                ui.mostrarError(e.message ?: "Error en el cálculo.")
            }
        }

        else -> {
            ui.mostrarError("Número de argumentos inválido.")
        }
    }
}
