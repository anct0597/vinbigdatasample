package com.vinbigdata.callbilling.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@RequiredArgsConstructor
@EnableJpaAuditing
@EntityScan(basePackages = "com.vinbigdata.callbilling.model")
@EnableJpaRepositories(basePackages = "com.vinbigdata.callbilling.repository")
public class PersistenceConfig {
}
