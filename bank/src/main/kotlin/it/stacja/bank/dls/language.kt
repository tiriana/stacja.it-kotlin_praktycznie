package it.stacja.bank.dls

import it.stacja.bank.model.Customer

fun customer(block: (customer: Customer) -> Unit): Customer {
    val customer = Customer()

    block(customer)

    return customer;
}