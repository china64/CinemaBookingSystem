package com.myproject.cinemabookingsystem_backend.service.impl;


import com.myproject.cinemabookingsystem_backend.mapper.MovieMapper;
import com.myproject.cinemabookingsystem_backend.model.Movie;
import com.myproject.cinemabookingsystem_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> viewAll() {
        return movieMapper.viewAll();
    }

    @Override
    public void newnovie(Movie movie) {
        movieMapper.newnovie(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        movieMapper.updateMovie(movie);
    }

    @Override
    public Movie findById(Integer id) {
        return movieMapper.findById(id);
    }
}
