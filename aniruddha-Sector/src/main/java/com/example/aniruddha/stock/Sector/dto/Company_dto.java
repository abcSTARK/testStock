package com.example.aniruddha.stock.Sector.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company_dto {
    private int cCode;
    private String cName;
	private long turnover;
	private String ceo;
	private String bod;
	private String sector;
	private String brief;
	private String sCode;
}
