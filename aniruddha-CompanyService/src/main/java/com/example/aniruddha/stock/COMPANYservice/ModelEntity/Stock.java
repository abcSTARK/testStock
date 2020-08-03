package com.example.aniruddha.stock.COMPANYservice.ModelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int cCode;
    private double price;
    private String stockExchange;
    private Date date;

}
