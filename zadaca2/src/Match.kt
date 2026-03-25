class Match(val homeTeam: Team, val awayTeam: Team, val stadium: Stadium, val referee: Referee, val homeGoals: Int, val awayGoals: Int){
    fun description(){
        println("${homeTeam.name} VS ${awayTeam.name} @ ${stadium.name} (referee: ${referee.firstName} ${referee.lastName})| $homeGoals:$awayGoals")
    }

    fun getWinner(): Team? {
        return if(homeGoals > awayGoals){
            homeTeam
        } else if(awayGoals > homeGoals){
            awayTeam
        } else null
    }
}