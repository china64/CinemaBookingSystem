package com.myproject.cinemabookingsystem_backend.controller;

import com.myproject.cinemabookingsystem_backend.model.Movie;
import com.myproject.cinemabookingsystem_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping("/ViewMovieList")
    public List<Movie> viewAll() {
        return movieService.viewAll();
    }
}
