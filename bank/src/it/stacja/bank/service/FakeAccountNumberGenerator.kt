package it.stacja.bank.service

import java.lang.String.format
import java.util.concurrent.atomic.AtomicLong

class FakeAccountNumberGenerator() : AccountNumberGenerator {
    override val next: String
        get() = format("%026d", counter.incrementAndGet())

    private val counter = AtomicLong();
}