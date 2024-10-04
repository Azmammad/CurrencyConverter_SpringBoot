package com.example.currencyconverter.model.request;

import lombok.Data;

@Data
public class CurrencyRequestDto {
    private String fromCurrency;
    private String toCurrency;
    private double amount;
}

