package com.example.aniruddha.stock.exchangemarket;

import brave.sampler.Sampler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.example.aniruddha.stock.exchangemarket.model.Ipo;
import com.example.aniruddha.stock.exchangemarket.model.Exchange;
import com.example.aniruddha.stock.exchangemarket.repository.IpoRepo;
import com.example.aniruddha.stock.exchangemarket.repository.ExchangeRepo;

import java.sql.Date;

@SpringBootApplication

@EnableFeignClients("com.example.stock.exchange.stockexchangedataservice")
@EnableDiscoveryClient
public class ExchangemarketApplication{


	public static void main(String[] args) {
		SpringApplication.run(ExchangemarketApplication.class, args);
	}

	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
