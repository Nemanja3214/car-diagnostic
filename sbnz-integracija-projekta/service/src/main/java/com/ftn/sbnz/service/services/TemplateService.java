package com.ftn.sbnz.service.services;

import com.ftn.sbnz.service.services.interfaces.ITemplateService;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService implements ITemplateService {

//    private KieSession createKieSessionFromDRL(String drl, KieSession existingSession){
//         KieHelper kieHelper = new KieHelper();
//         kieHelper.addContent(drl, ResourceType.DRL);
//
//         Results results = kieHelper.verify();
//
//         if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)){
//             List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
//             for (Message message : messages) {
//                 System.out.println("Error: "+message.getText());
//             }
//
//             throw new IllegalStateException("Compilation errors were found. Check the logs.");
//         }
//
//         KieBase originalKieBase = existingSession.getKieBase();
//         kieHelper.build().getKiePackages().forEach(originalKieBase::addPackage);
//
//        // Create a new KieBase that includes the original and new KiePackages
//         KieBase newKieBase = kieHelper.build();
//
//        // Dispose of the existing session and create a new one from the new KieBase
//         existingSession.dispose();
//         KieSession newSession = newKieBase.newKieSession();
//
//         return newSession;
//    }
}
