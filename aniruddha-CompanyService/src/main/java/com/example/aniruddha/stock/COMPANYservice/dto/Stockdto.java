package com.example.aniruddha.stock.COMPANYservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stockdto {

    private int cCode;
    private double price;
    private String stockExchange;
    private Date date;
}
