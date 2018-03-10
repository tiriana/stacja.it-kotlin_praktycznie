package it.stacja.bank.repository

import it.stacja.bank.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long>{
    fun findByNumber(accountNumber: String): Account?
}

