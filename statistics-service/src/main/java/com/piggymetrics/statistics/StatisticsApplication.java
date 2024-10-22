package com.piggymetrics.statistics;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.piggymetrics.statistics.repository.converter.DataPointIdReaderConverter;
import com.piggymetrics.statistics.repository.converter.DataPointIdWriterConverter;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableOAuth2Client
@EnableFeignClients
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class StatisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
	}

	@Configuration
	static class CustomConversionsConfig {

        @Bean
        MongoCustomConversions customConversions() {
			return new MongoCustomConversions(Arrays.asList(new DataPointIdReaderConverter(),
					new DataPointIdWriterConverter()));
		}
	}
}
