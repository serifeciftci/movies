package com.sogeti.api.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto {
    private int customer_id;
    private String name;
    private List<InterestDto> interests = new ArrayList();
}
