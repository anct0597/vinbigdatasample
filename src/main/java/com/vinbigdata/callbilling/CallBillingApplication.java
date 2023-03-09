package com.vinbigdata.callbilling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: anct
 * date: 3/9/2023
 * YNWA
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.vinbigdata.callbilling")
public class CallBillingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallBillingApplication.class, args);
    }
}
