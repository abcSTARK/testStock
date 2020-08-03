package com.example.aniruddha.stock.Sector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ipo_dto {

	private String cName;
    private String stockExchange;
	private double pShare;
	private int totalShares;
	private Date openDT;
	private String remarks;

}
