class Stadium(val name: String, var capacity: Int, val buildingYear: Int){
    fun description(){
        println("$name | $capacity | $buildingYear")
    }
}