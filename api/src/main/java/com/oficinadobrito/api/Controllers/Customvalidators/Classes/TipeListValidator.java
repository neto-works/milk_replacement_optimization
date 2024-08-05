package com.oficinadobrito.api.Controllers.Customvalidators.Classes;

import com.oficinadobrito.api.Controllers.Customvalidators.TipeList;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class TipeListValidator implements ConstraintValidator<TipeList, List> {
    @Override
    public void initialize(TipeList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        return list != null && !list.isEmpty();
    }
}
