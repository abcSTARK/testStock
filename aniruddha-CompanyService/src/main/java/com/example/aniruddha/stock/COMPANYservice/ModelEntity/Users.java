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
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String uname;
	private String upassword;
	private String uType;
	private String uemail;
	private long uNumber;
	private int con;


}
