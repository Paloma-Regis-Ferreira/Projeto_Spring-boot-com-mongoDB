package com.paloma.projetomongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paloma.projetomongo.domain.User;
import com.paloma.projetomongo.dto.UserDTO;
import com.paloma.projetomongo.repository.UserRepository;
import com.paloma.projetomongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		User user = repository.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
