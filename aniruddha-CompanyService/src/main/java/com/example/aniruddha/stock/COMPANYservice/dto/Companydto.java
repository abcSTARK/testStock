package com.example.aniruddha.stock.COMPANYservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companydto {
    private int cCode;
    private String cName;
	private long turnover;
	private String ceo;
	private String BOD;
	private String sector;
	private String brief;
	private String sCode;
    
}
