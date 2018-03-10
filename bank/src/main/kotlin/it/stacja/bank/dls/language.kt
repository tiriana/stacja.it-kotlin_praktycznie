package it.stacja.bank.dls

import it.stacja.bank.model.Address
import it.stacja.bank.model.Customer
import java.text.SimpleDateFormat
import java.util.*

class AddressBuilder {
    var info = ""
    var city = ""
    var code = ""

    fun build(): Address = Address(info, city, code)
}

class CustomerBuilder {
    var name = ""
    private var dob = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("dd-MM-yyyy").parse(value)
        }
    private var address: Address? = null

    fun address(block: AddressBuilder.() -> Unit) {
        address = AddressBuilder().apply(block).build()
    }

    fun build(): Customer = Customer(name, dob, address)
}

fun customer(block: CustomerBuilder.() -> Unit): Customer =
        CustomerBuilder().apply(block).build();

//-----------------------------


val newCustomer = customer {
    name = "Jan Kowalski"
    dateOfBirth = "02-03-1980"
    address {
        info = "Dąbrowskiego 79a"
        city = "poznań"
        code = "11-222"
    }
}