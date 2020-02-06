package com.lv339.service.validation;

import java.time.LocalDate;

public class DateValidation {

    static public boolean isOk(LocalDate date) {
        boolean isOk = false;

        if (date.isAfter(LocalDate.now()) && date.isBefore(LocalDate.now().plusYears(10))) {
            isOk = true;
        }

        return isOk;
    }

}
