package com.sogeti.api.model;

import com.sogeti.api.util.Gender;
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
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
