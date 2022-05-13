package net.devstudy.resume.component.impl;

import net.devstudy.resume.annotation.EnableFormErrorConvertation;
import net.devstudy.resume.component.FormErrorConverter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class FormErrorConverterImpl implements FormErrorConverter {
    @Override
    public void convertFormErrorToFieldError(@Nonnull Class<? extends Annotation> validationAnnotationClass, @Nonnull Object formInstance, @Nonnull BindingResult bindingResult) {
        Annotation validationAnnotation = findValidationAnnotation(validationAnnotationClass, formInstance);
        List<EnableFormErrorConvertation> metaAnnotations = findMetaAnnotations(formInstance);
        boolean found = false;
        for (EnableFormErrorConvertation metaAnnotation : metaAnnotations){
            if (metaAnnotation.validationAnnotationClass() == validationAnnotationClass){
//                processGlobalErrorConvertation(validationAnnotation, metaAnnotation, formInstance, bindingResult);
//                processFormFieldErrorConvertation(validationAnnotation, metaAnnotation, formInstance, bindingResult);
//                found = true;
//                break;
            }
        }
        if (!found){
            throw new IllegalArgumentException("validationAnnotationClass not found for EnableFormErrorConvertation annoattion: validationAnnotationClass=" + validationAnnotationClass
                    + ", formInstance=" + formInstance.getClass());
        }

    }

    private List<EnableFormErrorConvertation> findMetaAnnotations(Object formInstance) {
        EnableFormErrorConvertation metaAnnotation = findAnnotation(EnableFormErrorConvertation.class, formInstance);
        if (metaAnnotation!=null){
            return Collections.singletonList(metaAnnotation);
        }

        // not usable for now
        EnableFormErrorConvertation.List list = findAnnotation(EnableFormErrorConvertation.List.class, formInstance);
        if (list !=null){
            return Arrays.asList(list.value());
        }
        throw new IllegalArgumentException("metaAnnotation not found for formInstance" + formInstance.getClass());
    }

    private <T extends Annotation> T findAnnotation(Class<T> annotationClass, Object formInstance) {
        if (formInstance instanceof Iterable<?>){
            formInstance = ((Iterable<?>) formInstance).iterator().next();
        }
        Annotation annotation = AnnotationUtils.findAnnotation(formInstance.getClass(), annotationClass);
        return (T) annotation;
    }

    private Annotation findValidationAnnotation(Class<? extends Annotation> validationAnnotationClass, Object formInstance) {
        Annotation validationAnnotation = findAnnotation(validationAnnotationClass,formInstance);
        if (validationAnnotation==null){
            throw new IllegalArgumentException(
                    "validationAnnotationClass not found for formInstance: " +
                            "validationAnnotationClass=" + validationAnnotationClass
                            + ", formClass=" + formInstance.getClass()
            );
        }
        return validationAnnotation;
    }
}
