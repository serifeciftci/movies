package com.sogeti.api.service;

import com.sogeti.api.dao.MovieDao;
import com.sogeti.api.dto.ActorDto;
import com.sogeti.api.dto.MovieDto;
import com.sogeti.api.model.Actor;
import com.sogeti.api.model.Movie;
import com.sogeti.api.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieDao movieDao;

    @Autowired
    MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public void save(MovieDto movieDto) {
        Movie movie = convert(movieDto);
        movieDao.save(movie);
    }

    public Movie convert(MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setTitle(movieDto.getTitle());
        movie.setRating(movieDto.getRating());
        movie.setRuntime(movieDto.getRuntime());
        movie.setImdb(movieDto.getImdb());
        movie.setGenres(movieDto.getGenres());

        List<Actor> actorList = new ArrayList<Actor>();
        List<ActorDto> actorListDto = movieDto.getActors();

        for (ActorDto actorDto : actorListDto) {
            Actor actor = new Actor();
            actor.setName(actorDto.getName());
            actor.setGender(Gender.valueOf(actorDto.getGender()));
            actorList.add(actor);
        }

        movie.setActors(actorList);

        return movie;
    }
}
