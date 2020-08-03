package com.example.aniruddha.stock.Sector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.aniruddha.stock.Sector.model.Company;
import com.example.aniruddha.stock.Sector.model.Sector;

import java.util.List;

public interface SectorsRepo extends JpaRepository<Sector,Long> {
    public List<Sector> getAllBySectorId(String sectorId);

}
