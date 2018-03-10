package it.stacja.bank.repository

import it.stacja.bank.model.Account

interface AccountRepository {
    fun save(account: Account): Account

    fun update(account: Account): Account?

    fun findByNumber(accountNumber: String): Account?
}

