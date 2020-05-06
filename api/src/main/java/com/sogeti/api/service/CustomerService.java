package com.sogeti.api.service;

import com.sogeti.api.dto.Customer;

public interface CustomerService {
    public void save(Customer customer);
    public void findSuggestionById(String customerId);
}
