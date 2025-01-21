package com.myproject.cinemabookingsystem_backend.service;

import com.myproject.cinemabookingsystem_backend.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    public List<Movie> viewAll();

    public void newnovie(Movie movie);

    public void updateMovie(Movie movie);

    public Movie findById(Integer id);
}
