package com.poscoict.sample.domain.event;

public class EventMessage {
	private String topicExchange;
	private String routingKey;

	public EventMessage(String topicExchange) {
		this.topicExchange = topicExchange;
	}

	public EventMessage(String topicExchange, String routingKey) {
		this.topicExchange = topicExchange;
		this.routingKey = routingKey;
	}

	public String getTopicExchange() {
		return topicExchange;
	}

	public String getRoutingKey() {
		return routingKey;
	}
}
