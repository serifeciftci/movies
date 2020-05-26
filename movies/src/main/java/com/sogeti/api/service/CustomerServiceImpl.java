package com.sogeti.api.service;

import com.sogeti.api.repository.CustomQueryRepository;
import com.sogeti.api.repository.CustomerRepository;
import com.sogeti.api.dto.CustomerDto;
import com.sogeti.api.dto.InterestDto;
import com.sogeti.api.model.Customer;
import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
import com.sogeti.api.dto.MovieRecommendationDto;
import com.sogeti.api.util.Gender;
import com.sogeti.api.util.Genre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomQueryRepository customQueryRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomQueryRepository customQueryRepository) {
        this.customerRepository = customerRepository;
        this.customQueryRepository = customQueryRepository;
    }

    @Override
    public void save(CustomerDto customerDto) {
        customerRepository.save(convert(customerDto));
    }

    private Customer convert(CustomerDto customerDto) {
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

    private Optional<Customer> findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<MovieRecommendationDto> findRecommendation(String customerId) {
        Optional<Customer> customer = findById(Integer.parseInt(customerId));
        Interest interest = customer.get().getInterests().get(0);

        // assumption: column ratings contains format "x+" where x is a digit
        if (interest.getRatings() != null && !interest.getRatings().isEmpty()) {
            if (interest.getRatings().substring(interest.getRatings().length() - 1).equals("+")) {
                interest.setRatings(interest.getRatings().substring(0, interest.getRatings().length() - 1));
            }
        }

        // assumption: column runtime contains format "< xxx minutes"
        if (interest.getRuntime() != null && !interest.getRuntime().isEmpty()) {
            interest.setRuntime(interest.getRuntime().replaceAll("\\D+",""));
        }

        List<Movie> movies = customQueryRepository.findMovieByInterests(interest);

        return convertToRecommendation(movies);
    }

    private List<MovieRecommendationDto> convertToRecommendation(List<Movie> movies) {
        List<MovieRecommendationDto> recommendations = new ArrayList<>();

        for (Movie movie : movies) {
            MovieRecommendationDto recommendation = new MovieRecommendationDto();
            recommendation.setTitle(movie.getTitle());
            recommendation.setImdb(movie.getImdb());
            recommendations.add(recommendation);
        }

        return recommendations;
    }
}
