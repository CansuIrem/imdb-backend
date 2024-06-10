package com.irem.imdbbackend.core.helper;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {

    public static BigInteger getDateTimeNow() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return new BigInteger(LocalDateTime.now().format(formatter));
    }
}
