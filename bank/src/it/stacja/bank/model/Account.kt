package it.stacja.bank.model

data class Account(val id: Long = 0, val number: String, val ballance: Long = 0) {
    fun deposit(funds: Long): Account = copy(ballance = ballance + funds)

    fun withdraw(funds: Long): Account {
        if (ballance < funds) {
            throw InsufficentFundsException();
        }
        return copy(ballance = ballance - funds);
    }
}

class InsufficentFundsException: Throwable()