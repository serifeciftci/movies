package com.sogeti.api.importdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sogeti.api.dto.Customer;
import com.sogeti.api.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class LoadCustomerData implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(LoadCustomerData.class);

    @Autowired
    CustomerService customerService;

    @Override
    public void run(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>() {
        };

        try (InputStream inputStream = getClass().getResourceAsStream("/input/profiles.json")) {
            List<Customer> customers = mapper.readValue(inputStream, typeReference);

            customers.stream().forEach(customer -> {
                customerService.save(customer);
            });

            logger.info("Finished saving data from profiles.json into database");

        } catch (IOException e) {
            logger.error("Unable to read profiles.json :" + e);
        }
    }
}
