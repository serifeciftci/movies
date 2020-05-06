package com.sogeti.api.service;

import com.sogeti.api.dao.MovieDao;
import com.sogeti.api.dto.Movie;
import com.sogeti.api.entity.Actor;
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
    public void save(Movie dtoMovie) {
        com.sogeti.api.entity.Movie movie = convert(dtoMovie);
        movieDao.save(movie);
    }

    public com.sogeti.api.entity.Movie convert(Movie dtoMovie) {
        com.sogeti.api.entity.Movie movie = new com.sogeti.api.entity.Movie();

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
