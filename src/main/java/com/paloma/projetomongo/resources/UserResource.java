package com.paloma.projetomongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paloma.projetomongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User paloma = new User(1, "Paloma", "paloma@gmail.com");
		User pamela = new User(2, "Pamela", "pamela@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(paloma, pamela));
		return ResponseEntity.ok().body(list);
	}
}
