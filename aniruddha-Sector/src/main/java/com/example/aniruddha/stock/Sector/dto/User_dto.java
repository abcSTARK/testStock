package com.example.aniruddha.stock.Sector.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_dto {

	private String username;
	private String password;
	private String uType;
	private String uemail;
	private long umobileNumber;
	private int confirmed;


}
