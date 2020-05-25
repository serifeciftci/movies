package com.sogeti.api.importdata;

import com.sogeti.api.dto.MoviesDto;
import com.sogeti.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Component
public class LoadMovieData implements CommandLineRunner {

    @Value("classpath:input/movies.xml")
    private Resource resource;

    private MovieService movieService;

    @Autowired
    public LoadMovieData(MovieService movieService){
        this.movieService = movieService;
    }

    @Override
    public void run(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(MoviesDto.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        MoviesDto movies = (MoviesDto) jaxbUnmarshaller.unmarshal(resource.getFile());

        movies.getMovie().stream().forEach(movie -> {
            movieService.save(movie);
        });
    }
}