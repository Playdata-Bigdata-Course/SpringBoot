package io.playdata.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Member { 
	@Id 
	private String id; 
	private String password;
	private String name;
	private String role;
} 
