package es.prog2425.calc2425.service

import es.prog2425.calc2425.model.Calculo
import es.prog2425.calc2425.model.Operadores

class ValidadorCalculo{
    fun validar(args: Array<String>): Calculo? {
        if (args.size != 4) return null
        val ruta = args[0]
        val numero1 = args[1].toDoubleOrNull() ?: return null
        val operador = Operadores.getOperador(args[2].firstOrNull()) ?: return null
        val numero2 = args[3].toDoubleOrNull() ?: return null

        return Calculo(ruta, numero1, operador, numero2)
    }
}