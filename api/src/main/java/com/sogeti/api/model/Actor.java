package com.sogeti.api.model;

import com.sogeti.api.util.Gender;

import javax.persistence.*;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Actor() {}

    public Actor(int actorId, String name, Gender gender) {
        this.actorId = actorId;
        this.name = name;
        this.gender = gender;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
