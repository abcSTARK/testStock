package com.example.aniruddha.stock.exchangemarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock_dto {

    private int cCode;
    private double price;
    private String stockExchange;
    private Date date;
}
