package net.devstudy.resume.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.devstudy.resume.annotation.EnableFormErrorConvertation;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.annotation.constraints.FieldsMatch;

@Getter @Setter @ToString @NoArgsConstructor
@FieldsMatch(first = "password", second = "confirmPassword", message = "from SignUpForm pass not match")
@EnableFormErrorConvertation(
        forName = "signUpForm"
        ,fieldReference = "confirmPassword"
        ,validationAnnotationClass = FieldsMatch.class
        //,validationAnnotationClass = EnglishLanguage.class
)
public class SignUpForm {

    @EnglishLanguage(withNumbers = false, withPunctuations = false, withSpechSymbols = false)
    private String firstName;

    @EnglishLanguage(withNumbers = false, withPunctuations = false, withSpechSymbols = false)
    private String lastName;


    private String password;


    private String confirmPassword;

}
