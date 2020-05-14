package com.sogeti.api.model;

public class MovieRecommendation {

    private String title;
    private String imdb;

    public MovieRecommendation() {}

    public MovieRecommendation(String title, String imdb) {
        this.title = title;
        this.imdb = imdb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    @Override
    public String toString() {
        return "MovieRecommendation{" +
                "title='" + title + '\'' +
                ", imdb='" + imdb + '\'' +
                '}';
    }
}
