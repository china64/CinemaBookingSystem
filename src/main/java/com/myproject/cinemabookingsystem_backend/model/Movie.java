package com.myproject.cinemabookingsystem_backend.model;

import lombok.Data;

@Data
public class Movie {
    private Integer id;
    private String moviename;
    private String roomway;
    private Boolean bookable;

    public Movie(Integer id, String moviename, String roomway) {
        super();
        this.id=id;
        this.moviename=moviename;
        this.roomway=roomway;
        this.bookable=true;
    }
    public Movie(String moviename, String roomway) {
        super();
        this.moviename=moviename;
        this.roomway=roomway;
    }
    
    public Movie() {
        super();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getRoomway() {
        return roomway;
    }

    public void setRoomway(String roomway) {
        this.roomway = roomway;
    }
    public Boolean getBookable() {
        return bookable;
    }

    public void setBookable(Boolean bookable) {
        this.bookable = bookable;
    }
}
