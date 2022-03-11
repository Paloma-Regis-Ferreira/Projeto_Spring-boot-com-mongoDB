package com.paloma.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.paloma.projetomongo.domain.Post;
import com.paloma.projetomongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
