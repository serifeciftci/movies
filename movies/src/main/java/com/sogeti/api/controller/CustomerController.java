package com.sogeti.api.controller;

import com.sogeti.api.dto.MovieRecommendationDto;
import com.sogeti.api.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/id/{customerId}")
    public List<MovieRecommendationDto> getSuggestionById(@PathVariable String customerId) {
        return customerService.findRecommendation(customerId);
    }
}
