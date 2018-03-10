package it.stacja.bank.dls

import it.stacja.bank.model.Customer

fun customer(block: Customer.() -> Unit): Customer {
    val customer = Customer()
    block(customer)
    return customer;
}

val newCustomer = customer {
    name = "Kowalski"
}