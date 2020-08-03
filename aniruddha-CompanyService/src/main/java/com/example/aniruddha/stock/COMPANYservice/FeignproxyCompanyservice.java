package com.example.aniruddha.stock.COMPANYservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.aniruddha.stock.COMPANYservice.dto.Companydto;
import com.example.aniruddha.stock.COMPANYservice.dto.Ipodto;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@FeignClient(name="aniruddha-zullproxy")
public interface FeignproxyCompanyservice {

    @RequestMapping(value = "/company/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Companydto>> getAllCompanyDetails();

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    public ResponseEntity<Optional<Companydto>> addCompany(@RequestBody Companydto companyDTO);

    @RequestMapping(value = "/company/companyCode/{cCode}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Companydto>> getCompanyByCompanyCode(@PathVariable(value = "cCode") int cCode);

    @RequestMapping(value = "/company/regex/{regex}", method = RequestMethod.GET)
    public ResponseEntity<List<Companydto>> getCompanyByRegex(@PathVariable(value = "regex" ) String regex);

    @RequestMapping(value = "/company/stock/{cCode}/{from}/{to}")
    public ResponseEntity<Double> getCompanyStockPrice(@PathVariable(value = "cCode") int companyCode,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to) throws ParseException ;

    @RequestMapping(value = "/company/ipo/{cName}")
    public ResponseEntity<Optional<Ipodto>> getIpoDetails(@PathVariable(value = "cName") String cName);
}