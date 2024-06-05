package com.ftn.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {

     public static <T> List<T> getListDiff(List<T> bigger, List<T> lesser){
        Set<T> set1 = bigger.stream().collect(Collectors.toSet());
        Set<T> set2 = lesser.stream().collect(Collectors.toSet());

        set1.removeAll(set2);
        return set1.stream().collect(Collectors.toList());
    }
    
    public static Date localToDate(LocalDateTime lt){
        ZonedDateTime zdt = lt.atZone(ZoneId.systemDefault());
        Date output = Date.from(zdt.toInstant());
        return output;
    }
}
