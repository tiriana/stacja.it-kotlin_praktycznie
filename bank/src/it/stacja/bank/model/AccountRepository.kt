package it.stacja.bank.model

import it.stacja.bank.model.Account

interface AccountRepository {
    fun save(account: Account): Account

    fun update(account: Account)

    fun findByNumber(accountNumber: String): Account?
}

