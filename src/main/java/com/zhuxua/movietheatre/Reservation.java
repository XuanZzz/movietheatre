package com.zhuxua.movietheatre;

public class Reservation {
    public String getId() {
        return id;
    }

    public int getNumSeats() {
        return numSeats;
    }

    private String id;
    private int numSeats;

    public Reservation(String id, int numSeats) {
        this.id = id;
        this.numSeats = numSeats;
    }
}
