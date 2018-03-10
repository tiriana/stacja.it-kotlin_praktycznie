package it.stacja.bank.service

import it.stacja.bank.repository.AccountRepository
import it.stacja.bank.model.Account

class AccountService(
        val accountRepository: AccountRepository,
        val accountNumberGenerator: AccountNumberGenerator) {

    fun createAccount() {
        val accountNumber: String = accountNumberGenerator.next
        val account = Account(number = accountNumber);
        accountRepository.save(account);
    }

    fun deposit(accountNumber: String, funds: Long) {
        process(accountNumber) { it.deposit(funds); }
    }

    fun withdraw(accountNumber: String, funds: Long) {
        process(accountNumber) {
            it.checkFunds(funds);
            it.withdraw(funds);
        }
    }

    private fun process(accountNumber: String, operation: (Account) -> Account) {
        val account = accountRepository.findByNumber(accountNumber);

        account?.let { accountRepository.update(operation(it)); }
    }
}