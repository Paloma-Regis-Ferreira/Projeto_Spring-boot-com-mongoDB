package com.paloma.projetomongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.paloma.projetomongo.dto.AuthorDTO;
import com.paloma.projetomongo.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.paloma.projetomongo.domain.Post;
import com.paloma.projetomongo.domain.User;
import com.paloma.projetomongo.repository.PostRepository;
import com.paloma.projetomongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); //vai zerar o mongo
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2021"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei", new AuthorDTO(maria));

		CommentDTO comment = new CommentDTO("Boa viagem", sdf.parse("21/03/2021"), new AuthorDTO(alex));
		CommentDTO comment2 = new CommentDTO("Boa viagem", sdf.parse("21/03/2021"), new AuthorDTO(bob));
		CommentDTO comment3 = new CommentDTO("Obrigada", sdf.parse("22/03/2021"), new AuthorDTO(maria));

		CommentDTO comment4 = new CommentDTO("Bom dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

		post1.setComments(Arrays.asList(comment, comment2, comment3));
		post2.setComments(Arrays.asList(comment4));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
