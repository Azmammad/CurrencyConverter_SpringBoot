package com.example.currencyconverter.service;

import com.example.currencyconverter.entity.Currency;
import com.example.currencyconverter.model.request.CurrencyRequestDto;
import com.example.currencyconverter.model.response.CurrencyResponseDto;

import java.util.List;

public interface CurrencyService {
    List<String> getAllCurrencies();
    Currency getCurrencyByCode(String code);
    CurrencyResponseDto convert(CurrencyRequestDto requestDto);
}
