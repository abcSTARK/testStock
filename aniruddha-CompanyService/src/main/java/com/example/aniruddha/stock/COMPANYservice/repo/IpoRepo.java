package com.example.aniruddha.stock.COMPANYservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aniruddha.stock.COMPANYservice.ModelEntity.IpoDetails;

@Repository
public interface IpoRepo extends JpaRepository<IpoDetails,Long> {
    public IpoDetails findByCompanyName(String cName);
}
