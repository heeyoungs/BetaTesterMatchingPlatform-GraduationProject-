package com.wisoft.io.testermatchingplatform.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation {

    public static boolean validPhoneNumber(String number) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
