package com.anil.rest.webservicesbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class WebservicesBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesBasicsApplication.class, args);
	}


//	@Bean
//	public LocaleResolver localeResolver(){
//		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//		sessionLocaleResolver.setDefaultLocale(Locale.US);
//		return sessionLocaleResolver;
//	}
//
//	@Bean
//	public ResourceBundleMessageSource resourceBundleMessageSource(){
//		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
//		resourceBundleMessageSource.setBasename("abc");
//		return resourceBundleMessageSource;
//	}

}
