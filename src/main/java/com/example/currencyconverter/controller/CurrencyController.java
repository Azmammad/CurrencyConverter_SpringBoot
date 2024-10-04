package com.example.currencyconverter.controller;

import com.example.currencyconverter.entity.Currency;
import com.example.currencyconverter.model.request.CurrencyRequestDto;
import com.example.currencyconverter.model.response.CurrencyResponseDto;
import com.example.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping("/")
    public String index() {
        return "Currency Converter API";
    }

    @GetMapping
    public List<String> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/{code}")
    public CurrencyResponseDto getCurrencyByCode(@PathVariable String code) {
        Currency currency = currencyService.getCurrencyByCode(code);
        CurrencyRequestDto requestDto = new CurrencyRequestDto();
        requestDto.setFromCurrency(currency.getCode());

        CurrencyResponseDto responseDto = new CurrencyResponseDto();
        responseDto.setRequest(requestDto);
        responseDto.setConvertedAmount(0);
        return responseDto;
    }

    @GetMapping("/convert")
    public CurrencyResponseDto convertCurrency(@RequestParam String fromCurrency,
                                               @RequestParam String toCurrency,
                                               @RequestParam double amount) {
        CurrencyRequestDto request = new CurrencyRequestDto();
        request.setFromCurrency(fromCurrency);
        request.setToCurrency(toCurrency);
        request.setAmount(amount);
        return currencyService.convert(request);
    }
}
