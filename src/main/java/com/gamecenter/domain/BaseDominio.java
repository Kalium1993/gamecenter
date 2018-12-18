package com.gamecenter.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.MappedSuperclass;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang3.StringUtils;



@MappedSuperclass
abstract class BaseDominio {
	public void validarDominio() {
		Configuration<?> config = Validation.byDefaultProvider().configure();
		ValidatorFactory factory = config.buildValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<BaseDominio>> violations = validator.validate(this);

		Set<String> violationMessages = new HashSet<>();

		for (ConstraintViolation<BaseDominio> constraintViolation : violations) {
			String campo = StringUtils.capitalize(constraintViolation.getPropertyPath().toString());
			String msg = constraintViolation.getMessage();
			violationMessages.add(campo.concat(" : ").concat(msg));
		}

		if (!violationMessages.isEmpty()) {
			throw new DominioInvalidoException(StringUtils.join(violationMessages, " \n "));
		}
	}
}
