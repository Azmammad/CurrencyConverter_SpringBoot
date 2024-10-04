package com.example.currencyconverter.model.response;

import com.example.currencyconverter.model.request.CurrencyRequestDto;
import lombok.Data;

@Data
public class CurrencyResponseDto {
    private CurrencyRequestDto request; // Request DTO
    private double convertedAmount;
}

