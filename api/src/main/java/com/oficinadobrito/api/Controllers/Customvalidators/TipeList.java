package com.oficinadobrito.api.Controllers.Customvalidators;

import com.oficinadobrito.api.Controllers.Customvalidators.Classes.TipeListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TipeListValidator.class)
public @interface TipeList {
    String message() default "The list not is Empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
}
