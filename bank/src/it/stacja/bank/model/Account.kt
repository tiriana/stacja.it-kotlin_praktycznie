package it.stacja.bank.model

data class Account(val id: Long, val number: String, val ballance: Long) {
    fun deposit(funds: Long) = copy(ballance = ballance + funds)
    fun withdraw(funds: Long) {
        if (ballance < funds) {
            throw new InsufficentFundsException();
        }
    }
}

class InsufficentFundsException: Throwable() {}