package com.ftn.sbnz.service.dtos.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTempDTO {
    private String smallService;
    private String bigService;
    private String brakes;
    private String tires;
}
