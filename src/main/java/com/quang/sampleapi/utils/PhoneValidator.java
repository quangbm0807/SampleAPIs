package com.quang.sampleapi.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class PhoneValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public void initialize(PhoneNumber phoneNumberNo) {
    }

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext cxt) {
        if (phoneNo == null) {
            return false;
        }
        if (phoneNo.matches("\\d{10}")) return true;
        else if (phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
        else //return false if nothing matches the input
            if (phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            else return phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}");
    }

}
