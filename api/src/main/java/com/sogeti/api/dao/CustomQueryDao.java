package com.sogeti.api.dao;

import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;

import java.util.List;

public interface CustomQueryDao {
    List<Movie> findMovieByInterests(Interest interest);
}
