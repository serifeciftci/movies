package com.sogeti.api.repository;

import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomQueryRepositoryImpl implements CustomQueryRepository {

    private EntityManager entityManager;

    public CustomQueryRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> findMovieByInterests(Interest interest) {
        List<Movie> recommendationsList = new ArrayList<>();

        if (interest.getActors() != null) {
            addToList(findByActor(interest), recommendationsList);
        }

        if (interest.getGender() != null) {
            addToList(findByGender(interest), recommendationsList);
        }

        if (interest.getRatings() != null) {
            addToList(findByRating(interest), recommendationsList);
        }

        if (interest.getRuntime() != null) {
            addToList(findByRuntime(interest), recommendationsList);
        }

        return recommendationsList;
    }

    private List<Movie> findByActor(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query = currentSession.createQuery("select m from Movie m join m.actors ma where ma.name=:name", Movie.class);
        query.setParameter("name", interest.getActors());

        return query.getResultList();
    }

    private List<Movie> findByGender(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query = currentSession.createQuery("select m from Movie m join m.actors ma where ma.gender=:gender", Movie.class);
        query.setParameter("gender", interest.getGender());

        return query.getResultList();
    }

    private List<Movie> findByRating(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query = currentSession.createQuery("select m from Movie m where m.rating>=:rating", Movie.class);
        query.setParameter("rating", Float.valueOf(interest.getRatings()));

        return query.getResultList();
    }

    private List<Movie> findByRuntime(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query = currentSession.createQuery("select m from Movie m where m.runtime<=:runtime", Movie.class);
        query.setParameter("runtime", Integer.parseInt(interest.getRuntime()));

        return query.getResultList();
    }

    private void addToList(List<Movie> list, List<Movie> recommendationsList) {
        for(Movie movie : list) {
            if(!recommendationsList.contains(movie)) {
                recommendationsList.add(movie);
            }
        }
    }
}











