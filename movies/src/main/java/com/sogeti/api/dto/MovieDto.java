package com.sogeti.api.dto;

import com.sogeti.api.util.Genre;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.PROPERTY)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class MovieDto {

    private String title;
    private List<Genre> genres = new ArrayList<>();
    private List<ActorDto> actors = new ArrayList<>();
    private float rating;
    private int runtime;
    private String imdb;

    @XmlElementWrapper(name = "genres")
    @XmlElement(name = "genre")
    public List<Genre> getGenres() {
        return genres;
    }

    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    public List<ActorDto> getActors() {
        return actors;
    }
}
