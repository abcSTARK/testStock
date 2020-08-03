package com.example.aniruddha.stock.Sector.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aniruddha.stock.Sector.dto.Company_dto;
import com.example.aniruddha.stock.Sector.model.Company;
import com.example.aniruddha.stock.Sector.model.Sector;
import com.example.aniruddha.stock.Sector.model.Stock;
import com.example.aniruddha.stock.Sector.repository.CompanyRepo;
import com.example.aniruddha.stock.Sector.repository.SectorsRepo;
import com.example.aniruddha.stock.Sector.repository.StockRepo;

import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SectorsIMPL implements Sectorservice {
    @Autowired
    SectorsRepo sRepo;
    @Autowired
    CompanyRepo cRepo;
    @Autowired
    StockRepo spRepo;

    @Override
    @Transactional
    public List<Company_dto> getListOfCompaniesInSector(String s){
        List<Company> cList = cRepo.getAllBySector(s);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<Iterable<Company_dto>>(){}.getType();
        List<Company_dto> DtoList = modelMapper.map(cList,listType);
        return DtoList;
    }

    @Override
    @Transactional
    public double getSectorPrice(String sectorId, String from, String to){
        List<Sector> list = sRepo.getAllBySectorId(sectorId);
        String sName= list.get(0).getSector();
       
        List<Company> companyList = cRepo.getAllBySector(sName);
        List<Integer> companyCodeList =new ArrayList<>(){};
        for (Company company:companyList) {
            companyCodeList.add(company.getCCode());
        }
        List<Stock> stockP = spRepo.getAll(companyCodeList, Date.valueOf(from), Date.valueOf(to));
        
        double x = 0.0;
        for(int i=0;i<stockP.size();i++)
        {
            x = x + stockP.get(i).getPrice();
        }
        x = x / stockP.size();
        return x;
    }
}
