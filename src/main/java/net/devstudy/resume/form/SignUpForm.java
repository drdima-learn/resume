package net.devstudy.resume.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.annotation.constraints.FieldsMatch;

import javax.validation.Valid;

@Getter @Setter @ToString @NoArgsConstructor
@FieldsMatch(field1 = "password", field2 = "confirmPassword", message = "from SignUpForm pass not match")
public class SignUpForm {

    @EnglishLanguage(withNumbers = false, withPunctuations = false, withSpechSymbols = false)
    private String firstName;

    @EnglishLanguage(withNumbers = false, withPunctuations = false, withSpechSymbols = false)
    private String lastName;


    private String password;


    private String confirmPassword;

}
