package net.devstudy.resume.util;

import net.devstudy.resume.form.SignUpForm;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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

    public static Object readProperty(Object obj, String propertyName) {
        try{
            return BeanUtils.getPropertyDescriptor(obj.getClass(), propertyName).getReadMethod().invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("can't read property: " + propertyName + " from object: " + obj.getClass() + ": " + e.getMessage(), e);
        }

    }
}
