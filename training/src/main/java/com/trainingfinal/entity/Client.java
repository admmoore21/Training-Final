package com.trainingfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {
	private Long clientId;
	private String firstName;
	private String lastName;
	private String phone;
	private Proficiency proficiency;

}
