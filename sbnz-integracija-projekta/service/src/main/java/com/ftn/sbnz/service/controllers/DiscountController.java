package com.ftn.sbnz.service.controllers;


import com.ftn.sbnz.model.models.Discount;
import com.ftn.sbnz.service.repositories.IDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    @Autowired
    IDiscountRepository discountRepository;

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> add() {
        Discount d = new Discount(10.0);
        discountRepository.save(new Discount(10.0));
        discountRepository.flush();
        System.out.println(d.getId());
        return new ResponseEntity<Discount>(new Discount(1.0), HttpStatus.OK);
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get() {
        List<Discount> dd = discountRepository.findAll();
        for (Discount d:dd) {
            System.out.println(d.getId());
        }
        return new ResponseEntity<Discount>(new Discount(1.0), HttpStatus.OK);
    }

}
