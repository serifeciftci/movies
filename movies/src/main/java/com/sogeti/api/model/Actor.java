package com.sogeti.api.model;

import com.sogeti.api.util.Gender;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

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
