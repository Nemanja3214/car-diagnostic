package com.ftn.sbnz.service.services;

import com.ftn.sbnz.model.models.Repairment;
import com.ftn.sbnz.service.dtos.template.ServiceTempDTO;
import com.ftn.sbnz.service.services.interfaces.ITemplateService;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;
import org.drools.template.DataProvider;
import org.drools.template.ObjectDataCompiler;
import org.drools.template.objects.ArrayDataProvider;

import com.ftn.sbnz.model.models.Car;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService implements ITemplateService {

    public KieSession serviceKsession;

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
