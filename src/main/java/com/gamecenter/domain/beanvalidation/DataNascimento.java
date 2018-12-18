package com.gamecenter.domain.beanvalidation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DataNascimentoImpl.class)
public @interface DataNascimento {

	String message() default "Data não pode ser maior que a data atual.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
