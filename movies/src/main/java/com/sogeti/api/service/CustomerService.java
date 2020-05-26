package com.sogeti.api.service;

import com.sogeti.api.dto.CustomerDto;
import com.sogeti.api.dto.MovieRecommendationDto;

import java.util.List;

public interface CustomerService {
    void save(CustomerDto customer);
    List<MovieRecommendationDto> findRecommendation(String customerId);
}
