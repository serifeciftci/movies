package com.sogeti.api.resource;

import com.sogeti.api.dto.MovieRecommendation;
import com.sogeti.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/yourapp/v1/movie")
public class CustomerResource {

    private CustomerService customerService;

    @Autowired
    CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/suggestion/customer/id/{customerId}")
    public List<MovieRecommendation> getSuggestionById(@PathVariable String customerId) {
        return customerService.findRecommendation(customerId);
    }
}