package com.example.aniruddha.stock.COMPANYservice.ModelEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sectors {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int cCode;
    private String sId;
    private String sector;

}
