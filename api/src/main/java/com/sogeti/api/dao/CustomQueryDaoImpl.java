package com.sogeti.api.dao;

import com.sogeti.api.model.Interest;
import com.sogeti.api.model.Movie;
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

        if (interest.getActors() != null) {
            List<Movie> list = findByActorName(interest);
            addToList(list, recommendationsList);
        }

        if (interest.getGender() != null) {
            List<Movie> list = findByGender(interest);
            addToList(list, recommendationsList);
        }

        if (interest.getGenres() != null) {
//            List<Movie> list = findByGenre(interest);
//            for(Movie movie : list) {
//                movieList.add(movie);
//            }
        }

        return recommendationsList;
    }


    private List<Movie> findByActorName(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query =
                currentSession.createQuery("select m from Movie m join m.actors ma where ma.name=:name", Movie.class);
        query.setParameter("name", interest.getActors());
        List<Movie> movie = query.getResultList();

        return movie;
    }

    private List<Movie> findByGender(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Movie> query =
                currentSession.createQuery("select m from Movie m join m.actors ma where ma.gender=:gender", Movie.class);
        query.setParameter("gender", interest.getGender());
        List<Movie> movie = query.getResultList();

        return movie;
    }

    private List<Movie> findByGenre(Interest interest) {
        Session currentSession = entityManager.unwrap(Session.class);
        System.out.println("interest: " + interest);

        Query<Movie> query =
//                currentSession.createQuery("select m from Movie m join m.genres mg where m.genres=:genre", Movie.class);
                currentSession.createQuery("select m from Movie m where m.genres=:genre", Movie.class);
        System.out.println("RRR: " + interest.getGenres());
        query.setParameter("genre", interest.getGenres());

        System.out.println("XXX: " + query.getResultList());


        List<Movie> movie = query.getResultList();

        return movie;
    }

    private void addToList(List<Movie> list, List<Movie> recommendationsList) {
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











