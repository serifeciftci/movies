package com.sogeti.api.dto;

public class InterestDto {

    private String genres;
    private String actors;
    private String ratings;
    private String runtime;
    private String gender;

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "genres='" + genres + '\'' +
                ", actors='" + actors + '\'' +
                ", ratings='" + ratings + '\'' +
                ", runtime='" + runtime + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
