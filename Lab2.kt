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
    //Lista Output
    val outputList: MutableList<ItemData> = mutableListOf<ItemData>()
    //Variables
    var pos = 0 
    
    if(inputList == null) return null
    for (item: Any? in inputList){
            //Verifica si el item es null para ignorarlo
            if(item != null){
                outputList.add(when (item) {
                    //Caso Cadena
                    is String -> {
                        ItemData(pos, item, "cadena", "L"+item.length)
                    }
                    //Caso Entero
                    is Int -> {
                        //Multiplos
                        ItemData(pos, item, "entero", if(item%10 == 0) "M10" else if (item%5 == 0) "M5" else if(item%2 == 0) "M2" else null)
                    }
                    //Caso Booleano
                    is Boolean -> {
                        ItemData(pos, item, "booleano", if(item) "Verdadero" else "Falso")
                    }
                    //Caso de otro tipo
                    else -> {
                        ItemData(pos, item, null, null)
                    }
               }
                )
            }
            //Contador
            pos += 1
        }
        return outputList
}