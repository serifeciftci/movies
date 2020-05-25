package com.sogeti.api.dto;

import com.sogeti.api.util.Genre;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class MovieDto {

    private String title;
    private List<Genre> genres = new ArrayList<Genre>();
    private List<ActorDto> actors = new ArrayList<ActorDto>();
    private float rating;
    private int runtime;
    private String imdb;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    public List<ActorDto> getActors() {
        return actors;
    }

    public void setActors(List<ActorDto> actors) {
        this.actors = actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", actors=" + actors +
                ", rating=" + rating +
                ", runtime=" + runtime +
                ", imdb='" + imdb + '\'' +
                '}';
    }
}
