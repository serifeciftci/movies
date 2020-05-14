package com.sogeti.api.service;

import com.sogeti.api.dto.Customer;
import com.sogeti.api.model.MovieRecommendation;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<MovieRecommendation> findRecommendation(String customerId);
}
