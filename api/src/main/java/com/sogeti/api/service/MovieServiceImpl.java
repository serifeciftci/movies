package com.sogeti.api.service;

import com.sogeti.api.dao.MovieDao;
import com.sogeti.api.model.Actor;
import com.sogeti.api.model.Movie;
import com.sogeti.api.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public void save(com.sogeti.api.dto.Movie dtoMovie) {
        Movie movie = convert(dtoMovie);
        movieDao.save(movie);
    }

    public Movie convert(com.sogeti.api.dto.Movie dtoMovie) {
        Movie movie = new Movie();

        movie.setTitle(dtoMovie.getTitle());
        movie.setRating(dtoMovie.getRating());
        movie.setRuntime(dtoMovie.getRuntime());
        movie.setImdb(dtoMovie.getImdb());
        movie.setGenres(dtoMovie.getGenres());

        List<Actor> actorList = new ArrayList<Actor>();
        List<com.sogeti.api.dto.Actor> dtoActorList = dtoMovie.getActors();

        for (com.sogeti.api.dto.Actor dtoActor : dtoActorList) {
            Actor actor = new Actor();
            actor.setName(dtoActor.getName());
            actor.setGender(Gender.valueOf(dtoActor.getGender()));
            actorList.add(actor);
        }

        movie.setActors(actorList);

        return movie;
    }
}
