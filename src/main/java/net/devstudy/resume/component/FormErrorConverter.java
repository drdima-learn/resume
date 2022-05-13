package net.devstudy.resume.component;

import org.springframework.validation.BindingResult;

import javax.annotation.Nonnull;
import java.lang.annotation.Annotation;

public interface FormErrorConverter {
    void convertFormErrorToFieldError(
            @Nonnull Class<? extends Annotation> validationAnnotationClass,
            @Nonnull Object formInstance,
            @Nonnull BindingResult bindingResult
            );
}
