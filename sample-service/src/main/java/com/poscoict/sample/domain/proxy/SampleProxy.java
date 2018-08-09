package com.poscoict.sample.domain.proxy;

import com.poscoict.sample.domain.proxy.sdo.SampleRdo;

public interface SampleProxy {
	SampleRdo findData(String value);
}
