package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.service.dtos.template.DiscountTempDTO;
import com.ftn.sbnz.service.dtos.template.ServiceTempDTO;

public interface ITemplateService {
    void createServiceRulesFromTemplate(ServiceTempDTO dto);

    void createDiscountRulesFromTemplate(DiscountTempDTO dto);
}
