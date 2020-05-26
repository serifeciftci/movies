package com.sogeti.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class InterestDto {
    private String genres;
    private String actors;
    private String ratings;
    private String runtime;
    private String gender;
}
