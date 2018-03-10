package it.stacja.bank.service

import it.stacja.bank.repository.AccountRepository
import it.stacja.bank.model.Account

class AccountService(
        val accountRepository: AccountRepository,
        val accountNumberGenerator: AccountNumberGenerator) {

    fun createAccount() {
        val accountNumber: String = accountNumberGenerator.next
        val account = Account(number = accountNumber);
    }
}