package it.stacja.bank.dls

import it.stacja.bank.model.Address
import it.stacja.bank.model.Customer

fun customer(block: Customer.() -> Unit): Customer = Customer().apply(block);

fun Customer.address(block: Address.() -> Unit) {
    address = Address().apply(block);
}

val newCustomer = customer {
    name = "Kowalski"
    address {
        baseInfo = "Dąbrowskiego"
        city = "Poznań"
        postalCode = "61-234"
    }
}