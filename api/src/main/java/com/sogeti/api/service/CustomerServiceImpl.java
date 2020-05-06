package com.sogeti.api.service;

import com.sogeti.api.dao.CustomerDao;
import com.sogeti.api.dto.Customer;
import com.sogeti.api.entity.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public void save(Customer jsonCustomer) {
        com.sogeti.api.entity.Customer customer = convert(jsonCustomer);
        customerDao.save(customer);
    }

    private com.sogeti.api.entity.Customer convert(Customer dtoCustomer) {
        com.sogeti.api.entity.Customer customer = new com.sogeti.api.entity.Customer();

        customer.setCustomerId(dtoCustomer.getCustomer_id());
        customer.setName(dtoCustomer.getName());

        List<Interest> interests = new ArrayList<Interest>();

        for (com.sogeti.api.dto.Interest dtoInterest : dtoCustomer.getInterests()) {
            Interest interest = new Interest();

            interest.setGenres(dtoInterest.getGenres());
            interest.setActors(dtoInterest.getActors());
            interest.setRatings(dtoInterest.getRatings());
            interest.setRuntime(dtoInterest.getRuntime());
            interest.setGender(dtoInterest.getGender());

            interests.add(interest);
        }

        customer.setInterests(interests);

        return customer;
    }

    private Optional<com.sogeti.api.entity.Customer> findById(int customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public void findSuggestionById(String id) {
        Optional<com.sogeti.api.entity.Customer> customer = findById(Integer.parseInt(id));
        List<Interest> interest = customer.get().getInterests();

        System.out.println("customer" + customer);
        System.out.println("interest" + interest);

    }
}
