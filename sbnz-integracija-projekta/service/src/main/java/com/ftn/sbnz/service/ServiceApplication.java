package com.ftn.sbnz.service;

import java.io.File;
import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories("com.ftn.sbnz.*")
@ComponentScan(basePackages = { "com.ftn.sbnz.*" })
@EntityScan("com.ftn.sbnz.*")
public class ServiceApplication  {
	
	private static Logger log = LoggerFactory.getLogger(ServiceApplication.class);
	public static void main(String[] args) {
		//   System.out.println("CURRENT DIRECTORY: "+ new File(".").getAbsolutePath());
		ApplicationContext ctx = SpringApplication.run(ServiceApplication.class, args);
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//
//		StringBuilder sb = new StringBuilder("Application beans:\n");
//		for (String beanName : beanNames) {
//			sb.append(beanName + "\n");
//		}
//		log.info(sb.toString());
	}

	// @Bean
	// public KieContainer kieContainer() {
	// 	KieServices ks = KieServices.Factory.get();
	// 	KieContainer kContainer = ks
	// 			.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
	// 	// KieContainer kContainer = ks.getKieClasspathContainer(); 
	// 	// KieScanner kScanner = ks.newKieScanner(kContainer);
	// 	// kScanner.start(1000);
	// 	return kContainer;
	// }
	
	/*
	 * KieServices ks = KieServices.Factory.get(); KieContainer kContainer =
	 * ks.newKieContainer(ks.newReleaseId("drools-spring-v2",
	 * "drools-spring-v2-kjar", "0.0.1-SNAPSHOT")); KieScanner kScanner =
	 * ks.newKieScanner(kContainer); kScanner.start(10_000); KieSession kSession =
	 * kContainer.newKieSession();
	 */
}
