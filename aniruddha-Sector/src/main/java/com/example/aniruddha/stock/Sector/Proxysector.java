package com.example.aniruddha.stock.Sector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.aniruddha.stock.Sector.dto.Company_dto;

import java.util.List;

@FeignClient(name="aniruddha-zullproxy")
public interface Proxysector {
    @RequestMapping("/sector/listCompanies/{s}")
    public ResponseEntity<List<Company_dto>> getListOfCompaniesInSector(@PathVariable(value = "s") String s);

    @RequestMapping("/sector/price/{sId}/from/{from}/to/{to}")
    public ResponseEntity<Double> getSectorPrice(@PathVariable(value = "sId") String sectorId,@PathVariable(value = "from") String from,@PathVariable(value = "to") String to);
}
