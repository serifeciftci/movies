package com.sogeti.api.service;

import com.sogeti.api.mapper.MovieMapper;
import com.sogeti.api.repository.MovieRepository;
import com.sogeti.api.dto.MovieDto;
import com.sogeti.api.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public void save(MovieDto movieDto) {
        Movie movie = movieMapper.dtoToModel(movieDto);
        movieRepository.save(movie);
    }
}
