package com.edu.eci.ieti.laboratorio.repository;

import com.edu.eci.ieti.laboratorio.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameLikeOrLastnameLike(String queryText, String queryText2);

    List<User> findByCreatedAtAfter(LocalDate date);

}
