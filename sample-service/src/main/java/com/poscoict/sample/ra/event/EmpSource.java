package com.poscoict.sample.ra.event;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmpSource {
	@Output("output-MS-A")
	MessageChannel toMicroServiceA();
	
	@Output("output-MS-B")
	MessageChannel toMicroServiceB();
}
