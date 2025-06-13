package com.example.validation.annotation;

import com.example.validation.validator.YearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = { YearMonthValidator.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface YearMonth {
	String message() default "year month 안맞음";
	String pattern() default "yyyyMM";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
