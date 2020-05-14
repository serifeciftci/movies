package com.sogeti.api.service;

import com.sogeti.api.dao.CustomQueryDao;
import com.sogeti.api.dao.CustomerDao;
import com.sogeti.api.model.Customer;
import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
import com.sogeti.api.model.MovieRecommendation;
import com.sogeti.api.util.Gender;
import com.sogeti.api.util.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomQueryDao customQueryDao;

    @Override
    public void save(com.sogeti.api.dto.Customer dtoCustomer) {
        Customer customer = convert(dtoCustomer);
        customerDao.save(customer);
    }

    private Customer convert(com.sogeti.api.dto.Customer dtoCustomer) {
        Customer customer = new Customer();

        customer.setCustomerId(dtoCustomer.getCustomer_id());
        customer.setName(dtoCustomer.getName());

        List<Interest> interests = new ArrayList<Interest>();

        for (com.sogeti.api.dto.Interest dtoInterest : dtoCustomer.getInterests()) {
            Interest interest = new Interest();

            if (dtoInterest.getGenres() != null) {
                interest.setGenres(Genre.valueOf(dtoInterest.getGenres()));
            }
//            interest.setGenres(dtoInterest.getGenres());
            interest.setActors(dtoInterest.getActors());
            interest.setRatings(dtoInterest.getRatings());
            interest.setRuntime(dtoInterest.getRuntime());
            if (dtoInterest.getGender() != null) {
                interest.setGender(Gender.valueOf(dtoInterest.getGender()));
            }

            interests.add(interest);
        }

        customer.setInterests(interests);

        return customer;
    }

    private Optional<Customer> findById(int customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public List<MovieRecommendation> findRecommendation(String customerId) {
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

        List<Movie> movies = customQueryDao.findMovieByInterests(interest);
        return convertToRecommendation(movies);

    }

    private List<MovieRecommendation> convertToRecommendation(List<Movie> movies) {
        List<MovieRecommendation> recommendations = new ArrayList<MovieRecommendation>();

        for (Movie movie : movies) {
            MovieRecommendation recommendation = new MovieRecommendation();
            recommendation.setTitle(movie.getTitle());
            recommendation.setImdb(movie.getImdb());
            recommendations.add(recommendation);
        }

        return recommendations;
    }
}
