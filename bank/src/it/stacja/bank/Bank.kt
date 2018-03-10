package it.stacja.bank

import it.stacja.bank.repository.InMemoryAccountsReposotory
import it.stacja.bank.service.AccountService
import it.stacja.bank.service.FakeAccountNumberGenerator

fun main(args: Array<String>) {
    val accountsRepository = InMemoryAccountsReposotory()
    val accountNumberGenerator = FakeAccountNumberGenerator()
    val accountService = AccountService(accountsRepository, accountNumberGenerator)
    //--------------------------------------------------------
    val firstAccount = accountService.createAccount()
    accountService.deposit(firstAccount.number, funds = 10_000)

    println(accountService.findAccountByNumber(firstAccount.number));
}