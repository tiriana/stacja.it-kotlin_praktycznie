package it.stacja.bank.repository

import it.stacja.bank.model.Account
import org.springframework.stereotype.Repository
import java.util.concurrent.atomic.AtomicLong

@Repository
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

    override fun findByNumber(accountNumber: String): Account?
        = accounts.values.firstOrNull { it.number == accountNumber }
}