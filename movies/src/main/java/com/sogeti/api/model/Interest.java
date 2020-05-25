package com.sogeti.api.model;

import com.sogeti.api.util.Gender;
import com.sogeti.api.util.Genre;

import javax.persistence.*;

@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Genre genres;
    private String actors;
    private String ratings;
    private String runtime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genre getGenres() {
        return genres;
    }

    public void setGenres(Genre genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + id +
                ", genres='" + genres + '\'' +
                ", actors='" + actors + '\'' +
                ", ratings='" + ratings + '\'' +
                ", runtime='" + runtime + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
