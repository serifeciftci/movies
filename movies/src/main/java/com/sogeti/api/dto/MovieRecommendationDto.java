package com.sogeti.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class MovieRecommendationDto {

    private String title;
    private String imdb;
}
