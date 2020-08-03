package com.example.aniruddha.stock.Sector;

import brave.sampler.Sampler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.aniruddha.stock.Sector.model.Company;
import com.example.aniruddha.stock.Sector.model.Ipo;
import com.example.aniruddha.stock.Sector.model.Sector;
import com.example.aniruddha.stock.Sector.model.Stock;
import com.example.aniruddha.stock.Sector.repository.CompanyRepo;
import com.example.aniruddha.stock.Sector.repository.SectorsRepo;
import com.example.aniruddha.stock.Sector.repository.StockRepo;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication


@EnableFeignClients("com.example.aniruddha.stock.Sector")
@EnableDiscoveryClient

public class SectorApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SectorApplication.class, args);
	}

	

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}