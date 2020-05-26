package com.sogeti.api.model;

import com.sogeti.api.util.Genre;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
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
}
