package com.example.memorydatabase.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public abstract class Entity implements PrimaryKey{

	@Getter
	@Setter
	private Long id;
}