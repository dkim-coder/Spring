package com.ssafy.ws.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
	private String email;
	private String name;
	private String password;
	private String recId;
	
   @Builder
	public User(String email, String name, String password) {
		this(email, name, password, null);
	}

	
	
}
