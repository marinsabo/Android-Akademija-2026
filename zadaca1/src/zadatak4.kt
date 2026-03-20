fun main() {
    fun preprocess(username: String): String {
        return username.lowercase().trim()
    }

    fun validateUsername(username: String): Boolean {
        if (username.isBlank()) return false

        val length = username.length
        val startingCharacter = username.first().isLetter()
        val onlyAllowedCharacters = username.all { it.isLetterOrDigit() || it == '_' }
        val containsSpace = username.contains(' ')

        return length in 5..15 && startingCharacter && onlyAllowedCharacters && !containsSpace
    }
    
    val testUsernames = listOf(" John_doe123 ", "ab", "123invalid", "valid_user", " has space ")

    for (raw in testUsernames) {
        val processed = preprocess(raw)
        val valid = validateUsername(processed)
        println("Raw: \"$raw\" → Processed: \"$processed\" → Valid: $valid")
    }
}