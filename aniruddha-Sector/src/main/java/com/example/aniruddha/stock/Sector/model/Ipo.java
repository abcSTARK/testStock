package com.example.aniruddha.stock.Sector.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ipo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String cName;
    private String stockExchange;
	private double pShare;
	private int totalShares;
	private Date openDT;
	private String remarks;

}
