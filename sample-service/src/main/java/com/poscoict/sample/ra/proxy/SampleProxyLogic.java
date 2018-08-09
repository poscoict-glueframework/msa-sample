package com.poscoict.sample.ra.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.poscoict.sample.domain.proxy.SampleProxy;
import com.poscoict.sample.domain.proxy.sdo.SampleRdo;
import com.poscoict.second.adapter.sdo.SecondDTO;
import com.poscoict.second.client.SecondClient;

@Service
@EnableCircuitBreaker
@EnableFeignClients(basePackages = { "com.poscoict.second" })
public class SampleProxyLogic implements SampleProxy {
	@Autowired
	private SecondClient client;

	@Override
	@HystrixCommand(fallbackMethod = "failfindData")
	public SampleRdo findData(String value) {
		SecondDTO dto = client.findSecond(value);
		return SampleRdo.fromJson(dto.toJson());
	}

	@SuppressWarnings("unused")
	private SampleRdo failfindData(String value, Throwable t) {
		throw new RuntimeException("Fail findData \n", t);
	}
}
