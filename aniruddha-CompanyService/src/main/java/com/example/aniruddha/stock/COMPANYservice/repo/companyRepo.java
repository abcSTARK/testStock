package com.example.aniruddha.stock.COMPANYservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Company;

import java.util.List;

@Repository
public interface companyRepo extends JpaRepository<Company,Long> {
    public Company findByCompanyCode(int cCode);
    public List<Company> findByCompanyNameContaining(String reg);
}
