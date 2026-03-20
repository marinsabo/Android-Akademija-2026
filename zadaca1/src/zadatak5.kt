object TransactionLogger {
    fun log(message: String) {
        println(message)
    }
}

class BankAccount(accountNumber: String) {
    var balance = 0.0

    companion object {
        var totalAccounts = 0
    }

    init {
        totalAccounts++
        TransactionLogger.log("Account $accountNumber created. Total accounts: $totalAccounts")
    }

    fun payment(money: Double) {
        balance += money
        TransactionLogger.log("Deposited $money€. New balance: $balance€")
    }

    fun payout(money: Double) {
        if (money > balance) {
            println("You do not have enough money. Current balance: $balance€")
        } else {
            balance -= money
            TransactionLogger.log("Withdrawn $money€. New balance: $balance€")
        }
    }
}

fun main() {
    val account1 = BankAccount("HR123456")
    val account2 = BankAccount("HR789012")
    val account3 = BankAccount("HR345678")

    account1.payment(500.0)
    account1.payout(200.0)
    account1.payout(400.0)

    account2.payment(1000.0)
    account2.payout(300.0)

    account3.payment(250.0)

    println("\nAccount Balances")
    println("Account 1 balance: ${account1.balance}€")
    println("Account 2 balance: ${account2.balance}€")
    println("Account 3 balance: ${account3.balance}€")
    println("Total accounts created: ${BankAccount.totalAccounts}")
}