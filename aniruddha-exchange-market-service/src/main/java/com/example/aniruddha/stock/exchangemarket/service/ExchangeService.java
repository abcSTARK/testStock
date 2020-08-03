package com.example.aniruddha.stock.exchangemarket.service;

import java.util.List;

import com.example.aniruddha.stock.exchangemarket.dto.Exchange_dto;

public interface ExchangeService {
    public List<Exchange_dto> getAllStockExchange();
    public Exchange_dto addStockExchange(Exchange_dto exchangeDTO);
    public List<String> getCompaniesByExchange(String stockExchange);
}
