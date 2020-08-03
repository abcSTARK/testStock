package com.example.aniruddha.stock.exchangemarket.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aniruddha.stock.exchangemarket.dto.Company_dto;
import com.example.aniruddha.stock.exchangemarket.dto.Exchange_dto;
import com.example.aniruddha.stock.exchangemarket.model.Ipo;
import com.example.aniruddha.stock.exchangemarket.model.Exchange;
import com.example.aniruddha.stock.exchangemarket.repository.IpoRepo;
import com.example.aniruddha.stock.exchangemarket.repository.ExchangeRepo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    ExchangeRepo ExchangeRepo;
   
    @Autowired
    IpoRepo IpoRepo;

    
    @Override
    @Transactional
    public List<Exchange_dto> getAllStockExchange() {

       List<Exchange> stockExchanges = ExchangeRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        Type list_type = new TypeToken<Iterable<Exchange_dto>>(){}.getType();
        List<Exchange_dto> DtoList = modelMapper.map(stockExchanges,list_type);
        
        return DtoList;
    }

    @Override
    @Transactional
    public Exchange_dto addStockExchange(Exchange_dto exchangeDTO) {
        
    	ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Exchange stockExchange = new Exchange();
        modelMapper.map(exchangeDTO,stockExchange);
        
        return exchangeDTO;
    }

    @Override
    public List<String> getCompaniesByExchange(String stockExchange) {
        
    	List<Ipo> list = IpoRepo.getAllByStockExchange(stockExchange);
        
    	List<String> arr = new ArrayList<>(){};
        
        for (Ipo ip:list) {
            arr.add(ip.getCName());
        }
        
        return arr;
    }
}
