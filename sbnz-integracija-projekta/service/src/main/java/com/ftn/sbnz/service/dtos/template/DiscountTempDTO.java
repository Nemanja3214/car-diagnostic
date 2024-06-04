package com.ftn.sbnz.service.dtos.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.api.definition.rule.All;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTempDTO {
    private String lower;
    private String upper;
}
