package it.stacja.bank.model

class InMemoryAccountsReposotory: AccountRepository {
    override fun save(account: Account): Account {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(account: Account) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByNumber(accountNumber: String): Account? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}