package net.devstudy.resume.util;

import net.devstudy.resume.form.SignUpForm;
import org.apache.commons.lang.WordUtils;

import java.util.Random;

public class DataUtil {

    private static final String UID_DELIMITER = "-";

    public static String capitalizeName(String name){
        return WordUtils.capitalize(name);
    }


    public static String generateProfileUid(SignUpForm signUpForm) {
        String firstName = signUpForm.getFirstName().trim().toLowerCase();
        String lastName = signUpForm.getLastName().trim().toLowerCase();
        return firstName + UID_DELIMITER + lastName;

    }


    public static String addSuffix(String uid) {
        Random random = new Random();
        int randomNumber = random.nextInt(5)+1;
        return uid + randomNumber;
    }
}
