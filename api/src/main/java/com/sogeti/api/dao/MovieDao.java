package com.sogeti.api.dao;

import com.sogeti.api.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends CrudRepository<Movie, Integer> {
}
