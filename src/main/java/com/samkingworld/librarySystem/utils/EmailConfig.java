package com.samkingworld.librarySystem.utils;
import jakarta.mail.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class EmailConfig {

    @Bean
    public ExecutorService executorService(){
        ExecutorService executor = Executors.newFixedThreadPool(2);
        return executor;
    }

        @Bean
        public JavaMailSender javaMailSender() {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost("smtp.gmail.com"); //smtp server host
            javaMailSender.setPort(587); //smtp server port
            javaMailSender.setUsername("samking@gmail.com"); //email
            javaMailSender.setPassword("xxxxxx"); //app config password from gmail under security

            Properties props = javaMailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");

            return javaMailSender;
        }
}
