package com.nishant.spring.loadbalancerclient.consumerloadbalancerclientdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class ProducerClient {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public List<String> getAll(){
		return new RestTemplate().getForObject(loadBalancerClient.choose("producer-loadbalancer").getUri().toString()+"/producer/getall",List.class);
	}

	public String getById(Integer id) {
		return new RestTemplate().getForObject(loadBalancerClient.choose("producer-loadbalancer").getUri().toString()+"/producer/getbyid/"+id,String.class);
	}

}
