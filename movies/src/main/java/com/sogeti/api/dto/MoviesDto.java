package com.sogeti.api.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class MoviesDto {

    @XmlElement(name = "movie")
    private List<MovieDto> movie;

    public List<MovieDto> getMovie() {
        return movie;
    }

    public void setMovie(List<MovieDto> movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies=" + movie +
                '}';
    }
}
