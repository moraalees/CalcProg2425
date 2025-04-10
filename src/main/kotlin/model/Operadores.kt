package es.prog2425.calc2425.model

enum class Operadores(val simbolos: List<Char>) {
    SUMA(listOf('+')),
    RESTA(listOf('-')),
    MULTIPLICACION(listOf('*', 'x')),
    DIVISION(listOf(':', '/'));

    companion object {
        fun getOperador(operador: Char?) = operador?.let { op -> entries.find { op in it.simbolos } }
    }
}