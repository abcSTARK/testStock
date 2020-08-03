package com.example.aniruddha.stock.Sector.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aniruddha.stock.Sector.model.Company;

import java.util.List;

public interface CompanyRepo extends JpaRepository<Company,Long> {
    public List<Company> getAllBySector(String sector);
}
