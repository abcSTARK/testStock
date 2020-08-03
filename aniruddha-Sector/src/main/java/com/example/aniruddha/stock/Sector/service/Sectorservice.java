package com.example.aniruddha.stock.Sector.service;

import java.util.List;

import com.example.aniruddha.stock.Sector.dto.Company_dto;
import com.example.aniruddha.stock.Sector.model.Sector;

public interface Sectorservice {
    public List<Company_dto> getListOfCompaniesInSector(String s);
    public double getSectorPrice(String sId, String from, String to);
}
