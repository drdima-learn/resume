package net.devstudy.resume.annotation.constraints;

import net.devstudy.resume.validator.FieldsMatchConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {FieldsMatchConstraintValidator.class})
@Documented
public @interface FieldsMatch {

    String message() default "FieldsMatch";

    Class<?>[] groups() default {};

    String first();

    String second();

    Class<? extends Payload>[] payload() default {};


    /**
     * Defines several <code>@FieldMatch</code> annotations on the same element
     *
     * @see FieldsMatch
     */
    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldsMatch[] value();
    }
}
