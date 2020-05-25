package com.sogeti.api.service;

import com.sogeti.api.dto.CustomerDto;
import com.sogeti.api.model.MovieRecommendation;

import java.util.List;

public interface CustomerService {
    void save(CustomerDto customer);
    List<MovieRecommendation> findRecommendation(String customerId);
}
