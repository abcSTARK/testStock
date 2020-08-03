package com.example.aniruddha.stock.Sector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.aniruddha.stock.Sector.dto.Company_dto;
import com.example.aniruddha.stock.Sector.service.Sectorservice;

import java.util.List;

@Controller
public class Sectorcontroller {
    @Autowired
    Sectorservice service;

    //GET ALL COMPANIES FROM SECTOR
    @RequestMapping("/sector/listCompanies/{s}")
    public ResponseEntity<List<Company_dto>> getListOfCompaniesInSector(@PathVariable String s){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getListOfCompaniesInSector(s));
    }

    //GET ALL STOCK PRICE FROM RANGE
    @RequestMapping("/sector/price/{sId}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable String sId,@PathVariable String from,@PathVariable String to){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getSectorPrice(sId,from,to));
    }
}
