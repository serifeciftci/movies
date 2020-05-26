package com.sogeti.api.service;

import com.sogeti.api.mapper.CustomerMapper;
import com.sogeti.api.mapper.MovieMapper;
import com.sogeti.api.repository.CustomQueryRepository;
import com.sogeti.api.repository.CustomerRepository;
import com.sogeti.api.dto.CustomerDto;
import com.sogeti.api.model.Customer;
import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
import com.sogeti.api.dto.MovieRecommendationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomQueryRepository customQueryRepository;
    private final MovieMapper movieMapper;
    private final CustomerMapper customerMapper;
    private final String regex = "\\D+";

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomQueryRepository customQueryRepository,
                               MovieMapper movieMapper,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customQueryRepository = customQueryRepository;
        this.movieMapper = movieMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public void save(CustomerDto customerDto) {
        customerRepository.save(customerMapper.dtoToModel(customerDto));
    }

    private Optional<Customer> findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<MovieRecommendationDto> findRecommendation(String customerId) {
        Optional<Customer> customer = findById(Integer.parseInt(customerId));
        Interest interest = customer.get().getInterests().get(0);

        // assumption: column ratings contains format "x+" where x is a digit
        if (interest.getRatings() != null && !interest.getRatings().isEmpty()) {
            if (interest.getRatings().endsWith("+")) {
                interest.setRatings(interest.getRatings().substring(0, interest.getRatings().length() - 1));
            }
        }

        // assumption: column runtime contains format "< xxx minutes"
        if (interest.getRuntime() != null && !interest.getRuntime().isEmpty()) {
            interest.setRuntime(interest.getRuntime().replaceAll(regex,""));
        }

        List<Movie> movies = customQueryRepository.findMovieByInterests(interest);

        return movieMapper.movieListToRecommendation(movies);
    }
}
