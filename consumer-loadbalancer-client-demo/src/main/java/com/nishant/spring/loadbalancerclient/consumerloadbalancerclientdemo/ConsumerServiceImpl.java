package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private ProducerClient producerClient;
	
	@Override
	public List<String> getAll() {
		return producerClient.getAll();
	}

	@Override
	public String getById(Integer id) {
		return producerClient.getById(id);
	}

}
