package com.example.aniruddha.stock.COMPANYservice.service;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Company;
import com.example.aniruddha.stock.COMPANYservice.dto.Companydto;
import com.example.aniruddha.stock.COMPANYservice.dto.Ipodto;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Iterable<Companydto> getAllCompanies();
    public Optional<Companydto> addCompany(Companydto companyDTO);
    public Optional<Companydto> getCompanyByCompanyCode(int companyCode);
    public List<Companydto> getCompanyByRegex(String regex);
    public double getCompanyStockPrice(int companyCode, String from, String to) throws ParseException;
    public Optional<Ipodto> getIpoDetails(String companyName);
}
