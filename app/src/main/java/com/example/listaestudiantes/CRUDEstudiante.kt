package com.example.listaestudiantes

class CRUDEstudiante {
    var listaEstudiantes : MutableList<Estudiante> = mutableListOf()

    fun crearEstudiante(numControl: String, nombre:String, apellidos:String, semestre:Int){
        val estudiante : Estudiante = Estudiante(numControl,nombre,apellidos,semestre)
        listaEstudiantes.add( estudiante)
    }

    fun eliminarEstudiante(numControl: String): Estudiante? {
        val estudianteEliminado = listaEstudiantes.find { it.numControl == numControl }
        estudianteEliminado?.let { listaEstudiantes.remove(it) }
        return estudianteEliminado
    }

    fun buscarEstudiante(numControl: String): Estudiante? {
        return listaEstudiantes.find { it.numControl == numControl }
    }

    fun obtenerListaEstudiantes(): String{
        var cadena="N.C.\tNombre\tApellidos\tSemestre\n"
        listaEstudiantes.forEach(){
            cadena+=it.numControl+"\t"+ it.nombre+"\t"+it.apellidos+"\t"+it.semestre+"\n"
        }
        return  cadena
    }
}
