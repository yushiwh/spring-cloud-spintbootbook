package com.wisely.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 使用ribbon调用Some Server，并且使用断路器
 * 
 * @author yushi
 *
 */
@Service
public class SomeHystrixService {

	@Autowired
	RestTemplate restTemplate; // 1使用Ribbon，只需要注入一个RestTemplate即可，已经做好配置

	@HystrixCommand(fallbackMethod = "fallbackSome") // 2使用断路器指定失败后的跳转方法
	public String getSome() {
		return restTemplate.getForObject("http://some/getsome", String.class);
	}

	public String fallbackSome() {
		return "some service模块故障";
	}
}
