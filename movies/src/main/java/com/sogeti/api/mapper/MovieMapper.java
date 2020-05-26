package com.sogeti.api.mapper;

import com.sogeti.api.dto.ActorDto;
import com.sogeti.api.dto.MovieDto;
import com.sogeti.api.dto.MovieRecommendationDto;
import com.sogeti.api.model.Actor;
import com.sogeti.api.model.Movie;
import com.sogeti.api.util.Gender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public List<MovieRecommendationDto> movieListToRecommendation(List<Movie> movies) {
        List<MovieRecommendationDto> recommendations = new ArrayList<>();

        for (Movie movie : movies) {
            MovieRecommendationDto recommendation = new MovieRecommendationDto();
            recommendation.setTitle(movie.getTitle());
            recommendation.setImdb(movie.getImdb());
            recommendations.add(recommendation);
        }

        return recommendations;
    }

    public Movie dtoToModel(MovieDto movieDto) {
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
