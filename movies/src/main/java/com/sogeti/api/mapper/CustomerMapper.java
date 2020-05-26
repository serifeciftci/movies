package com.sogeti.api.mapper;

import com.sogeti.api.dto.CustomerDto;
import com.sogeti.api.dto.InterestDto;
import com.sogeti.api.model.Customer;
import com.sogeti.api.model.Interest;
import com.sogeti.api.util.Gender;
import com.sogeti.api.util.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {

    public Customer dtoToModel(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setCustomerId(customerDto.getCustomer_id());
        customer.setName(customerDto.getName());

        List<Interest> interests = new ArrayList<>();

        for (InterestDto interestDto : customerDto.getInterests()) {
            Interest interest = new Interest();

            if (interestDto.getGenres() != null) {
                interest.setGenres(Genre.valueOf(interestDto.getGenres()));
            }

            interest.setActors(interestDto.getActors());
            interest.setRatings(interestDto.getRatings());
            interest.setRuntime(interestDto.getRuntime());

            if (interestDto.getGender() != null) {
                interest.setGender(Gender.valueOf(interestDto.getGender()));
            }

            interests.add(interest);
        }

        customer.setInterests(interests);

        return customer;
    }
}
