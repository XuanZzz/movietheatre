package com.zhuxua.movietheatre;

import com.zhuxua.movietheatre.MovieTheatreSeat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTheatreSeatTest {
    private static MovieTheatreSeat movieTheatreSeat;
    @BeforeAll
    static void setUp() {
        movieTheatreSeat = new MovieTheatreSeat(0, 1, 100);
    }
    @Test
    void getScore() {
        assertEquals(100, movieTheatreSeat.getScore());
    }

    @Test
    void getRow() {
        assertEquals(0, movieTheatreSeat.getRow());
    }

    @Test
    void getCol() {
        assertEquals(1, movieTheatreSeat.getCol());
    }

    @Test
    void getName() {
        assertEquals("A1", movieTheatreSeat.getName());
    }

    @Test
    void isAvailable() {
        assertEquals(true, movieTheatreSeat.isAvailable());
    }

    @Test
    void setAvailable() {
        movieTheatreSeat.setAvailable(false);
        assertEquals(false, movieTheatreSeat.isAvailable());
    }

}