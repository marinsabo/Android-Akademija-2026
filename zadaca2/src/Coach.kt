class Coach(firstName: String, lastName: String, age: Int, nationality: String) : Person(firstName, lastName, age, nationality) {
    override fun description() {
        println("$firstName $lastName | $age years old | $nationality")
    }
}