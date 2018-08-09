package com.poscoict.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.poscoict.sample" })
public class SampleAppliction {
	public static void main(String args[]) {
		SpringApplication.run(SampleAppliction.class, args);
	}
}
