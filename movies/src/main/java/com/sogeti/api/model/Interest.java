package com.sogeti.api.model;

import com.sogeti.api.util.Gender;
import com.sogeti.api.util.Genre;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interestId;

    @Enumerated(EnumType.STRING)
    private Genre genres;
    private String actors;
    private String ratings;
    private String runtime;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
