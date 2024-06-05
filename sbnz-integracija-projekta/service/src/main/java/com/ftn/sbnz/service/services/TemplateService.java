package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Car;
import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.repairment.RepairmentDTO;
import com.ftn.sbnz.service.dtos.template.DiscountTempDTO;
import com.ftn.sbnz.service.dtos.template.ServiceTempDTO;
import com.ftn.sbnz.service.repositories.ICarRepository;
import com.ftn.sbnz.service.services.interfaces.ITemplateService;
import com.ftn.util.Util;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.drools.template.DataProvider;
import org.drools.template.ObjectDataCompiler;
import org.drools.template.objects.ArrayDataProvider;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@Service
public class TemplateService implements ITemplateService {

    public KieSession serviceKsession;
    public KieSession discountKsession;

    @Autowired
    ICarRepository allCars;

    @Override
    public void createServiceRulesFromTemplate(ServiceTempDTO dto) {
        InputStream template = null;
        try {
            template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\services.drt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        DataProvider data = new ArrayDataProvider(new String[][]{
                new String[]{dto.getSmallService(), dto.getBigService(), dto.getBrakes(), dto.getTires()}
        });

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);

        System.out.println(drl);

        serviceKsession = createKieSessionFromDRL(drl);

//        Car car = new Car();
//        List<Repairment> rrs = new ArrayList<>();
//        car.setRepairments(rrs);
//        car.setKm(45000);
//        FactHandle fh = serviceKsession.insert(car);
//        System.out.println(car.getRepairments().size());
//        serviceKsession.fireAllRules();
//        System.out.println(car.getRepairments().size());
//        car.setKm(80000);
//        serviceKsession.update(fh, car);
//        serviceKsession.fireAllRules();
//        System.out.println(car.getRepairments().size());
//        car.setKm(180000);
//        serviceKsession.update(fh, car);
//        serviceKsession.fireAllRules();
//        System.out.println(car.getRepairments().size());
//        car.setKm(36000);
//        serviceKsession.update(fh, car);
//        serviceKsession.fireAllRules();
//        System.out.println(car.getRepairments().size());
    }

    @Override
    public void createDiscountRulesFromTemplate(DiscountTempDTO dto) {
        InputStream template = null;
        try {
            template = new FileInputStream("D:\\Fax\\SIIT-8.Sem\\SBZ\\car-diagnostic\\sbnz-integracija-projekta\\kjar\\src\\main\\resources\\rules\\templatable\\services.drt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        DataProvider data = new ArrayDataProvider(new String[][]{
                new String[]{dto.getLower(), dto.getUpper()}
        });

        ObjectDataCompiler converter = new ObjectDataCompiler();
        String drl = converter.compile(data, template);

        System.out.println(drl);

        serviceKsession = createKieSessionFromDRL(drl);
    }

    @Override
    public List<RepairmentDTO> checkForService(Integer carId, double km) {
        Car car = allCars.findById(carId).get();
        car.setKm(km);

        if (this.serviceKsession == null) {
            this.createServiceRulesFromTemplate(new ServiceTempDTO("15000", "90000",
                    "40000", "18000"));
        }

        List<Repairment> previous = this.serviceKsession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .toList();

        this.serviceKsession.insert(car);
        int ruleCount = this.serviceKsession.fireAllRules();
        System.out.println(ruleCount);

        this.serviceKsession.halt();
         List<Repairment> after = this.serviceKsession.getObjects().stream()
        .filter(r -> r instanceof Repairment)
        .map(r -> (Repairment) r)
        .toList();

        // after - previous
        return Util.getListDiff(after, previous).stream().map(r -> new RepairmentDTO(r)).toList();
    }

    @Override
    public List<Repairment> checkDiscount(List<Repairment> repairments) {
        if (this.discountKsession == null) {
            this.createDiscountRulesFromTemplate(new DiscountTempDTO("100", "200"));
        }

        this.discountKsession.insert(repairments);
        int ruleCount = this.discountKsession.fireAllRules();
        System.out.println(ruleCount);

        // after - previous
        return repairments;

    }

    private KieSession createKieSessionFromDRL(String drl){
         KieHelper kieHelper = new KieHelper();
         kieHelper.addContent(drl, ResourceType.DRL);

         Results results = kieHelper.verify();

         if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
             List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
             for (Message message : messages) {
                 System.out.println("Error: "+message.getText());
             }

             throw new IllegalStateException("Compilation errors were found. Check the logs.");
         }

         return kieHelper.build().newKieSession();
     }
}
