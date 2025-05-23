package es.prog2425.calc2425.data

import java.io.File

class CreadorLog(ruta: String) : ICreadorLog{
    private val directorio = File(ruta)

    override fun crearDirectorioSiNoExiste(): Boolean {
        return if (!directorio.exists()) {
            directorio.mkdirs()
        } else {
            false
        }
    }

    override fun obtenerArchivosTxt(): List<File> {
        return directorio.listFiles { file -> file.name.endsWith(".txt") }?.toList() ?: emptyList()
    }

    override fun obtenerArchivoReciente(): File? {
        return obtenerArchivosTxt().firstOrNull()
    }

    override fun leerContenido(file: File): String {
        return file.readText()
    }
}