package com.example.currencyconverter.service.impl;

import com.example.currencyconverter.entity.Currency;
import com.example.currencyconverter.model.request.CurrencyRequestDto;
import com.example.currencyconverter.model.response.CurrencyResponseDto;
import com.example.currencyconverter.repository.CurrencyRepository;
import com.example.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Override
    public List<String> getAllCurrencies() {
        return currencyRepository.findAll().stream()
                .map(Currency::getCode)
                .toList();
    }

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Currency not found"));
    }

    @Override
    public CurrencyResponseDto convert(CurrencyRequestDto requestDto) {
        Currency fromCurrency = getCurrencyByCode(requestDto.getFromCurrency());
        Currency toCurrency = getCurrencyByCode(requestDto.getToCurrency());
        double convertedAmount = (requestDto.getAmount() / fromCurrency.getRate()) * toCurrency.getRate();

        CurrencyResponseDto responseDto = new CurrencyResponseDto();
        responseDto.setRequest(requestDto);
        responseDto.setConvertedAmount(convertedAmount);
        return responseDto;
    }
}