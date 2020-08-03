package com.example.aniruddha.stock.exchangemarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aniruddha.stock.exchangemarket.model.Ipo;

import java.util.List;

public interface IpoRepo extends JpaRepository<Ipo,Long> {
    public List<Ipo> getAllByStockExchange(String stockExchange);
}
