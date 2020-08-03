package com.example.aniruddha.stock.exchangemarket;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.aniruddha.stock.exchangemarket.dto.Exchange_dto;

@FeignClient(name="aniruddha-zullproxy")
public interface ProxyExchangemarket {

    @RequestMapping(value = "/exchange/all",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Exchange_dto>> getStockExchangeList();

    @RequestMapping(value = "/exchange/add",method = RequestMethod.POST)
    public ResponseEntity<Exchange_dto> addStockExchangeList(@RequestBody Exchange_dto stockExchangeDTO);

    @RequestMapping(value = "/exchange/{stockExchange}/companies",method = RequestMethod.GET)
    public ResponseEntity<Iterable<String>> getCompaniesByExchange(@PathVariable(value = "stockExchange") String stockExchange);
}
