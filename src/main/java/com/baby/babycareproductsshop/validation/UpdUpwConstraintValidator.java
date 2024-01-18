package com.baby.babycareproductsshop.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UpdUpwConstraintValidator implements ConstraintValidator<UpdUpwConstraint, String> {
    @Override
    public boolean isValid(String upw, ConstraintValidatorContext context){
        String regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&#~_-])[A-Za-z\\d@$!%*?&#.~_-]{8,16}";
        return upw.isEmpty() || Pattern.matches(upw, regexp);
    }
}
