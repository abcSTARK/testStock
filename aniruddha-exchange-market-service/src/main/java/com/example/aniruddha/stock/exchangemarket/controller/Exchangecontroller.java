package com.example.aniruddha.stock.exchangemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.aniruddha.stock.exchangemarket.dto.Exchange_dto;
import com.example.aniruddha.stock.exchangemarket.model.Exchange;
import com.example.aniruddha.stock.exchangemarket.service.ExchangeService;

@Controller
public class Exchangecontroller {

    @Autowired
    ExchangeService service;

    //TO GET ALL STOCK EXCHANGE
    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Exchange_dto>> getStockExchangeList(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAllStockExchange());
    }

    //TO ADD STOCK TO EXCHANGE MARKET
    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<Exchange_dto> addStockExchangeList(@RequestBody Exchange_dto exchangedto){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.addStockExchange(exchangedto));
    }

    //TO GET STOCKS OF COMPANIES
    @RequestMapping(value = "/exchange/{exchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable String exchange){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompaniesByExchange(exchange));
    }

}
