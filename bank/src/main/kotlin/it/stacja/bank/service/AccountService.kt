package it.stacja.bank.service

import it.stacja.bank.repository.AccountRepository
import it.stacja.bank.model.Account
import org.springframework.stereotype.Service

@Service
class AccountService(
        private val accountRepository: AccountRepository,
        private val accountNumberGenerator: AccountNumberGenerator) {

    fun createAccount(): Account {
        val accountNumber: String = accountNumberGenerator.next
        val account = Account(number = accountNumber);
        return accountRepository.save(account);
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

    fun findAccountByNumber(number: String): Account? {
        return accountRepository.findByNumber(number);
    }

    private fun process(accountNumber: String, operation: (Account) -> Account) {
        val account = accountRepository.findByNumber(accountNumber);

        account?.let { accountRepository.update(operation(it)); }
    }
}