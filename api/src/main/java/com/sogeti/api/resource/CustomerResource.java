package com.sogeti.api.resource;

import com.sogeti.api.importdata.LoadCustomerData;
import com.sogeti.api.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/yourapp/v1/movie")
public class CustomerResource {

    private Logger logger = LoggerFactory.getLogger(CustomerResource.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/suggestion/customer/id/{id}")
    public void getSuggestionById(@PathVariable String id) {
        customerService.findSuggestionById(id);
    }
}
