package com.example.aniruddha.stock.COMPANYservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Stock;

import javax.xml.crypto.Data;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<Stock,Long> {
    public List<Stock> findAllByCompanyCodeAndDateBetween(int companyCode, Date from, Date to);
}
