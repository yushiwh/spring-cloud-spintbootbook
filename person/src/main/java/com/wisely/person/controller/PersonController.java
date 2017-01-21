package com.wisely.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisely.person.dao.PersonRepository;
import com.wisely.person.domain.Person;

@RestController
public class PersonController {
	@Autowired
	PersonRepository personRepository;

	@RequestMapping(value = "/save/{count}", method = RequestMethod.POST)
	public List<Person> savePerson(@RequestBody String personName, @PathVariable("count") int count) {
		Person p = new Person(personName);
		personRepository.save(p);
		// List<Person> people = personRepository.findAll(new PageRequest(0,
		// 10)).getContent();
		if (count == 0) {
			count = 10;
		}
		List<Person> people = personRepository.findAll(new PageRequest(0, count)).getContent();// 换成自定义

		return people;
	}

}
