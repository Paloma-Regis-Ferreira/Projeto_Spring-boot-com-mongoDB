package com.paloma.projetomongo.services;

import com.paloma.projetomongo.domain.Post;
import com.paloma.projetomongo.domain.User;
import com.paloma.projetomongo.dto.UserDTO;
import com.paloma.projetomongo.repository.PostRepository;
import com.paloma.projetomongo.repository.UserRepository;
import com.paloma.projetomongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Post post = repository.findById(id).orElse(null);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado");
		}
		return post;
	}

	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}
