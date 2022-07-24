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
    var typ: String?
    var inf: String? = ""
    
    if(inputList == null) return null
    for (item: Any? in inputList){
            //Verifica si el item es null para ignorarlo
            if(item != null){
                when (item) {
                    //Caso Cadena
                    is String -> {
                        typ = "cadena"
                        inf = ("L"+item.length)
                    }
                    //Caso Entero
                    is Int -> {
                        typ = "entero"
                        //Multiplos
                        if(item%10 == 0) inf = "M10" else if (item%5 == 0) inf = "M5" else if(item%2 == 0) inf = "M2" else inf = null
                    }
                    //Caso Booleano
                    is Boolean -> {
                        typ = "booleano"
                        if(item) inf = "Verdadero" else inf = "Falso"
                    }
                    //Caso de otro tipo
                    else -> {
                        typ = null
                        inf = null
                    }
               }
                //Item para output list
                val newItem = ItemData(
                originalPos = pos,
                originalValue = item,
                type = typ,
                info = inf
                )
                //Se agrega item a output list
                outputList.add(newItem)
            }
            //Contador
            pos += 1
        }
        return outputList
}