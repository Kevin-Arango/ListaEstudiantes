package com.example.listaestudiantes

fun main() {
    val crudEst: CRUDEstudiante = CRUDEstudiante()

    while (true) {
        println("Menú de Opciones:")
        println("1. Insertar Estudiante")
        println("2. Eliminar Estudiante")
        println("3. Editar Estudiante")
        println("4. Buscar Estudiante")
        println("5. Listar Estudiantes")
        println("6. Salir")
        print("Selecciona una opción: ")

        val opcion = readLine()?.toIntOrNull() ?: 0

        when (opcion) {
            1 -> {
                println("Insertar Estudiante")
                print("Número de Control: ")
                val numControl = readLine() ?: ""
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Apellidos: ")
                val apellidos = readLine() ?: ""
                print("Semestre: ")
                val semestre = readLine()?.toIntOrNull() ?: 0

                crudEst.crearEstudiante(numControl, nombre, apellidos, semestre)
                println("Estudiante creado exitosamente.")
            }
            2 -> {
                println("Eliminar Estudiante")
                print("Número de Control del estudiante a eliminar: ")
                val numControl = readLine() ?: ""
                val estudianteEliminado = crudEst.eliminarEstudiante(numControl)
                if (estudianteEliminado != null) {
                    println("Estudiante eliminado: ${estudianteEliminado.numControl}")
                } else {
                    println("No se encontró ningún estudiante con ese número de control.")
                }
            }
            3 -> {
                println("Editar Estudiante")
                print("Número de Control del estudiante a editar: ")
                val numControl = readLine() ?: ""
                val estudianteAEditar = crudEst.buscarEstudiante(numControl)

                if (estudianteAEditar != null) {
                    println("Editando estudiante: ${estudianteAEditar.nombre} ${estudianteAEditar.apellidos}")
                    print("Nuevo Nombre: ")
                    val nuevoNombre = readLine() ?: estudianteAEditar.nombre
                    print("Nuevos Apellidos: ")
                    val nuevosApellidos = readLine() ?: estudianteAEditar.apellidos
                    print("Nuevo Semestre: ")
                    val nuevoSemestre = readLine()?.toIntOrNull() ?: estudianteAEditar.semestre

                    estudianteAEditar.nombre = nuevoNombre
                    estudianteAEditar.apellidos = nuevosApellidos
                    estudianteAEditar.semestre = nuevoSemestre

                    println("Estudiante editado exitosamente.")
                } else {
                    println("No se encontró ningún estudiante con ese número de control.")
                }
            }
            4 -> {
                println("Buscar Estudiante")
                print("Número de Control del estudiante a buscar: ")
                val numControl = readLine() ?: ""
                val estudianteEncontrado = crudEst.buscarEstudiante(numControl)
                if (estudianteEncontrado != null) {
                    println("Estudiante encontrado:")
                    println("Número de Control: ${estudianteEncontrado.numControl}")
                    println("Nombre: ${estudianteEncontrado.nombre}")
                    println("Apellidos: ${estudianteEncontrado.apellidos}")
                    println("Semestre: ${estudianteEncontrado.semestre}")
                } else {
                    println("No se encontró ningún estudiante con ese número de control.")
                }
            }
            5 -> {
                println("Listar Estudiantes")
                println(crudEst.obtenerListaEstudiantes())
            }
            6 -> {
                println("Saliendo del programa...")
                return
            }
            else -> {
            }
        }
    }
}