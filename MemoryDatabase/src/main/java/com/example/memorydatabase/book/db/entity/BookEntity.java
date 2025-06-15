package com.example.memorydatabase.book.db.entity;

import lombok.*;
import java.math.BigDecimal;
import com.example.memorydatabase.entity.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends Entity {
	private String name;
	private String category;
	private BigDecimal amount;
}
