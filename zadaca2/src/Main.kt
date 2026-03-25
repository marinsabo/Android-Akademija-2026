fun main() {
    //unaprijed isprike na kaotičnom test-caseu
    runTest()
}

fun runTest(){

        val thibautCourtois = Player("Thibaut", "Courtois", 33, "Belgium", Position.GOALKEEPER, 0, 0)
        val ederMilitao = Player("Eder", "Militao", 28, "Brazil", Position.DEFENDER, 1, 1)
        val antonioRudiger = Player("Antonio", "Rudiger", 33, "Germany", Position.DEFENDER, 2, 0)
        val ferlandMendy = Player("Ferland", "Mendy", 30, "France", Position.DEFENDER, 0, 1)
        val danielCarvajal = Player("Daniel", "Carvajal", 34, "Spain", Position.DEFENDER, 2, 3)
        val federicoValverde = Player("Federico", "Valverde", 27, "Uruguay", Position.MIDFIELDER, 5, 4)
        val judeBellingham = Player("Jude", "Bellingham", 22, "England", Position.MIDFIELDER, 8, 6)
        val ardaGuler = Player("Arda", "Guler", 21, "Turkey", Position.MIDFIELDER, 4, 3)
        val viniciusJunior = Player("Vinicius", "Junior", 25, "Brazil", Position.ATTACKER, 14, 7)
        val kylianMbappe = Player("Kylian", "Mbappe", 27, "France", Position.ATTACKER, 18, 5)
        val rodrygoSilva = Player("Rodrygo", "Silva", 25, "Brazil", Position.ATTACKER, 6, 4)
        val realMadridPlayers = mutableListOf(thibautCourtois, ederMilitao, antonioRudiger, ferlandMendy,
            danielCarvajal, federicoValverde, judeBellingham, ardaGuler, viniciusJunior, kylianMbappe, rodrygoSilva)
        val realMadrid = Team("Real Madrid", "Spain", 1902, Coach("Carlo", "Ancelotti", 65, "Italy"), realMadridPlayers)

        val marcAndreStegen = Player("Marc-Andre", "ter Stegen", 33, "Germany", Position.GOALKEEPER, 0, 0)
        val julesTounde = Player("Jules", "Kounde", 26, "France", Position.DEFENDER, 3, 2)
        val ronaldAraujo = Player("Ronald", "Araujo", 25, "Uruguay", Position.DEFENDER, 1, 0)
        val andreasChristensen = Player("Andreas", "Christensen", 28, "Denmark", Position.DEFENDER, 0, 1)
        val alejandroAlba = Player("Alejandro", "Balde", 21, "Spain", Position.DEFENDER, 1, 4)
        val pedri = Player("Pedri", "Gonzalez", 22, "Spain", Position.MIDFIELDER, 4, 6)
        val gaviFernandez = Player("Gavi", "Fernandez", 20, "Spain", Position.MIDFIELDER, 3, 4)
        val ferminLopez = Player("Fermin", "Lopez", 22, "Spain", Position.MIDFIELDER, 6, 3)
        val robertLewandowski = Player("Robert", "Lewandowski", 36, "Poland", Position.ATTACKER, 19, 8)
        val raphinha = Player("Raphinha", "Belloli", 28, "Brazil", Position.ATTACKER, 15, 9)
        val lamineYamal = Player("Lamine", "Yamal", 17, "Spain", Position.ATTACKER, 10, 14)
        val barcelonaPlayers = mutableListOf(marcAndreStegen, julesTounde, ronaldAraujo, andreasChristensen,
            alejandroAlba, pedri, gaviFernandez, ferminLopez, robertLewandowski, raphinha, lamineYamal)
        val barcelona = Team("Barcelona", "Spain", 1899, Coach("Hansi", "Flick", 59, "Germany"), barcelonaPlayers)

        realMadrid.printAllPlayers()
        realMadrid.coach.description()
        println()

        println("-- Sorted by goals --")
        realMadrid.sortByGoals().forEach { it.description() }
        println()

        println("-- Sorted by assists --")
        realMadrid.sortByAssists().forEach { it.description() }
        println()

        println("-- Sorted by G+A --")
        realMadrid.sortByGA().forEach { it.description() }
        println()

        val rmTopScorer = realMadrid.getTopScorer()
        println("Top scorer: ${rmTopScorer.firstName} ${rmTopScorer.lastName} | ${rmTopScorer.goals} goals")
        println()

        println("========== TRANSFER WINDOW ==========")
        println("Real Madrid sign Dani Ceballos...")
        realMadrid.addPlayer(Player("Dani", "Ceballos", 29, "Spain", Position.MIDFIELDER, 0, 0))
        println("Real Madrid change coach...")
        realMadrid.changeCoach(Coach("Alvaro", "Arbeloa", 43, "Spain"))
        println("Updated squad:")
        realMadrid.printAllPlayers()
        realMadrid.coach.description()
        println()

        barcelona.printAllPlayers()
        barcelona.coach.description()
        println()

        println("-- Sorted by goals --")
        barcelona.sortByGoals().forEach { it.description() }
        println()

        println("-- Sorted by assists --")
        barcelona.sortByAssists().forEach { it.description() }
        println()

        println("-- Sorted by G+A --")
        barcelona.sortByGA().forEach { it.description() }
        println()

        val barcaTopScorer = barcelona.getTopScorer()
        println("Top scorer: ${barcaTopScorer.firstName} ${barcaTopScorer.lastName} | ${barcaTopScorer.goals} goals")
        println()

        println("========== EL CLASICO ==========")
        val santiagoBernabeu = Stadium("Santiago Bernabeu", 83000, 1947)
        val patrikKolaric = Referee("Patrik", "Kolaric", 31, "Croatia")
        val elClasico = Match(realMadrid, barcelona, santiagoBernabeu, patrikKolaric, 4, 2)
        elClasico.description()
        println("${elClasico.getWinner()?.name} won the match")
}