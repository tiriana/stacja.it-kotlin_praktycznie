package it.stacja.bank.dls

import it.stacja.bank.model.Customer

fun customer(block: Customer.() -> Unit): Customer = Customer().apply(block);

val newCustomer = customer {
    name = "Kowalski"
}