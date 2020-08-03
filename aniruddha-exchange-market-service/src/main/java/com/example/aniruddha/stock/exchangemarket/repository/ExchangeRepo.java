package com.example.aniruddha.stock.exchangemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aniruddha.stock.exchangemarket.model.Exchange;

public interface ExchangeRepo extends JpaRepository<Exchange,Long> {

}
