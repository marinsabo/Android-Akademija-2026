class Player(firstName: String = "unknown", lastName: String = "unknown", age: Int = 0, nationality: String = "unknown",
             private var position: Position = Position.UNKNOWN, var goals : Int = 0, var assists: Int = 0) : Person(firstName, lastName, age, nationality) {

    override fun description() {
        println("$firstName $lastName | $position | $age years old | $nationality | Goals: $goals | Assists: $assists")
    }
    fun addGoals(newGoals: Int){
        goals += newGoals
    }
    fun addAssists(newAssists: Int){
        assists += newAssists
    }
    fun changePosition(newPosition: Position){ position = newPosition }
    fun getGA(): Int =  goals + assists
}