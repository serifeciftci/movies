package com.sogeti.api.dao;

import com.sogeti.api.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieDao extends CrudRepository<Movie, Integer> {}
