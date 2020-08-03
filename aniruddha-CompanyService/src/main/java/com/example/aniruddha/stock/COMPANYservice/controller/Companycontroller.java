package com.example.aniruddha.stock.COMPANYservice.controller;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Company;
import com.example.aniruddha.stock.COMPANYservice.dto.Companydto;
import com.example.aniruddha.stock.COMPANYservice.dto.Ipodto;
import com.example.aniruddha.stock.COMPANYservice.service.CompanyService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class Companycontroller {

    @Autowired
    CompanyService service;

    //TO GET ALL COMPANIES
    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Companydto>> getAllCompanyDetails()
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAllCompanies());
    }
  
    //TO ADD COMPANIES
    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<Optional<Companydto>> addCompany(@RequestBody Companydto cDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCompany(cDTO));
    }

  
    //TO GET BY COMPANY ID
    @RequestMapping(value = "/company/companyCode/{companyCode}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Companydto>> getCompanyByCompanyCode(@PathVariable int cCode){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompanyByCompanyCode(cCode));
    }

    //TO GET BY COMPANY REG
    @RequestMapping(value = "/company/regex/{regex}", method = RequestMethod.GET)
    public ResponseEntity<List<Companydto>> getCompanyByRegex(@PathVariable String reg){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompanyByRegex(reg));
    }

    //TO GET ALL STOCK FROM COMPANIES
    @RequestMapping(value = "/company/stock/{cCode}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable int cCode,@PathVariable String from,@PathVariable String to) throws ParseException {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getCompanyStockPrice(cCode,from,to));
    }

    //TO GET BY COMPANY NAME
    @RequestMapping(value = "/company/ipo/{cName}")
    public ResponseEntity<Optional<Ipodto>> getIpoDetails(@PathVariable String cName)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getIpoDetails(cName));
    }

}
