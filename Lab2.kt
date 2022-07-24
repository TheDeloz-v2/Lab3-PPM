/*
 * Progra. de Plataformas Moviles
 * Secc. 20
 * Diego Lemus - 21469
 * Creacion: 15/07/2022
*/

// No tocar esta clase ---
data class ItemData(
    var originalPos: Int,
    var originalValue: Any,
	var type: String? = null,
    var info: String? = null
)
// -----------------------

//Funcion Main
fun main() {
    val result = processList(listOf(9, null, 30, "diego"))
    println(result)
}

//Funcion ProcessList
fun processList(inputList: List<Any?>?): List<ItemData>? {
    //Creacion de la outputList
    val outputList: MutableList<ItemData> = mutableListOf<ItemData>()
    //Verifica si la inputList es null
    if (inputList == null) return null
    for ((pos, item) in inputList.withIndex()) {
        //Caso de item null para ignorarlo
        if (item != null) {
            outputList.add(when (item) {
                //Caso Cadena
                is String -> ItemData(pos, item, "cadena", "L"+item.length)
                //Caso Entero
                is Int -> ItemData(pos, item, "entero", if (item%10 == 0) "M10" else if (item%5 == 0) "M5" else if (item%2 == 0) "M2" else null)
                //Caso Booleano
                is Boolean -> ItemData(pos, item, "booleano", if (item) "Verdadero" else "Falso")
                //Caso de otro tipo
                else -> ItemData(pos, item, null, null)
           })
        }
    }
    return outputList
}