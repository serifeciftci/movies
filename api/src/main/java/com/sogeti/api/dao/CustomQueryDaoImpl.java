package com.sogeti.api.dao;

import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
import com.sogeti.api.util.Genre;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomQueryDaoImpl implements CustomQueryDao {

    EntityManager entityManager;

    @Autowired
    public CustomQueryDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Movie> findMovieByInterests(Interest interest) {
        List<Movie> recommendationsList = new ArrayList<Movie>();

//        if (interest.getActors() != null) {
//            addToList(findByActor(interest), recommendationsList);
//        }
//
//        if (interest.getGender() != null) {
//            addToList(findByGender(interest), recommendationsList);
//        }

        if (interest.getGenres() != null) {
            addToList(findByGenre(interest), recommendationsList);
        }

//        if (interest.getRatings() != null) {
//            addToList(findByRating(interest), recommendationsList);
//        }
//
//        if (interest.getRuntime() != null) {
//            addToList(findByRuntime(interest), recommendationsList);
//        }

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

    private List<Movie> findByGenre(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query = currentSession.createQuery("select m from Movie m join m.genres mg where m.genres=:genre", Movie.class);
        query.setParameter("genre", Genre.Action);

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
        System.out.println("----------------");
        System.out.println("list: " + list);
        System.out.println("recommendationsList: " + recommendationsList);
        for(Movie movie : list) {
            if(!recommendationsList.contains(movie)) {
                recommendationsList.add(movie);
            }
        }
    }
}


// 1001 - 1
// 1002 - 1 2 3
// 1003 - 1 2
// 1004 - 2
// 1005 - 3











