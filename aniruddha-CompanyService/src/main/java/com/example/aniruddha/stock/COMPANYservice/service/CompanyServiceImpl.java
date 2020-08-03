package com.example.aniruddha.stock.COMPANYservice.service;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Company;
import com.example.aniruddha.stock.COMPANYservice.ModelEntity.IpoDetails;
import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Stock;
import com.example.aniruddha.stock.COMPANYservice.dto.Companydto;
import com.example.aniruddha.stock.COMPANYservice.dto.Ipodto;
import com.example.aniruddha.stock.COMPANYservice.repo.companyRepo;
import com.example.aniruddha.stock.COMPANYservice.repo.IpoRepo;
import com.example.aniruddha.stock.COMPANYservice.repo.StockRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@EnableTransactionManagement
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    companyRepo cRepo;
    @Autowired
    StockRepo stockRepo;
    @Autowired
    IpoRepo ipoRepo;

    @Override
    @Transactional
    public Iterable<Companydto> getAllCompanies()
    {
        List<Company> cList = cRepo.findAll();
        
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        Type listType = new TypeToken<Iterable<Companydto>>(){}.getType();
        Iterable<Companydto> DtoList = modelMapper.map(cList,listType);
        
        return DtoList;
    }

    @Override
    @Transactional
    public Optional<Companydto> addCompany(Companydto cDTO){
        Company company = new Company();
        
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(cDTO,company);
        
        cRepo.save(company);
        
        return Optional.of(cDTO);
    }

    @Override
    @Transactional
    public Optional<Companydto> getCompanyByCompanyCode(int cCode)
    {
        Company company = cRepo.findByCompanyCode(cCode);
        
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Companydto cDTO = new Companydto();
        
        modelMapper.map(company,cDTO);
        
        return Optional.of(cDTO);
    }

    @Override
    @Transactional
    public List<Companydto> getCompanyByRegex(String reg)
    {
        List<Company> companyList  = cRepo.findByCompanyNameContaining(reg);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Companydto>>(){}.getType();
        List<Companydto> DtoList = modelMapper.map(companyList,listType);
        return DtoList;
    }

    @Override
    @Transactional
    public double getCompanyStockPrice(int cCode, String from, String to) throws ParseException {
        List<Stock> list = stockRepo.findAllByCompanyCodeAndDateBetween(cCode, Date.valueOf(from),Date.valueOf(to));
        
        double x = 0.0;
        for(int i=0;i<list.size();i++)
        {
            x = x + list.get(i).getPrice();
        }
        x = x / list.size();
        return x;
    }


    @Override
    @Transactional
    public Optional<Ipodto> getIpoDetails(String cName)
    {
        IpoDetails ipoDetails = ipoRepo.findByCompanyName(cName);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ipodto ipoDetailsDTO = new Ipodto();
        modelMapper.map(ipoDetails,ipoDetailsDTO);
        return Optional.of(ipoDetailsDTO);
    }
}
