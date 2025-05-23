package es.prog2425.calc2425.data

import java.io.File

interface ICreadorLog {
    fun crearDirectorioSiNoExiste(): Boolean
    fun obtenerArchivosTxt(): List<File>
    fun obtenerArchivoReciente(): File?
    fun leerContenido(file: File): String
}