package com.example.aniruddha.stock.Sector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.aniruddha.stock.Sector.model.Stock;

import java.sql.Date;
import java.util.List;

public interface StockRepo extends JpaRepository<Stock,Long> {
    @Query(value = "SELECT * FROM STOCK_PRICE s WHERE s.company_code IN (:companyCode) AND s.date BETWEEN (:fromDate) AND (:toDate)",
            nativeQuery = true)
    public List<Stock> getAll(@Param("companyCode")List<Integer> companyCode, @Param("fromDate")Date fromDate,@Param("toDate")Date toDate);
}
