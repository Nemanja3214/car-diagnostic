package com.ftn.util;

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
    
}
