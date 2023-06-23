package com.example.hrms_msil;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

static boolean isValidEmail(String email)
{
    return email.contains("@marketsimplified.com");
}
static boolean isValidmPin(String mPin){
        Pattern p = Pattern.compile("^[0-9]{6}$");//. represents single character
        Matcher m = p.matcher(mPin);
        boolean b = m.matches();
        return b;

    }
}

