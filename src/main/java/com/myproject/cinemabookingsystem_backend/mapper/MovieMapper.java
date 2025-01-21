package com.myproject.cinemabookingsystem_backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.myproject.cinemabookingsystem_backend.model.Movie;

import java.util.List;

@Mapper
public interface MovieMapper {
    List<Movie> viewAll();

    void newnovie(Movie movie);

    void updateMovie(Movie movie);

    Movie findById(Integer id);
}
