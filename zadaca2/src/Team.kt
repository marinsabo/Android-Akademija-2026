class Team(val name: String, val nationality: String, val yearFounded: Int, var coach: Coach, private val players: MutableList<Player>){
    fun printAllPlayers(){
        println("$name squad")
        println("--------------------------------------------------")
        players.forEach{
            it.description()
        }
        println("--------------------------------------------------")
        println("Total: ${players.count()} players | Foreigners: ${getAllForeigners()} | Locals: ${getAllLocals()} | Average age: ${"%.1f".format(getAverageAge())}")
    }
    fun getAllLocals(): Int = players.count { it.nationality.uppercase() == nationality.uppercase() }
    fun getAllForeigners() : Int = players.count() - getAllLocals()
    fun addPlayer(player: Player) = players.add(player)
    fun removePlayer(player: Player) = players.remove(player)
    fun changeCoach(newCoach: Coach){
        coach = newCoach
    }
    fun getAverageAge(): Double = players.map { it.age }.average()
    fun getTopScorer(): Player = players.maxBy { it.goals }
    fun sortByGoals(): List<Player> = players.sortedByDescending { it.goals }
    fun sortByAssists(): List<Player> = players.sortedByDescending { it.assists }
    fun sortByGA(): List<Player> = players.sortedByDescending { it.getGA() }
}