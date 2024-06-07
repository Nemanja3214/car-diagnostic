package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.model.models.Breakdown;
import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.dtos.template.DiscountTempDTO;
import com.ftn.sbnz.service.dtos.template.ServiceTempDTO;

import java.util.List;

public interface ITemplateService {
    void createServiceRulesFromTemplate(ServiceTempDTO dto);

    void createDiscountRulesFromTemplate(DiscountTempDTO dto);

    List<RepairmentDTO> checkForService(Integer carId, double km);

    List<Repairment> checkDiscount(Car car, List<Repairment> repairments, Breakdown breakdown);
}
