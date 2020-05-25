package com.sogeti.api.dto;

import java.util.ArrayList;
import java.util.List;

public class CustomerDto {

    private int customer_id;
    private String name;
    private List<InterestDto> interests = new ArrayList();

    public CustomerDto() {}

    public CustomerDto(int customer_id, String name, List<InterestDto> interests) {
        this.customer_id = customer_id;
        this.name = name;
        this.interests = interests;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InterestDto> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestDto> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customer_id +
                ", name='" + name + '\'' +
                ", interests=" + interests +
                '}';
    }
}
