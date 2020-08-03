package com.example.aniruddha.stock.COMPANYservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto {

	private String uname;
	private String upassword;
	private String uType;
	private String uemail;
	private long uNumber;
	private int con;

}
