package com.sogeti.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

    @Id
    private int customerId;
    private String name;

    @OneToMany(targetEntity=Interest.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMERINTERESTS",
            joinColumns = { @JoinColumn(name = "customerId") },
            inverseJoinColumns = { @JoinColumn(name = "interestId") })
    private List<Interest> interests;
}
