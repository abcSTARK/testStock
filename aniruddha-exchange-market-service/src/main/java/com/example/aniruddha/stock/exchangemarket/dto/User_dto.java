package com.example.aniruddha.stock.exchangemarket.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_dto {

	private String username;
	private String password;
	private String userType;//(if Admin or normal User)
	private String email;
	private long mobileNumber;
	private int confirmed;


}
