package net.devstudy.resume.validator;

import net.devstudy.resume.annotation.constraints.FieldsMatch;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldsMatchConstraintValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String field1;
    private String field2;


    @Override
    public void initialize(FieldsMatch constraintAnnotation) {
        this.field1 = constraintAnnotation.field1();
        this.field2 = constraintAnnotation.field2();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String field1Value = (String) new BeanWrapperImpl(value).getPropertyValue(field1);
        String field2Value = (String) new BeanWrapperImpl(value).getPropertyValue(field2);
        if (!field1Value.equals(field2Value)){
            return false;
        }
        return true;
    }


}
