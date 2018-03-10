package it.stacja.bank.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Account(@GeneratedValue @Id val id: Long = 0, val number: String, val ballance: Long = 0) {
    fun deposit(funds: Long): Account = copy(ballance = ballance + funds)

    fun withdraw(funds: Long): Account = copy(ballance = ballance - funds)

    fun checkFunds(funds: Long) {
        if (ballance < funds) {
            throw InsufficentFundsException();
        }
    }
}

class InsufficentFundsException: Throwable()