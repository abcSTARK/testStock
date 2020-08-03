package com.example.aniruddha.stock.COMPANYservice;



import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Company;
import com.example.aniruddha.stock.COMPANYservice.ModelEntity.IpoDetails;
import com.example.aniruddha.stock.COMPANYservice.ModelEntity.Stock;
import com.example.aniruddha.stock.COMPANYservice.repo.companyRepo;
import com.example.aniruddha.stock.COMPANYservice.repo.IpoRepo;
import com.example.aniruddha.stock.COMPANYservice.repo.StockRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients("com.example.stock.exchange.companydataservice")
@EnableDiscoveryClient
public class CompanyserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(CompanyserviceApplication.class, args);
	}

}
