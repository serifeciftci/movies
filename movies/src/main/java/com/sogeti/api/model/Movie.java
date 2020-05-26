package com.sogeti.api.model;

import com.sogeti.api.util.Genre;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;


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
    private List<Genre> genres = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MOVIEACTOR",
            joinColumns = { @JoinColumn(name = "movieId") },
            inverseJoinColumns = { @JoinColumn(name = "actorId") })
    private List<Actor> actors = new ArrayList<>();
}
