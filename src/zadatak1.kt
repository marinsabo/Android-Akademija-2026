fun main() {
    val name:String
    val surname:String
    var email:String? = null
    var age:Int? = 20

        if(email == null){
            println("Your email is nulL")
        }
        else{
            println("Your email address: $email")
            println("Length of your email address: ${email.length} characters")
        }

    email = "test@etfos.hr"

    email?.let{
        println("Your email address: $email")
        println("Length of your email address: ${email.length} characters")
    }
}