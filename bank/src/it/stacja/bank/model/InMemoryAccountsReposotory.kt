package it.stacja.bank.model

import java.util.concurrent.atomic.AtomicLong

class InMemoryAccountsReposotory: AccountRepository {

    private val accounts = mutableMapOf<String, Account>()
    private val counter = AtomicLong();

    override fun save(account: Account): Account {
        val updatedAccount = account.copy(id = counter.incrementAndGet());
        accounts[account.number] = updatedAccount;
        return updatedAccount;
    }

    override fun update(account: Account): Account? {
        val oldAccount = accounts[account.number];

        if (oldAccount != null) {
            accounts[account.number] = account;
        }

        return oldAccount;
    }

    override fun findByNumber(accountNumber: String): Account? {
        return accounts.values.firstOrNull { it.number == accountNumber }
    }
}