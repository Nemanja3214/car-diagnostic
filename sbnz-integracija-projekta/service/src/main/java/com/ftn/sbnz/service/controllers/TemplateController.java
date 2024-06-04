package com.ftn.sbnz.service.controllers;

import com.ftn.sbnz.service.dtos.template.DiscountTempDTO;
import com.ftn.sbnz.service.dtos.template.ServiceTempDTO;
import com.ftn.sbnz.service.services.interfaces.ITemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@CrossOrigin
@RestController
@RequestMapping("/api/template")
public class TemplateController {

    @Autowired
    ITemplateService templateService;

    @PermitAll
    @PostMapping("/create/service")
    public ResponseEntity<?> createService(@RequestBody ServiceTempDTO dto) {
        templateService.createServiceRulesFromTemplate(dto);
        return ResponseEntity.noContent().build();
    }

    @PermitAll
    @PostMapping("/create/discount")
    public ResponseEntity<?> createDiscount(@RequestBody DiscountTempDTO dto) {
        templateService.createDiscountRulesFromTemplate(dto);
        return ResponseEntity.noContent().build();
    }
}
