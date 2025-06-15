package com.example.memorydatabase.user.model;

import com.example.memorydatabase.entity.Entity;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {

	private String name;
	private int score;
}