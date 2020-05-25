package com.sogeti.api.model;

import com.sogeti.api.util.Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    private String title;
    private float rating;
    private int runtime;
    private String imdb;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(
            name = "MOVIEGENRES",
            joinColumns = @JoinColumn(name = "movieId"))
    @Column(name = "GENRE")
    private List<Genre> genres = new ArrayList<Genre>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIEACTOR",
            joinColumns = { @JoinColumn(name = "movieId") },
            inverseJoinColumns = { @JoinColumn(name = "actorId") })
    private List<Actor> actors = new ArrayList<Actor>();

    public Movie() {}

    public Movie(String title, float rating, int runtime, String imdb, List<Genre> genres, List<Actor> actors) {
        this.title = title;
        this.rating = rating;
        this.runtime = runtime;
        this.imdb = imdb;
        this.genres = genres;
        this.actors = actors;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", runtime=" + runtime +
                ", imdb='" + imdb + '\'' +
                ", genres=" + genres +
                ", actors=" + actors +
                '}';
    }
}
