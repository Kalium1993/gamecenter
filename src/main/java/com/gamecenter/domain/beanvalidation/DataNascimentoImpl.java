package com.gamecenter.domain.beanvalidation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataNascimentoImpl implements ConstraintValidator<DataNascimento, LocalDate> {

	@Override
    public boolean isValid(LocalDate dataNascimento, ConstraintValidatorContext constraintValidatorContext) {
        if ( dataNascimento == null ) {
            return true;
        }
        LocalDate today = LocalDate.now();
        return dataNascimento.isBefore(today);
    }
}
