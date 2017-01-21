package com.wisely.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wisely.ui.domain.Person;

@Service
public class PersonHystrixService {

	@Autowired
	PersonService personService;

	// 1使用@HystrixCommand的fallbackMethod参数的指定，当本方法调用失败，调用后背方法fallbackSave
	//请注意这里的fallbackMethod的方法参数一定要和下面的fallbackMethod的参数一致，否则就会提示找不到对应的方法
	@HystrixCommand(fallbackMethod = "fallbackSave")
	public List<Person> save(String name,int count) {
		System.out.println("name=="+name+":count=="+count);
		return personService.save(name,count);
	}

	public List<Person> fallbackSave(String name,int count) {
		List<Person> list = new ArrayList<>();
		Person p = new Person(name + "没有保存成功，Person Service 故障");
		list.add(p);
		return list;
	}
}
