package com.example.aniruddha.stock.COMPANYservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ipodto {

	private String cName;
    private String stockExchange;
	private double pShare;
	private int totalShares;
	private Date openDT;
	private String Remarks;

}
