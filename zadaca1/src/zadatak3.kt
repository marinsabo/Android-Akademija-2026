fun main() {
    val list = listOf(4500, 12000, 8000, 15000, 3000, 11000, 9500)
    var sum = 0

    for (i in list) {
        sum += i
    }
    println("Sum of all steps made this week: $sum")

    var found = false
    var index = 0
    while (!found) {
        if (list[index] >= 10000) {
            found = true
            break
        } else {
            index++
        }
    }

    println("You made 10k steps first time this week on day ${index + 1}")
}