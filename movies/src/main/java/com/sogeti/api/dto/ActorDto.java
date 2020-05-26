package com.sogeti.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "actor")
@XmlAccessorType(XmlAccessType.PROPERTY)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class ActorDto {
    private String name;
    private String gender;
}
