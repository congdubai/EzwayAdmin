package com.infoplus.ezway.EzwayAdmin.common;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtil {
    public static String getResponseTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.RESPONSE_TIME_PATTERN);
        return LocalDateTime.now().format(formatter);
    }
}
