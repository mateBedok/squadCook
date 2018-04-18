package com.mate.bedok.squadCook.Utils;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {

    private Validator() {
    }

    public boolean validateRegistration(Map<String, String> regData, Map<String, String> res) {
        if (regData != null) {
            boolean validUserName = validateUsername(regData.get("userName"));
            boolean validPassword = validatePassword(regData.get("password"));
            boolean validFirstName = validateFirstName(regData.get("firstName"), res);
            boolean validLastName = validateLastName(regData.get("lastName"), res);
            boolean validEmail = validateEMailAddress(regData.get("email"), res);
            boolean validPhoneNumber = validatePhoneNumber(regData.get("phoneNumber"), res);
            return validEmail && validFirstName && validLastName && validUserName && validPassword && validPhoneNumber;
         }
         return false;
    }

    public boolean validateLogin(Map<String, String> loginData) {
        if (loginData != null) {
            boolean validUserName = validateUsername(loginData.get("logUserName"));
            boolean validPassword = validatePassword(loginData.get("password"));
            return validPassword && validUserName;
        }
        return false;
    }


    private boolean validateFirstName(String firstName, Map<String, String> res) {
        Pattern firstNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher firstNameMatcher = firstNamePattern.matcher(firstName);
        if (!firstNameMatcher.find()) {
            res.put("firstName", "Invalid first name.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateLastName(String lastName, Map<String, String> res) {
        Pattern lastNamePattern = Pattern.compile("^[A-Za-z]+$");
        Matcher lastNameMatcher = lastNamePattern.matcher(lastName);
        if (!lastNameMatcher.find()) {
            res.put("lastName", "Invalid last name.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validateUsername(String username) {
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
        return usernameMatcher.find();
    }

    private boolean validateEMailAddress(String eMailAddress, Map<String, String> res){
        Pattern eMailPattern = Pattern.compile("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)");
        Matcher eMailMatcher = eMailPattern.matcher(eMailAddress);
        if (!eMailMatcher.find()) {
            res.put("email", "Invalid e-mail address.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePhoneNumber(String phoneNumber, Map<String, String> res){
        Pattern numberPattern = Pattern.compile("^[?0-9]+[0-9]+$");
        Matcher numberMatcher = numberPattern.matcher(phoneNumber);
        if (!numberMatcher.find()) {
            res.put("phoneNumber", "Invalid phone number.");
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password){
        Pattern passwordPattern = Pattern.compile("^[^_!?$ß*>;.]{5,}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);
        return passwordMatcher.find();
    }
}
