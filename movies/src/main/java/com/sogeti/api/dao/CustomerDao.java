package com.sogeti.api.dao;

import com.sogeti.api.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer, Integer> {}
