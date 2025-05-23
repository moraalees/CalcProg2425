package es.prog2425.calc2425.service

import es.prog2425.calc2425.model.Calculo
import es.prog2425.calc2425.model.Operadores
import java.lang.Exception

class EjecutadorDeCalculo {
    fun calcular(entrada: Calculo): Double {
        return when (entrada.operador) {
            Operadores.SUMA -> entrada.numero1 + entrada.numero2
            Operadores.RESTA -> entrada.numero1 - entrada.numero2
            Operadores.MULTIPLICACION -> entrada.numero1 * entrada.numero2
            Operadores.DIVISION -> {
                if (entrada.numero2 == 0.0) throw Exception("División por cero")
                entrada.numero1 / entrada.numero2
            }
        }
    }
}