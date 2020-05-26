package com.sogeti.api.repository;

import com.sogeti.api.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {}
