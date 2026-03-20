fun main() {
    var code = 0
    var price = 0.0
    var receivedMoney: Double

    println("Select product number [1-4]: ")
    code = readln().toInt()

    val name = when(code) {
        1 -> "Voda"
        2 -> "Cola"
        3 -> "Sok"
        4 -> "Kava"
        else -> "Invalid product code"
    }

    price = when(code) {
        1 -> 1.0
        2 -> 2.0
        3 -> 2.0
        4 -> 1.5
        else -> 0.0
    }

    println("Price of selected product: $price€")
    println("Insert money: ")
    receivedMoney = readln().toDouble()

    if (receivedMoney >= price) {
        println("Preparing $name")
        val change = receivedMoney - price
        println("Change is: $change€")
    } else {
        val difference = price - receivedMoney
        println("You are missing $difference€ to purchase $name")
    }
}