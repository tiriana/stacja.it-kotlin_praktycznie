package it.stacja.bank.dls

import it.stacja.bank.model.Address
import it.stacja.bank.model.Customer
import java.text.SimpleDateFormat
import java.util.*

@DslMarker
annotation class CustomerDsl

@CustomerDsl
class AddressBuilder {
    var info = ""
    var city = ""
    var code = ""

    fun build(): Address = Address(info, city, code)
}

@CustomerDsl
class Addresses: ArrayList<Address>() {
    fun address(block: AddressBuilder.() -> Unit) {
        add(AddressBuilder().apply(block).build());
    }
}

@CustomerDsl
class CustomerBuilder {
    var name = ""
    private var dob = Date()
    var dateOfBirth: String = ""
        set(value) {
            dob = SimpleDateFormat("dd-MM-yyyy").parse(value)
        }
    private var addresses = mutableListOf<Address>();

    fun addresses(block: Addresses.() -> Unit) {
        addresses.addAll(Addresses().apply(block))
    }

    fun build(): Customer = Customer(name, dob, addresses)
}

fun customer(block: CustomerBuilder.() -> Unit): Customer =
        CustomerBuilder().apply(block).build();

//-----------------------------


val newCustomer = customer {
    name = "Jan Kowalski"
    dateOfBirth = "02-03-1980"
    addresses {
        address {
            info = "Dąbrowskiego 79a"
            city = "Poznań"
            code = "11-222"
        }
        address {
            info = "Grunwaldzka 123"
            city = "Poznań"
            code = "11-222"
        }
    }

}