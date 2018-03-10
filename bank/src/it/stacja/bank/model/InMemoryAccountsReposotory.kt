package it.stacja.bank.model

import java.util.concurrent.atomic.AtomicLong

class InMemoryAccountsReposotory: AccountRepository {

    private val accounts = mutableMapOf<String, Account>()
    private val counter = AtomicLong();

    override fun save(account: Account): Account {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(account: Account) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByNumber(accountNumber: String): Account? {
        val id = counter.incrementAndGet();
    }
}