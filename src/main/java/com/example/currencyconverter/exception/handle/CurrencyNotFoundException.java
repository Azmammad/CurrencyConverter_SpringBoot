package com.example.currencyconverter.exception.handle;

public class CurrencyNotFoundException extends RuntimeException {
    public CurrencyNotFoundException(String code) {
        super("Currency with code " + code + " not found");
    }
}
