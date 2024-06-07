package com.ftn.sbnz.service.dtos.breakdown;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomsDTO {
    List<String> symptoms;
    
}
