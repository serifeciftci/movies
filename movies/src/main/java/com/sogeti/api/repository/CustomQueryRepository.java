package com.sogeti.api.repository;

import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;

import java.util.List;

public interface CustomQueryRepository {
    List<Movie> findMovieByInterests(Interest interest);
}
