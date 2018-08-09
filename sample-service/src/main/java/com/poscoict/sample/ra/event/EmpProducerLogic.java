package com.poscoict.sample.ra.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.stereotype.Service;

import com.poscoict.sample.domain.entity.Dept;
import com.poscoict.sample.domain.entity.Emp;
import com.poscoict.sample.domain.event.EmpProducer;
import com.poscoict.sample.domain.event.EventMessage;

//@Service
//@EnableBinding(EmpSource.class)
public class EmpProducerLogic implements EmpProducer {

	@Autowired
	EmpSource empSource;

	@Override
	public void disuseEmp(int empno) {
		// TODO Auto-generated method stub
		EventMessage message = new EventMessage(""+empno, "");
		empSource.toMicroServiceA().send(MessageBuilder.withPayload(message).setHeader("type", "").build());
	}

	@Override
	public void disuseDept(int deptno) {
		// TODO Auto-generated method stub
		EventMessage message = new EventMessage(""+deptno, "");
		empSource.toMicroServiceA().send(MessageBuilder.withPayload(message).setHeader("type", "").build());
	}

	@Override
	public void registerEmp(Emp emp) {
		// TODO Auto-generated method stub
		EventMessage message = new EventMessage(""+emp.getEmpno(), "");
		empSource.toMicroServiceA().send(MessageBuilder.withPayload(message).setHeader("type", "").build());
	}

	@Override
	public void registerDept(Dept dept, List<Emp> empList) {
		// TODO Auto-generated method stub
		EventMessage message = new EventMessage(""+dept.getDeptno(), "");
		empSource.toMicroServiceA().send(MessageBuilder.withPayload(message).setHeader("type", "").build());
	}
}
