package it.stacja.bank.controller

import it.stacja.bank.model.Account
import it.stacja.bank.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RequestMapping("accounts")
@RestController
class AccountController(
        private val accountService: AccountService
) {
    @PostMapping
    fun createAccount(): ResponseEntity<Unit> {
        val account = accountService.createAccount()
        val uri: URI = requestUriWithId(account.number)

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{number}")
    fun getAccount(@PathVariable(name = "number") number: String): ResponseEntity<Account> {
        val account = accountService.findAccountByNumber(number)

        return if (account != null) {
            ResponseEntity.ok(account)
        } else {
            ResponseEntity.notFound().build();
        }
    }

    private fun requestUriWithId(id: String): URI =
            ServletUriComponentsBuilder.fromCurrentRequestUri()
            .path("/{id}")
            .buildAndExpand(id)
            .toUri()
}

